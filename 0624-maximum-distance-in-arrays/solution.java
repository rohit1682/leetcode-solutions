class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;
        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        int first, last;
        for (int i = 1; i < arrays.size(); i++) {
            first = arrays.get(i).get(0);
            last = arrays.get(i).get(arrays.get(i).size() - 1);
            maxDistance = Math.max(maxDistance, Math.max(last - min, max - first));
            min = Math.min(min, first);
            max = Math.max(last, max);
        }
        return maxDistance;
    }
}