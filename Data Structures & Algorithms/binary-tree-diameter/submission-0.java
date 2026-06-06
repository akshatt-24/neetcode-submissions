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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int d = height(root);
        return dia;
    }
    int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);

        int td = left + right;
        dia = Math.max(dia , td);

        return Math.max(left,right) + 1;
    }
}
