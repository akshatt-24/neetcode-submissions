/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                res.append("#,");
                continue;
            }
            if(node != null){
                res.append(node.val + ",");
            }
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if(data == null || data.isEmpty()) return null;

    String[] values = data.split(",");

    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    int i = 1;

    while(!q.isEmpty() && i < values.length) {
        TreeNode parent = q.poll();

        if(!values[i].equals("#")) {
            TreeNode left = new TreeNode(Integer.parseInt(values[i]));
            parent.left = left;
            q.offer(left);
        }
        i++;

        if(i < values.length && !values[i].equals("#")) {
            TreeNode right = new TreeNode(Integer.parseInt(values[i]));
            parent.right = right;
            q.offer(right);
        }
        i++;
    }

    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));