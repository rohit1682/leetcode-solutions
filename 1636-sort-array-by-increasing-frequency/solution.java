class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {                            
            ans.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Collections.sort(ans, (a, b) ->                 
            (map.get(a) == map.get(b))? b - a : map.get(a) - map.get(b)
        );

        return ans.stream().mapToInt(i -> i).toArray(); 
    }
}