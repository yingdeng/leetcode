/**
 * Definition for binary tree
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @returns {boolean}
 */
var isSymmetric = function(root) {
    if (root === null) {
        return true;
    }
    return helper(root.left, root.right);
};

var helper = function(root1, root2) {
    if (root1 === null && root2 === null) {
        return true;
    }
    if (root1 === null || root2 === null) {
        return false;
    }
    if (root1.val != root2.val) {
        return false;
    }
    return helper(root1.left, root2.right) && helper(root1.right, root2.left);
};