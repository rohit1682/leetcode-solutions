import java.util.Arrays;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;

        
        int evenCount = (n + 1) / 2;  
        int oddCount = n / 2; 
        
        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even[i / 2] = nums[i];
            } else {
                odd[i / 2] = nums[i];
            }
        }
        
        
        Arrays.sort(even);
        
        
        Arrays.sort(odd);
        for (int i = 0; i < oddCount / 2; i++) {
            int temp = odd[i];
            odd[i] = odd[oddCount - i - 1];
            odd[oddCount - i - 1] = temp;
        }

        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = even[i / 2];
            } else {
                nums[i] = odd[i / 2];
            }
        }

        return nums;
    }
}
