/**
 * Definition for binary tree
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @returns {boolean}
 */
var isSameTree = function(p, q) {
    if (p === null && q === null) {
        return true;
    }
    if (p === null || q === null) {
        return false;
    }
    if (p.val != q.val) {
        return false;
    }
    var isLeftSame = isSameTree(p.left, q.left);
    if (!isLeftSame) {
        return false;
    }
    var isRightSame = isSameTree(p.right, q.right);
    if (!isRightSame) {
        return false;
    }
    return true;
    
    /*
    //Another quick way for solving this question in JAVA
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
          return true;
      }  
      
      if (p == null || q == null) {
          return false;
      }
      
      if (p.val != q.val) {
          return false;
      }
      
      boolean left = isSameTree(p.left, q.left);
      boolean right = isSameTree(p.right, q.right);
      
      return (left && right); 
    }
    */
};
