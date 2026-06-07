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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return check(root , k).val;
    }
    private TreeNode check(TreeNode node, int k) {
        if(node == null) {
            return null;
        }
        TreeNode left = check(node.left, k);
        if(left != null) {
            return left;
        }
        count++;
        if(count == k) {
            return node;
        }
        return check(node.right, k);
    }
}