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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return fun(preorder, inorder, 0, preorder.length-1, 0, inorder.length);
    }
    private TreeNode fun(int[] pre, int[] in, int i, int j, int k, int l){
        if(i>j)return null;
        int mid = k;
        for(int m = k; m<=l; m++){
            if(pre[i] == in[m]){
                mid = m;
                break;
            }
        }
        TreeNode left = fun(pre, in, i+1, i+(mid-k), k, mid-1);
        TreeNode right = fun(pre, in, i+(mid-k)+1,j,mid+1, l);
        TreeNode curr = new TreeNode(pre[i]);
        curr.left = left;
        curr.right = right;
        return curr;
    }
}
