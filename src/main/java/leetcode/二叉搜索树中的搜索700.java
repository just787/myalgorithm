package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/17 21:17
 * @version: 1.0
 */
public class 二叉搜索树中的搜索700 {
/*
    给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

    例如，

    给定二叉搜索树:

            4
            / \
            2   7
            / \
            1   3

    和值: 2
    你应该返回如下子树:

            2
            / \
            1   3
    在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
*/


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        TreeNode n = searchBST(treeNode, 1);
        System.out.println(n);
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val) {
            return root;
        }

        // 二叉搜索树（BST）：左边的节点值小于右边的节点值
        if (val < root.val) {
            root = searchBST(root.left, val);
        } else {
            root = searchBST(root.right, val);
        }

        return root;
    }


    public static TreeNode searchBST1(TreeNode root, int val) {
        // 二叉搜索树（BST）：左边的节点值小于右边的节点值
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }

        return root;
    }
}
