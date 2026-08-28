class KthLargest {

    public int k ;
     public ArrayList<Integer> list;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<>();
        for(int num : nums)
        {
            add(num);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list,Collections.reverseOrder());
        if (list.size() > k) { 
            list.remove(list.size() - 1);
        }
        
        
        return list.get(list.size() - 1);
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */