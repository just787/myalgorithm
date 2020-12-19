package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/19 21:20
 * @version: 1.0
 */
public class 二叉树的深度剑指Offer55 {
/*
    输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
    例如：
    给定二叉树 [3,9,20,null,null,15,7]，

            3
           / \
           9 20
            /  \
           15  7
    返回它的最大深度 3 。

    提示：

    节点总数 <= 10000
*/


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        System.out.println(maxDepth(treeNode));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @description: 方法一：后序遍历（DFS）
     * 树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现。
     * 关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1 。
     * @author: leo
     * @createDate: 2020/12/19 22:17
     * @version: 1.0
     */
    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth1 = maxDepth(root.left);
        int depth2 = maxDepth(root.right);

        return Math.max(depth1, depth2) + 1;
    }

    /**
     * @description: 方法二：层序遍历（BFS）
     * 树的层序遍历 / 广度优先搜索往往利用 队列 实现。
     * 关键点： 每遍历一层，则计数器 +1+1 ，直到遍历完成，则可得到树的深度。
     * @author: leo
     * @createDate: 2020/12/19 22:06
     * @version: 1.0
     */
    public static int maxDepth1(TreeNode root) {

        int depth = 0;
        if (root == null) {
            return depth;
        }

        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;

        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }
            depth++;
            queue = tmp;
        }

        return depth;
    }

}
