# LeetCode Solutions

My solutions to [LeetCode](https://leetcode.com) problems, organized by problem number.

## 📁 Structure

Each problem lives in its own folder at the repo root, named `<number>-<problem-slug>`:

```
leetcode-solutions/
├── 0001-two-sum/
│   ├── README.md          # Problem statement + difficulty
│   └── solution.py        # My accepted solution
├── 0002-add-two-numbers/
│   ├── README.md
│   └── solution.java
├── ...
├── utils/
│   └── leetcode_export.py # Bulk-export helper (see below)
├── .env.example           # Template for the export script's credentials
└── .gitignore
```

## 🔄 Keeping this repo in sync

New solutions get added here in one of three ways:

1. **Automatically** — [LeetHub v2/v3](https://github.com/QasimWani/LeetHub) browser extensions push each accepted solution into the repo root as I solve it.
2. **Manually** — solve a problem, create a folder for it, drop in the code.
3. **Bulk export** — using `utils/leetcode_export.py` (below) to pull everything accepted on my LeetCode account in one go and backfill anything missing.

All three write solution folders to the **repo root** (not into `utils/`), so everything stays in one place.

## 🛠️ Using `utils/leetcode_export.py`

This script pulls all **Accepted** submissions from my LeetCode account via LeetCode's API and writes them into the repo root, one folder per problem, each with the problem statement and my solution code.

### Requirements

```bash
pip install requests
```

### 1. Get your session cookies

The script authenticates as you using two cookies from an active LeetCode browser session:

1. Log into [leetcode.com](https://leetcode.com).
2. Open DevTools (`F12`) → **Application** tab (Chrome) or **Storage** tab (Firefox) → **Cookies** → `https://leetcode.com`.
3. Copy the values of:
   - `LEETCODE_SESSION`
   - `csrftoken`

⚠️ **Treat these like a password.** They expire periodically — if the script starts failing with a `403`, just grab fresh values.

### 2. Put them in a `.env` file

Copy the template and fill in the two values you just copied:

```bash
cp .env.example .env
```

Then edit `.env` in the repo root:

```dotenv
LEETCODE_SESSION="paste_the_LEETCODE_SESSION_cookie_value_here"
CSRF_TOKEN="paste_the_csrftoken_cookie_value_here"
```

`.env` is listed in `.gitignore`, so your credentials are **never committed**. (You can also override either value with a real shell environment variable of the same name if you prefer.)

### 3. Run the script

Run it from anywhere — it always writes to the repo root, no matter your current directory:

```bash
python utils/leetcode_export.py
```

### 4. Review and push

```bash
git status              # see what's new/changed
git add .
git commit -m "Sync solutions from LeetCode"
git push
```

### Notes

- The script deduplicates by problem + language, keeping the most recent accepted submission for each.
- If a problem was solved in multiple languages, each gets its own `solution.<ext>` — check the script if you need per-language subfolders instead of one file overwriting the other.
- Safe to re-run any time — it only touches folders for problems it has data for, and won't wipe out unrelated files in the repo.

## 📊 Stats

<!-- Optional: update manually or automate with a badge/action later -->
- Problems solved: _TBD_
- Languages used: _TBD_

## 📝 License

Solutions are shared for reference and learning purposes.
