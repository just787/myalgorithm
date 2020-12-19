package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/15 21:24
 * @version: 1.0
 */
public class 合并二叉树617 {
/*
    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

    你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

    示例 1:

    输入:
        Tree 1                     Tree 2
              1                         2
             / \                       / \
            3   2                     1   3
           /                           \   \
          5                             4   7
    输出:
    合并后的树:
             3
            / \
           4   5
          / \   \
         5   4   7
    注意: 合并必须从两个树的根节点开始。
*/


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t1_L1 = new TreeNode(3);
        TreeNode t1_R1 = new TreeNode(2);
        t1.setLeft(t1_L1);
        t1.setRight(t1_R1);

        TreeNode t2 = new TreeNode(2);
        TreeNode t2_R1 = new TreeNode(3);
        t2.setRight(t2_R1);

        TreeNode treeNode = mergeTrees(t1, t2);
        System.out.println(treeNode);
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

}
