class Solution {
    public int maxResult(int[] nums, int k) {
        int m = nums.length;
        int[] dp = new int[m];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(0);
        dp[0] = nums[0];
        for(int i = 1; i < m; i++){
            dp[i] = nums[i] + dp[stack.peekFirst()];
            while(!stack.isEmpty() && dp[stack.peekLast()] <= dp[i]){
                stack.pollLast();
            }

            while(!stack.isEmpty() && i - stack.peekFirst() >= k){
                stack.pollFirst();
            }
            stack.offerLast(i);            
        }
        return dp[m - 1];
    }
}