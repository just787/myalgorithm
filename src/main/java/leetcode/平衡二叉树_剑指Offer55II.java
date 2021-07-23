package leetcode;

import java.util.Arrays;
import java.util.Calendar;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/22 20:44
 * @version: 1.0
 */
public class 平衡二叉树_剑指Offer55II {

/*
    输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

    示例 1:

    给定二叉树 [3,9,20,null,null,15,7]

            3
           / \
          9  20
            /  \
           15   7
    返回 true 。

    示例 2:

    给定二叉树 [1,2,2,3,3,null,null,4,4]

            1
           / \
          2   2
         / \
        3   3
       / \
      4   4
    返回 false 。

    限制：

    1 <= 树的结点个数 <= 10000
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


        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String week = String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println(year + "" + week + "");  // 20201


        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        DoubleSummaryStatistics stats = numbers.stream().mapToDouble(x -> x*x).summaryStatistics();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        List<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }}, tmp;


        int depth = 0;
        while (!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : queue) {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
            }

            depth++;
            queue = tmp;
        }

        return false;
    }
}
