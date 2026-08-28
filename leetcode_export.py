#!/usr/bin/env python3
"""
leetcode_export.py

Pulls all your ACCEPTED LeetCode submissions and writes them into a folder
structure ready to `git init` / commit / push to GitHub.

Setup:
  1. Log into leetcode.com in your browser.
  2. Open DevTools -> Application (Chrome) or Storage (Firefox) -> Cookies -> https://leetcode.com
  3. Copy the value of the cookie named "LEETCODE_SESSION"
     (also grab "csrftoken" the same way).
  4. Run:
       pip install requests
       LEETCODE_SESSION="paste_here" CSRF_TOKEN="paste_here" python3 leetcode_export.py

Output:
  ./leetcode-solutions/<number>-<slug>/solution.<ext>
  ./leetcode-solutions/<number>-<slug>/README.md   (problem statement)

Then:
  cd leetcode-solutions
  git init
  git add .
  git commit -m "Import existing LeetCode solutions"
  git remote add origin <your-repo-url>
  git branch -M main
  git push -u origin main
"""

import os
import re
import time
import html
import requests

SESSION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfYXV0aF91c2VyX2lkIjoiNzQyNjQxMSIsIl9hdXRoX3VzZXJfYmFja2VuZCI6ImFsbGF1dGguYWNjb3VudC5hdXRoX2JhY2tlbmRzLkF1dGhlbnRpY2F0aW9uQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6ImEwNDQ3MGQ1YmFmMDAyZTZlZmZmODY2YzNlMmVjNjY5Y2I4OWJmNjM2Y2EzZDRiMzQ0NTJlZmM1ZDIzOWRkYjYiLCJzZXNzaW9uX3V1aWQiOiI4MjlkZTYyZiIsImlkIjo3NDI2NDExLCJlbWFpbCI6InJodC5naHMxMEBnbWFpbC5jb20iLCJ1c2VybmFtZSI6InJvaGl0RzMzIiwidXNlcl9zbHVnIjoicm9oaXRHMzMiLCJhdmF0YXIiOiJodHRwczovL2Fzc2V0cy5sZWV0Y29kZS5jb20vdXNlcnMvcm9oaXRHMzMvYXZhdGFyXzE3NzAxMTQwMTkucG5nIiwicmVmcmVzaGVkX2F0IjoxNzg3OTE0NDM0LCJpcCI6IjEwMy4yNDIuMTk2Ljg1IiwiaWRlbnRpdHkiOiI2OTY3ZWM3MjYxYjNjYmU2YTkxZDc5OGM2Yjk1MWM2MCIsImRldmljZV93aXRoX2lwIjpbImExYjY4YzgwMDZmZGMyMDc1MTAyYjM0MThmYTg5ZmJhIiwiMTAzLjI0Mi4xOTYuODUiXSwiX3Nlc3Npb25fZXhwaXJ5IjoxMjA5NjAwfQ.TCDQ4MGrvGA9y1cQVo9ot3NRvb0wls2dXIYUPEmVn0E"

CSRF = "vizMbe2lOpu0Y3GZXbHfHPMuTov050ED"

if not SESSION or not CSRF:
    raise SystemExit(
        "Set LEETCODE_SESSION and CSRF_TOKEN env vars first (see script docstring)."
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
    # Write everything directly into the repo root (the folder this script lives in),
    # regardless of the current working directory it's invoked from.
    out_dir = os.path.dirname(os.path.abspath(__file__))

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
