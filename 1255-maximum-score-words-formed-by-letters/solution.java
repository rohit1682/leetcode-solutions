class Solution {
	public int maxScoreWords(String[] arr, char[] letters, int[] score) {
		int[] freq = new int[26];
		for (int i = 0; i < letters.length; i++) {
			freq[letters[i] - 'a']++;
		}

		int ans = helper(arr, freq, score, 0);
		return ans;
	}

	public int helper(String[] arr, int[] temp, int[] score, int index) {
		if (index == arr.length) {
			return 0;
		}
		int ans1 = helper(arr, temp, score, index + 1);
		int ans2 = 0;
		boolean flag = true;
		int maximumScore = 0;
		for (int i = 0; i < arr[index].length(); i++) {
			char ch = arr[index].charAt(i);
			if (temp[ch - 'a'] <= 0) {
				flag = false;
			}
			temp[ch - 'a']--;
			maximumScore += score[ch - 'a'];
		}

		if (flag) {
			ans2 = maximumScore + helper(arr, temp, score, index + 1);
		}
		int n = arr[index].length();
		for (int i = 0; i < n; i++) {
			char ch = arr[index].charAt(i);
			temp[ch - 'a']++;
		}
		return Math.max(ans1, ans2);
	}
}