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
        if (root == null) return true;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Long> lows = new LinkedList<>();
        Queue<Long> highs = new LinkedList<>();

        nodes.offer(root);
        lows.offer(Long.MIN_VALUE);
        highs.offer(Long.MAX_VALUE);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            long low = lows.poll();
            long high = highs.poll();

            if (node.val <= low || node.val >= high) {
                return false;
            }

            if (node.left != null) {
                nodes.offer(node.left);
                lows.offer(low);
                highs.offer((long) node.val);
            }

            if (node.right != null) {
                nodes.offer(node.right);
                lows.offer((long) node.val);
                highs.offer(high);
            }
        }

        return true;
    }
}
