package leetcode;

/**
 * @description: TODO
 * @author: leo
 * @createDate: 2020/11/25 0:00
 * @version: 1.0
 */
public class 删除中间节点0203 {
/*
    实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。

    示例：

    输入：单向链表a->b->c->d->e->f中的节点c
    结果：不返回任何数据，但该链表变为a->b->d->e->f
*/

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        deleteNode(b);

        System.out.println(a);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        //思路：将下一个结点的值赋给当前节点，当前节点的下一个结点为下下一个结点。
        //假设要删除c, a->b->c->d->e->f 变为 a->b->d->d->e->f 然后把第一个d的next设为e，跳过第二个d
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
