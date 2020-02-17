package timcat.leetcode.xiaoxiang.linkedList;
public class LinkedListArithmetic {
    //　转置整一条链表
    void reverseAll(Linked_list list){
        // 链表对象不能为空
        if(list == null){
            return;
        }
        Node newHead = null;
        Node head = list.head;
        Node next;
        // 链表为空时，不会进入循环，后续操作没有问题
        while(head != null){
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        list.head = newHead;
    }

    //
    void reversePartly(Linked_list list){
          
    }

    void printList(Linked_list list){
        if(list == null ||list.head == null){
            System.out.println("null");
            return;
        }
        Node node = list.head;
        while (node != null){
            if(node.next != null){
                System.out.print("[" + node.value + "] -> ");
            }else{
                System.out.println("[" + node.value + "]");
            }
            node = node.next;
        }
    }
}
