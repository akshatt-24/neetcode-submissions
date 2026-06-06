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
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return ans;

        q.offer(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();

            for(int i = 0; i < levelSize ; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);

                if(i == levelSize - 1) {
                    ans.add(curr.val);
                }
            }
        }
        return ans;
    }
}
