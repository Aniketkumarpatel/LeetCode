import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> roots = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for (TreeNode t : trees) {
            roots.put(t.val, t);
            count.put(t.val, count.getOrDefault(t.val, 0) + 1);
            if (t.left != null)
                count.put(t.left.val, count.getOrDefault(t.left.val, 0) + 1);
            if (t.right != null)
                count.put(t.right.val, count.getOrDefault(t.right.val, 0) + 1);
        }

        TreeNode root = null;
        for (TreeNode t : trees) {
            if (count.get(t.val) == 1) {
                root = t;
                break;
            }
        }

        if (root == null) return null;

        Set<Integer> used = new HashSet<>();
        roots.remove(root.val);

        if (!dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE, roots, used))
            return null;

        if (!roots.isEmpty()) return null;

        return root;
    }

    private boolean dfs(TreeNode node, int min, int max,
                        Map<Integer, TreeNode> roots, Set<Integer> used) {

        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        if (node.left == null && node.right == null && roots.containsKey(node.val)) {
            TreeNode merge = roots.remove(node.val);
            node.left = merge.left;
            node.right = merge.right;
        }

        return dfs(node.left, min, node.val, roots, used) &&
               dfs(node.right, node.val, max, roots, used);
    }
}