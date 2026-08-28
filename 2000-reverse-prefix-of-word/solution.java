class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        if(index == -1)
        {
            return word;
        }

        StringBuilder str1 = new StringBuilder();

        str1.append(word.substring(0,index+1));
        str1.reverse();

        str1.append(word.substring(index+1, word.length()));

        return (str1.toString());

    }
}
