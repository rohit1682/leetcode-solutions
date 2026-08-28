class Solution {
    public boolean canReach(int[] arr, int start) {

        if(start>=0 && start<arr.length && arr[start]>=0)
        {
            if(arr[start] == 0)
            {
                return true;
            }

            arr[start]=-arr[start];
            return ( (canReach(arr, start+arr[start])) || (canReach(arr, start-arr[start])) );
        }         

        return false;
    }

    // boolean check(int[] arr, int counter, int iteration, int start)
    // {
    //     if(arr[counter] == 0)
    //     {
    //         return true;
    //     }

    //     if(iteration == arr.length || arr[counter] == arr[start])
    //     {
    //         return false;
    //     }

    //     return check(arr, (counter+arr[counter]), iteration++, start) || 
    //            check(arr, (counter-arr[counter]), iteration++, start); 
    // }
}