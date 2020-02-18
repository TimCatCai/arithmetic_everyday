package timcat.leetcode.xiaoxiang.linkedList;

public class LinkedListArithmetic {
    //　转置整一条链表
    void reverseAll(Linked_list list) {
        // 链表对象不能为空
        if (list == null) {
            return;
        }
        Node newHead = null;
        Node head = list.head;
        Node next;
        // 链表为空时，不会进入循环，后续操作没有问题
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        list.head = newHead;
    }

    /**
     * 转置链表的部分
     * 这里因为没有记录链表的节点个数，所以不检测m,n的合理性
     *
     * @param list 即将转置的链表
     * @param m    开始转置的节点坐标，从1开始，若小于１则默认不转置
     * @param n    转置的结束节点坐标, 若n大于链表的长度，则默认转置到链表尾，若n<=m默认不转置．
     */
    void reversePartly(Linked_list list, int m, int n) {
        int beginIndex = 1;
        if (list == null || list.head == null || m < beginIndex || n <= m) {
            return;
        }
        Node preHead = null;
        Node beiginNode = list.head;
        int start = m;
        int end = n;
        while (beiginNode != null && m > beginIndex) {
            m--;
            preHead = beiginNode;
            beiginNode = beiginNode.next;
        }
        Node tail = beiginNode;
        Node node = beiginNode;
        Node postTail = beiginNode;
        Node newHead = null;
        m = start;
        while (m <= end && postTail != null){
            postTail = postTail.next;
            node.next = newHead;
            newHead = node;
            node = postTail;
            m++;
        }
        // 这里的判断是为解决当m大于链表长度，即逆置的起始坐标大于链表长度时，tail = null;
        //　此种情况对其他位置没有影响
        if(tail != null){
            tail.next = postTail;
        }
        if (preHead == null) {
            list.head = newHead;
        }else {
            preHead.next = newHead;
        }
    }

    void printList(Linked_list list) {
        if (list == null || list.head == null) {
            System.out.println("null");
            return;
        }
        Node node = list.head;
        while (node != null) {
            if (node.next != null) {
                System.out.print("[" + node.value + "] -> ");
            } else {
                System.out.println("[" + node.value + "]");
            }
            node = node.next;
        }
    }
}
