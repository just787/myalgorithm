package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/12/1 21:01
 * @version: 1.0
 */
public class 删除链表中的节点237 {
    /*

        请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

        现有一个链表 -- head = [4,5,1,9]，它可以表示为: 4->5->1->9

        示例 1：

        输入：head = [4,5,1,9], node = 5
        输出：[4,1,9]
        解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
        示例 2：

        输入：head = [4,5,1,9], node = 1
        输出：[4,5,9]
        解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
                 
        提示：

        链表至少包含两个节点。
        链表中所有节点的值都是唯一的。
        给定的节点为非末尾节点并且一定是链表中的一个有效节点。
        不要从你的函数中返回任何结果。
    */
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        deleteNode(a, b);
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode a, ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
