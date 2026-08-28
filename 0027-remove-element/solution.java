class Solution {
    static void sort(int[] nums, int low, int high, int val) {
        if (low < high) {
            int p = part(nums, low, high, val);

            sort(nums, low, p - 1, val);
            sort(nums, p + 1, high, val);
        }
    }

    static int part(int[] nums, int low, int high, int val) {
        int pivot = val;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] != pivot) {
                i++;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    public int removeElement(int[] nums, int val) {
        
        sort(nums, 0, nums.length-1, val);

        int k=0;
        for(int x: nums)
        {
            if(x!=val)
            {
                k++;
            }
        }

        return k;
    }
}