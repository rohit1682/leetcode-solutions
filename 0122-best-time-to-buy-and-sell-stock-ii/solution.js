/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let ans = 0;
    let buy = true;
    let cp = -1;
    let sp = -1;

    for(let i=0; i<prices.length-1; i++) {
        if(buy === true) {
            if(prices[i] > prices[i+1]) continue;
            else {
                buy = false;
                cp = prices[i];
            }
        }

        else {
            if(prices[i] < prices[i+1]) continue;
            else {
                buy = true;
                sp = prices[i];
                ans += sp-cp;
                cp = -1;
                sp = -1;
            }
        }
    }

    if(!buy && cp !== -1) ans += prices[prices.length-1] - cp;

    return ans;
};