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
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> tree = new LinkedList<>();
        int ans = 0;
        tree.add(root);
        while(tree.size()>0){
            int n = tree.size();
            for(int i=0;i<n;i++){
                TreeNode temp = tree.poll();
                if(temp.left!= null)tree.add(temp.left);
                if(temp.right!=null)tree.add(temp.right);
            }
            ans++;
        }
        return ans;
    }
}
