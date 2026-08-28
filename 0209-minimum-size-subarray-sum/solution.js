/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(target, nums) {
    let l=nums.length;
    let ans=Number.MAX_VALUE;
    let sum=0;
    if(nums.includes(target)){
        return 1;
    }
    let j=0;
    let temp=0;
    for(let i=0;i<l;i++){
        temp+=nums[i];
    }
    if(temp<target){
        return 0;
    }
    for(let i=0;i<l;i++){
        sum+=nums[i];
        while(sum>=target){
            ans=Math.min(ans,i-j+1);
            sum-=nums[j];
            j++;
        }
    }
    return ans;
};