import java.util.ArrayList;
import java.util.Collections;

class MedianFinder {
    public ArrayList<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
       int index=BinarySearch(num);
       list.add(index,num);
    }

    public int BinarySearch(int num)
    {
         int left=0;
         int right=list.size();
         while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }
    
    public double findMedian() {
        
        int n = list.size();

        if (n == 0) {
            throw new IllegalStateException("No elements in the list to find the median");
        }

        if (n % 2 == 1) {  
            return list.get(n / 2);
        } else {  
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
