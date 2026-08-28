class Solution 
{
    public List<Integer> addToArrayForm(int[] arr, int k) 
    {
            int i,l=arr.length;      arr[l-1]+=k;
            for(i=l-1;i>0;i--)
            {
                if(arr[i]>=10)
                {
                    arr[i-1]+=arr[i]/10;
                    arr[i]=arr[i]%10;
                }   else    break;
            }
            int digits=(int)Math.log10(arr[0])+1;
            ArrayList<Integer> list = new ArrayList<Integer>(0);
            if(arr[0]>=10)
            for(i=digits-1;i>0;i--)
            {
                list.add(arr[0]/(int)Math.pow(10,i));
                arr[0]=(arr[0]%(int)Math.pow(10,i));
            }
            for(i=0;i<arr.length;i++)
            list.add(arr[i]);
            return list;
    }
}

// class Solution {
//     public List<Integer> addToArrayForm(int[] num, int k) {
//         int index = num.length - 1; 
//         int carry = 0;
//         while(k != 0 || carry != 0) {
//             num[index] += (k % 10) + carry;
//             carry = 0;
//             if(num[index] >= 10) {
//                 carry = 1;
//                 num[index] -= 10;
//             }
//             k /= 10;
//             index--;
//         }

//         List<Integer> integerList = new ArrayList<>();
//         for (int i = 0; i < num.length; i++) {
//             integerList.add(num[i]);
//         }

//         if(carry == 1) {
//             integerList.add(0, 1);
//         }

//         return integerList;
//     }
// }