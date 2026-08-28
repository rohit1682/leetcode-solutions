#!/usr/bin/env python3
"""
leetcode_export.py

Pulls all your ACCEPTED LeetCode submissions and writes them into this repo,
one folder per problem, ready to commit and push to GitHub.

This script lives in `utils/`, but it always writes solution folders to the
REPO ROOT (the parent of `utils/`) — never inside `utils/`. That keeps it
consistent with LeetHub v2/v3, which also drop solution folders in the root.

Setup:
  1. Copy `.env.example` to `.env` in the repo root.
  2. Fill in LEETCODE_SESSION and CSRF_TOKEN (see the README for how to grab them).
  3. Install the one dependency, then run it from anywhere:
       pip install requests
       python utils/leetcode_export.py

Output (relative to the repo root):
  ./<number>-<slug>/solution.<ext>
  ./<number>-<slug>/README.md   (problem statement)
"""

import os
import re
import time
import html
import requests

# ── Paths ────────────────────────────────────────────────────────────────
# This file lives in <repo>/utils/, so the repo root is one directory up.
# Solutions and the .env file are always resolved against the repo root,
# regardless of the current working directory the script is invoked from.
ROOT_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))


def load_env(env_path):
    """Minimal .env loader: one `KEY=VALUE` per line; blank lines and `#`
    comments are ignored. Real environment variables take precedence over
    values in the file, so you can still override with a shell env var."""
    if not os.path.exists(env_path):
        return
    with open(env_path, encoding="utf-8") as f:
        for raw in f:
            line = raw.strip()
            if not line or line.startswith("#"):
                continue
            if line.startswith("export "):
                line = line[len("export "):]
            if "=" not in line:
                continue
            key, _, value = line.partition("=")
            os.environ.setdefault(key.strip(), value.strip().strip('"').strip("'"))


load_env(os.path.join(ROOT_DIR, ".env"))

SESSION = os.environ.get("LEETCODE_SESSION", "")
CSRF = os.environ.get("CSRF_TOKEN", "")

if not SESSION or not CSRF:
    raise SystemExit(
        "Missing credentials. Copy .env.example to .env in the repo root and set "
        "LEETCODE_SESSION and CSRF_TOKEN (see the README for how to get them)."
    )

BASE_URL = "https://leetcode.com"
GRAPHQL_URL = f"{BASE_URL}/graphql"

HEADERS = {
    "content-type": "application/json",
    "x-csrftoken": CSRF,
    "referer": "https://leetcode.com",
    "user-agent": "Mozilla/5.0",
}
COOKIES = {
    "LEETCODE_SESSION": SESSION,
    "csrftoken": CSRF,
}

EXT_MAP = {
    "python": "py", "python3": "py", "java": "java", "c": "c", "cpp": "cpp",
    "csharp": "cs", "javascript": "js", "typescript": "ts", "php": "php",
    "swift": "swift", "kotlin": "kt", "golang": "go", "ruby": "rb",
    "scala": "scala", "rust": "rs", "racket": "rkt", "erlang": "erl",
    "elixir": "ex", "dart": "dart",
}


def gql(query, variables):
    resp = requests.post(
        GRAPHQL_URL,
        json={"query": query, "variables": variables},
        headers=HEADERS,
        cookies=COOKIES,
        timeout=30,
    )
    resp.raise_for_status()
    data = resp.json()
    if "errors" in data:
        raise RuntimeError(data["errors"])
    return data["data"]


def get_all_accepted_submissions():
    """Paginate through submission list, keep only Accepted ones, dedupe by problem+lang."""
    query = """
    query submissions($offset: Int!, $limit: Int!) {
      submissionList(offset: $offset, limit: $limit) {
        hasNext
        submissions {
          id
          title
          titleSlug
          statusDisplay
          lang
          timestamp
        }
      }
    }
    """
    seen = {}
    offset = 0
    limit = 20
    while True:
        data = gql(query, {"offset": offset, "limit": limit})
        sl = data["submissionList"]
        for s in sl["submissions"]:
            if s["statusDisplay"] == "Accepted":
                key = (s["titleSlug"], s["lang"])
                # keep most recent (submissions come newest-first)
                if key not in seen:
                    seen[key] = s
        print(f"  scanned offset={offset}, found {len(seen)} unique accepted so far")
        if not sl["hasNext"]:
            break
        offset += limit
        time.sleep(0.3)  # be polite to the API
    return list(seen.values())


def get_submission_code(submission_id):
    query = """
    query submissionDetails($submissionId: Int!) {
      submissionDetails(submissionId: $submissionId) {
        code
        lang { name }
      }
    }
    """
    data = gql(query, {"submissionId": int(submission_id)})
    details = data.get("submissionDetails")
    return details["code"] if details else None


def get_problem_content(title_slug):
    query = """
    query questionContent($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionFrontendId
        title
        content
        difficulty
      }
    }
    """
    data = gql(query, {"titleSlug": title_slug})
    return data["question"]


def strip_html(raw_html):
    text = html.unescape(raw_html or "")
    text = re.sub(r"<[^>]+>", "", text)
    return text.strip()


def main():
    # Always write into the repo root (the parent of utils/), regardless of
    # where the script is launched from.
    out_dir = ROOT_DIR

    print("Fetching submission list (this walks your full history, may take a bit)...")
    submissions = get_all_accepted_submissions()
    print(f"Found {len(submissions)} unique accepted (problem, language) pairs.\n")

    problem_cache = {}

    for i, s in enumerate(submissions, 1):
        slug = s["titleSlug"]
        lang = s["lang"]
        ext = EXT_MAP.get(lang, "txt")

        print(f"[{i}/{len(submissions)}] {slug} ({lang})")

        if slug not in problem_cache:
            try:
                problem_cache[slug] = get_problem_content(slug)
            except Exception as e:
                print(f"  ! failed to fetch problem content: {e}")
                problem_cache[slug] = None
            time.sleep(0.3)

        q = problem_cache[slug]
        number = q["questionFrontendId"] if q else "0"
        folder_name = f"{int(number):04d}-{slug}" if q else slug
        folder_path = os.path.join(out_dir, folder_name)
        os.makedirs(folder_path, exist_ok=True)

        # README with problem statement (once per problem)
        readme_path = os.path.join(folder_path, "README.md")
        if q and not os.path.exists(readme_path):
            desc = strip_html(q["content"])
            with open(readme_path, "w", encoding="utf-8") as f:
                f.write(f"# {number}. {q['title']}\n\n")
                f.write(f"**Difficulty:** {q['difficulty']}\n\n")
                f.write(desc + "\n")

        # Code file
        try:
            code = get_submission_code(s["id"])
        except Exception as e:
            print(f"  ! failed to fetch code: {e}")
            code = None
        time.sleep(0.3)

        if code:
            code_path = os.path.join(folder_path, f"solution.{ext}")
            with open(code_path, "w", encoding="utf-8") as f:
                f.write(code)
        else:
            print(f"  ! no code retrieved for {slug} ({lang})")

    print(f"\nDone. Solutions written to {out_dir}")
    print("Next steps:")
    print("  git add . && git commit -m \"Import existing LeetCode solutions\"")
    print("  git push")


if __name__ == "__main__":
    main()
