class Solution {
    public int hammingWeight(int n) {

        String bin = Integer.toBinaryString(n);
        return (int) ( bin.chars().filter(ch -> ch == '1').count());
    }
}