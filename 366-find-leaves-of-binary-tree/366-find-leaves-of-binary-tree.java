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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        
        if (root == null) {
            return output;
        }
        
        while (root.left != null || root.right != null) {
            output.add(collectAndRemoveLeaves(root));
        }
        
        List<Integer> leaves = new ArrayList<>();
        leaves.add(root.val);
        output.add(leaves);
        
        return output;
    }
    
    private List<Integer> collectAndRemoveLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        
        if (root == null) {
            return leaves;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if (node.left != null && node.left.left == null && node.left.right == null) {
                leaves.add(node.left.val);
                node.left = null;
            }
            if (node.right != null && node.right.left == null && node.right.right == null) {
                leaves.add(node.right.val);
                node.right = null;
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return leaves;
    }
}