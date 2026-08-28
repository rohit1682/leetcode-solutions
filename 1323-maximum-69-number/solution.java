class Solution {
    public int maximum69Number (int num) {
        String number =Integer.toString(num);
        char[] digit = number.toCharArray();

        for(int i=0;i<digit.length;i++)
        {if(digit[i]=='6')
        {
            digit[i]='9';
            break;
        }
        }
        return Integer.parseInt(new String(digit));
    }
}