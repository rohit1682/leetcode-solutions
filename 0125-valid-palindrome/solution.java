class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("\\s", "");
        str = removeChar(str);
        str = str.toLowerCase();

        boolean isPalindrome = true;
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        if (isPalindrome) {
            return true;
        } else {
            return false;
        }
    }

    String removeChar(String str)
    {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                res += c;
            }
        }
        return res;
    }
}