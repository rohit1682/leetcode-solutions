/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
    let ans = 0;
    const minHeap = new MinPriorityQueue({priority : x => x});
    for(num of nums)
        minHeap.enqueue(num);
    while(minHeap.front().element < k){
        let x = minHeap.dequeue().element;
        let y = minHeap.dequeue().element;
        minHeap.enqueue(x*2+y);
        ans++;
    }
    return ans;
};


// time limit exceeding for very big array length
// var minOperations = function(nums, k) {
//     if(nums.length < 2) return 0;
//     let count = 0;
//     nums.sort(function(a,b) {
//         return a-b;
//     });
//     while(nums[0] < k) {
//         nums[1] = (nums[0]*2)+nums[1];
//         count++;
//         nums.splice(0,1);
//         nums.sort(function(a,b) {
//             return a-b;
//         });
//     }
//     return count;
// };
