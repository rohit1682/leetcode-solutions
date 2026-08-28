/**
 * @param {number[]} tasks
 * @return {number}
 */
var minimumRounds = function(tasks) {
    let rounds = 0;

    const freq = tasks.reduce((map, task) => {
        map.set(task, (map.get(task) || 0) + 1);
        return map;
    }, new Map());

    for(const [key, value] of freq) {
        if (value === 1) return -1;

        if (value % 3 === 0) {
            rounds += value / 3;
        } else if (value % 3 === 1) {
            rounds += Math.floor(value / 3) - 1 + 2;
        } else {
            rounds += Math.floor(value / 3) + 1;
        }
    }
    
    return rounds;
};