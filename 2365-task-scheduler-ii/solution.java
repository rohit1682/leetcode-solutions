class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long current = 0;
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i]) && (current - map.get(tasks[i])) <= space) {
                current = map.get(tasks[i]) + space + 1;
            }
            map.put(tasks[i], current);
            current++;
        }
        return current;
    }
}


// class Solution {
//     public long taskSchedulerII(int[] tasks, int space) {
//         long current=0;
//         HashMap<Integer,Long> map = new HashMap<Integer,Long>();
//         int i=0;
//         while(i<tasks.length) {
//             if( (!map.containsKey(tasks[i])) || (current-(map.get(tasks[i])) >= space) ) {
//                 map.put(tasks[i],current);
//                 i++;
//                 current++;
//             } 
//             else {
//                 current++;
//             }
//         }
//         return current;
//     }
// }