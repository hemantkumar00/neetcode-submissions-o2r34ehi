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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null)return ans;
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n;i++){
                TreeNode temp = que.poll();
                if(i == n-1)ans.add(temp.val);
                if(temp.left != null)que.add(temp.left);
                if(temp.right != null)que.add(temp.right);
            }
        }
        return ans;
    }
}
