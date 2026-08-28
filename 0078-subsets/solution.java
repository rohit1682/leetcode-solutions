class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : subsets) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(nums[i]);
                newSubsets.add(newSubset);
            }
            subsets.addAll(newSubsets);
        }
        return subsets; 
    }
}