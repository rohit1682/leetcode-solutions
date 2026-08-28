import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        int expected = 1;
        for (int num : nums) {
           
            while (num > expected) {
                list.add(expected);
                expected++;
            }
            if (num == expected) {
                expected++;
            }
        }

        while (expected <= n) {
            list.add(expected);
            expected++;
        }

        return list;
    }
}
