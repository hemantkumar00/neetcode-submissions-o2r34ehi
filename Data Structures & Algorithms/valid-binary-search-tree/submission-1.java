/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return fun(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
    }
    private boolean fun(int low, int high, TreeNode node){
        if(node == null)return true;
        if(node.val <= low || node.val >= high)return false;
        return fun(low, node.val, node.left) && fun(node.val, high, node.right);
    }
}
