class Solution {
  public long distributeCandies(int n, int limit) {
    long count = 0;
    for (int i = Math.max(0, n - 2 * limit); i <= Math.min(limit, n); i++) {
      int b = Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1;
      count += Math.max(0, b);
    }
    return count;
  }
}