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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        fun(root, al);
        return al.get(k-1);
    }
    private void fun(TreeNode root, ArrayList<Integer> al){
        if(root == null)return;
        fun(root.left, al);
        al.add(root.val);
        fun(root.right, al);
    }
}
