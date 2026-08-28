class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        maxHeap.addAll(map.entrySet());
        int cnt = 0;
        for(int j=1; j <= map.size(); j++){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            if (j <= 8)  /*calculates pushes for used character that should be priotised first and so on for rest of condition according to priority*/
                cnt += entry.getValue();
            else if(j > 8 && j <= 16)
                cnt += entry.getValue()*2;
            else if(j > 16 && j <= 24)
                cnt += entry.getValue()*3;
            else
            cnt += entry.getValue()*4;
        }
        return cnt;
    }
}