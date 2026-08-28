import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                // Add to list if it's a match and not already added
                if (list.isEmpty() || list.get(list.size() - 1)!=nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        int[] array = new int[list.size()];
        for (int x = 0; x < list.size(); x++) {
            array[x] = list.get(x);
        }

        return array;
    }
}
