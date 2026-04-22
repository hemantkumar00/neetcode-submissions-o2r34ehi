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

// class Solution {  
//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//         if(root == null && subRoot == null)return false;
//         if(root == null || subRoot == null)return false;
//         Queue<TreeNode> que = new LinkedList<>();
//         que.add(root);
//         while(!que.isEmpty()){
//             TreeNode node = que.poll();
//             if(node.val == subRoot.val){
//                 if(fun(node, subRoot))return true;
//             }
//             if(node.left!= null)que.add(node.left);
//             if(node.right != null)que.add(node.right);
//         }
//         return false;
//     }
//     private boolean fun(TreeNode one, TreeNode two) {
//         if(one == null && two == null)return true;
//         if(one == null || two == null)return false;
//         if(one.val != two.val)return false;
//         return fun(one.left, two.left) && fun(one.right, two.right); 
//     }
// }

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        serialize(root, sb1);
        serialize(subRoot, sb2);

        return sb1.toString().contains(sb2.toString());
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");   // important for structure
            return;
        }

        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}
