package timcat.leetcode.xiaoxiang.linkedList;


import org.junit.jupiter.api.Test;

class LinkedListArithmeticTest {
    Linked_list list = new Linked_list();
    LinkedListArithmetic arithmetic = new LinkedListArithmetic();
    {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        head.next = listNode;
        listNode.next = new ListNode(3);
        listNode = listNode.next;
        listNode.next = new ListNode(4);
        listNode = listNode.next;
        listNode.next = new ListNode(5);
        list.head = head;
    }
    @Test
    void reverseAll() {
        arithmetic.printList(list);
        arithmetic.reverseAll(list);
        arithmetic.printList(list);
    }

    @Test
    void reversePartly() {
    }

    @Test
    void printList() {
        Linked_list list = null;
        arithmetic.printList(list);
        list = new Linked_list();
        arithmetic.printList(list);
        list.head = new ListNode(1);
        arithmetic.printList(list);
        list.head.next = new ListNode(2);
        arithmetic.printList(list);
        list.head.next.next = new ListNode(3);
        arithmetic.printList(list);
    }
}