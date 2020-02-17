package timcat.leetcode.xiaoxiang.linkedList;


import org.junit.jupiter.api.Test;

class LinkedListArithmeticTest {
    Linked_list list = new Linked_list();
    LinkedListArithmetic arithmetic = new LinkedListArithmetic();
    {
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        node.next = new Node(3);
        node = node.next;
        node.next = new Node(4);
        node = node.next;
        node.next = new Node(5);
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
        list.head = new Node(1);
        arithmetic.printList(list);
        list.head.next = new Node(2);
        arithmetic.printList(list);
        list.head.next.next = new Node(3);
        arithmetic.printList(list);
    }
}