/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

/**
 * @param {string} traversal
 * @return {TreeNode}
 */

function recoverFromPreorder(traversal) {
    const stack = [];
    let pos = 0;
    const n = traversal.length;
    
    while (pos < n) {
        let level = 0;
        let value = '';

        // Count the number of dashes to determine the depth level.
        while (pos < n && traversal[pos] === '-') {
            level++;
            pos++;
        }

        // Read the number, which is this node’s value.
        while (pos < n && traversal[pos] !== '-') {
            value += traversal[pos];
            pos++;
        }
        
        let node = new TreeNode(parseInt(value));
        
        // If the depth of the current node is equal to the stack length, 
        // it is the left child of the previous node.
        // Otherwise, pop from the stack until you find its parent node, then add it as a right child.
        while (stack.length > level) {
            stack.pop();  // Pop until stack length equals level to find parent
        }

        if (stack.length > 0) {
            if (!stack[stack.length - 1].left) {
                stack[stack.length - 1].left = node;
            } else {
                stack[stack.length - 1].right = node;
            }
        }
        
        // Push onto stack regardless to represent depth hierarchy
        stack.push(node);
    }

    // The root is the very first item that was pushed to the stack and never popped.
    return stack[0];
}

// /**
//  * Definition for a binary tree node.
//  * function TreeNode(val, left, right) {
//  *     this.val = (val===undefined ? 0 : val)
//  *     this.left = (left===undefined ? null : left)
//  *     this.right = (right===undefined ? null : right)
//  * }
//  */
// /**
//  * @param {string} traversal
//  * @return {TreeNode}
//  */

// let getNodeValue = function(traversal, n, pos) {
//     let value = 0;
//     let originalPos = pos;
//     while (pos < n && traversal[pos] >= '0' && traversal[pos] <= '9') {
//         value = (value * 10) + (traversal[pos] - '0');
//         pos++;
//     }
//     return { value: value, newPos: pos };
// }

// let getDashLength = function(traversal, n, pos) {
//     let length = 0;
//     while (pos < n && traversal[pos] === '-') {
//         length++;
//         pos++;
//     }
//     return { length: length, newPos: pos };
// }

// let buildTree = function(currentNode, expectedLevel, traversal, n, pos) {
//     if (pos >= n) {
//         return pos;  // Return current position if at the end
//     }
    
//     let dashResult = getDashLength(traversal, n, pos);
//     let currentLevel = dashResult.length;
//     pos = dashResult.newPos;

//     if (currentLevel !== expectedLevel) {
//         return pos; // Return since the current level does not match the expected level
//     }

//     let valueResult = getNodeValue(traversal, n, pos);
//     pos = valueResult.newPos;
//     const newNode = new TreeNode(valueResult.value);

//     if (currentNode.left === null) {
//         currentNode.left = newNode;
//     } else if (currentNode.right === null) {
//         currentNode.right = newNode;
//     }

//     pos = buildTree(newNode, expectedLevel + 1, traversal, n, pos); // Construct left subtree
//     if (currentNode.right !== null) {
//         pos = buildTree(newNode, expectedLevel + 1, traversal, n, pos); // Construct right subtree
//     }

//     return pos;
// }

// var recoverFromPreorder = function(traversal) {
//     if (traversal.length === 0) {
//         return null;
//     }

//     const n = traversal.length;
//     let pos = 0;
    
//     let valueResult = getNodeValue(traversal, n, pos);
//     pos = valueResult.newPos;
//     const root = new TreeNode(valueResult.value);

//     pos = buildTree(root, 1, traversal, n, pos);
//     pos = buildTree(root, 1, traversal, n, pos);

//     return root;
// };


// // /**
// //  * Definition for a binary tree node.
// //  * function TreeNode(val, left, right) {
// //  *     this.val = (val===undefined ? 0 : val)
// //  *     this.left = (left===undefined ? null : left)
// //  *     this.right = (right===undefined ? null : right)
// //  * }
// //  */
// // /**
// //  * @param {string} traversal
// //  * @return {TreeNode}
// //  */


// // let getNodeValue = function(traversal, n, pos) {
// //     let value = 0;
// //     while(pos < n && traversal[pos] >= '0' && traversal[pos] <= '9') {
// //         value = (value*10) + (traversal[pos]-'0');
// //         pos++;
// //     }
// //     return value;
// // }

// // let getDashLength = function(traversal, n, pos) {
// //     let length = 0;
// //     while(pos < n && traversal[pos] === '-') {
// //         length++;
// //         pos++;
// //     }
// //     return length;
// // }

// // let buildTree = function(currentNode, expectedLevel, traversal, n, pos) {
// //     let previousPos = pos;
// //     let currentLevel = getDashLength(traversal, n);

// //     if(currentLevel !== expectedLevel) {
// //         pos = previousPos;
// //         return;
// //     }

// //     const newNode = new TreeNode(getNodeValue(traversal, n, pos));
// //     if(!currentNode.left) currentNode.left = newNode;
// //     else currentNode.right = newNode;

// //     buildTree(newNode, expectedLevel+1, traversal, n, pos);
// //     buildTree(newNode, expectedLevel+1, traversal, n, pos);

// // }

// // var recoverFromPreorder = function(traversal) {
// //     const n = traversal.length;
// //     let pos = 0;

// //     const root = new TreeNode(getNodeValue(traversal, n, pos));
// //     buildTree(root, 1, traversal, n, pos);
// //     buildTree(root, 1, traversal, n, pos);

// //     return root;
// // };