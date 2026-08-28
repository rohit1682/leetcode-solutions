class Solution {

    int[] check(int digits[], int position, int carry)
    {
        if(position == -1 && carry == 1)
        {
            int[] ans = new int[digits.length+1];
            Arrays.fill(ans,0);
            ans[0] = 1;
            return ans;
        }

        digits[position] += carry;

        if(digits[position] >= 10)
        {
            carry = (int) digits[position] / 10;
            digits[position] = (int) digits[position] % 10;
            digits = check(digits, position-1, carry);
        }

        return digits;
    }

    public int[] plusOne(int[] digits) {

        digits[digits.length-1]++;
        digits = check(digits, digits.length-1, 0);

        return digits;


        // if(digits[digits.length-1] >=10 && digits[0] == 9)
        // {
        //     int result[] = new int[digits.length+1];

        //     for(int i=0; i< digits.length; i++)
        //     {
        //         result[i+1] = digits[i]; 
        //     }

        //     result = check(result, result.length-1, 0);

        //     return result;
        // }

        // else
        // {
        //     digits = check(digits, digits.length-1, 0);

        //     return digits;
        // }

        

        
        // int number=0;
        // for(int i=0; i<digits.length; i++)
        // {
        //     number=(number*10)+digits[i];
        // }

        // number++;

        // int j = 0; 
	    // int len = Integer.toString(number).length(); 
	    // int[] arr = new int[len]; 
	    // while(number!=0) 
	    // { 
		//     arr[len-j-1] = number%10; 
	    // 	number=number/10; 
		//     j++; 
	    // } 
	    
        // return arr; 

    }
}