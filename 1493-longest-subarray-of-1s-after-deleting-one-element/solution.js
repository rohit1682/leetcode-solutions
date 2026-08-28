/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {
    if(!nums.includes(0)){
        return nums.length-1;
    }
    let index=-1;
    let count=0;
    let ans=0;
    if(nums[0]==1){
        count++;
    }
    for(let i=1;i<nums.length;i++){
        if(nums[i]==1){
            count++;
            ans=Math.max(ans,count);
        }
        if(nums[i]==0 && index>=0){
            count=i-index-1;
            index=i;
        }
        if(nums[i]==0 && index<0){
            index=i;
        }
       
        ans=Math.max(ans,count);
    }
    return ans;
};
 