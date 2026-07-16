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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        // Edge case : if the root is to be deleted itself
        if(root.val == key) {
            return deleteActualNode(root);
        }

        searchAndDelete(root, key);
        return root;
        
    }
    private void searchAndDelete(TreeNode node, int key ) {
        if(node == null) {
            return ;
        }
        if (node.left != null && node.left.val == key) {
            node.left = deleteActualNode(node.left);
            return;
        }

        if (node.right != null && node.right.val == key) {
            node.right = deleteActualNode(node.right);
            return;
        }

        if (key < node.val) {
            searchAndDelete(node.left, key);
        } else {
            searchAndDelete(node.right, key);
        }
    }

    private TreeNode deleteActualNode(TreeNode node) {
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;

        // If it has 2 children, we find the minimum node in the right subtree
        TreeNode minNode = node.right;
        while(minNode.left != null) {
            minNode = minNode.left;
        }
        // Shift the entire left subtree of the deleted node 
        // to become the left child of that minimum node

        minNode.left = node.left;
        return node.right;
    }
    
}