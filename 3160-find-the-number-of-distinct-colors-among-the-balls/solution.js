/**
 * @param {number} limit
 * @param {number[][]} queries
 * @return {number[]}
 */
function queryResults(limit, queries) {
    const ballToColor = new Map();
    const colorCount = new Map();
    const results = [];

    for (const [ball, newColor] of queries) {
        if (ball > limit) continue; 
        const oldColor = ballToColor.get(ball);
        if (newColor === oldColor) {
            results.push(colorCount.size); 
            continue;
        }
        ballToColor.set(ball, newColor);
        if (oldColor !== undefined) {
            const count = colorCount.get(oldColor) - 1;
            if (count === 0) {
                colorCount.delete(oldColor);
            } else {
                colorCount.set(oldColor, count);
            }
        }
        colorCount.set(newColor, (colorCount.get(newColor) || 0) + 1);
        results.push(colorCount.size);
    }
    return results;
}