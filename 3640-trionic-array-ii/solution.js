/**
 * @param {number[]} nums
 * @return {number}
 */

const NEGETIVE = -1e15

let memo = [];

let solve = function(i, trend, nums) {
    if(i === nums.length) {
        if(trend === 3) {
            return 0;
        }
        else {
            return NEGETIVE/2;
        }
    }

    if (memo[i][trend] !== undefined) {
        return memo[i][trend];
    }

    let take = NEGETIVE/2;
    let skip = NEGETIVE/2;

    if(trend === 0) {
        skip = solve(i+1, 0, nums);
    }
    if(trend === 3) {
        take = nums[i];
    }

    if(i+1 < nums.length) {
        let current = nums[i];
        let next = nums[i+1];

        if(trend === 0 && next > current) {
            take = Math.max(take, current + solve(i+1, 1, nums));
        }
        else if(trend === 1) {
            if(next > current) {
                take = Math.max(take, current + solve(i+1, 1, nums));
            }
            else if(next < current) {
                take = Math.max(take, current + solve(i+1, 2, nums));
            }
        }
        else if(trend === 2) {
            if(next < current) {
                take = Math.max(take, current + solve(i+1, 2, nums));
            }
            else if(next > current) {
                take = Math.max(take, current + solve(i+1, 3, nums));
            }
        }
        else if(trend === 3 && next > current) {
            take = Math.max(take, current + solve(i+1, 3, nums));
        }
    }

    return memo[i][trend] = Math.max(take, skip);
}

var maxSumTrionic = function(nums) {
    
    memo = Array.from({ length: nums.length }, () => Array(4));

    return solve(0, 0, nums, memo);
};