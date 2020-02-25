package timcat.leetcode.xiaoxiang.linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListArithmetic {
    /**
     * leetcode 206 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 逆置整一条链表
     * <p>
     * 方法一：递归求法
     */
    void reverseAll(Linked_list list) {
        // 链表对象不能为空
        if (list == null) {
            return;
        }
        ListNode newHead = null;
        ListNode head = list.head;
        ListNode next;
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
     * leetcode 206 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 逆置整一条链表
     * <p>
     * 方法二：递归求法
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 一直历遍到最后，递归一直返回链表的最后一个节点
        ListNode newHead = reverseList(head.next);
        // 当前head的next域指向的是新链表的最后一个节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * leetcode 206 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 逆置整一条链表
     * <p>
     * 方法三：双指针法
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = head;
        ListNode temp;
        while (next != null) {
            temp = next.next;
            next.next = pre;
            pre = next;
            next = temp;
        }
        return pre;
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 逆置链表的部分
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
        ListNode preHead = null;
        ListNode beiginListNode = list.head;
        int start = m;
        int end = n;
        while (beiginListNode != null && m > beginIndex) {
            m--;
            preHead = beiginListNode;
            beiginListNode = beiginListNode.next;
        }
        ListNode tail = beiginListNode;
        ListNode listNode = beiginListNode;
        ListNode postTail = beiginListNode;
        ListNode newHead = null;
        m = start;
        while (m <= end && postTail != null) {
            postTail = postTail.next;
            listNode.next = newHead;
            newHead = listNode;
            listNode = postTail;
            m++;
        }
        // 这里的判断是为解决当m大于链表长度，即逆置的起始坐标大于链表长度时，tail = null;
        //　此种情况对其他位置没有影响
        if (tail != null) {
            tail.next = postTail;
        }
        if (preHead == null) {
            list.head = newHead;
        } else {
            preHead.next = newHead;
        }
    }

    void printList(Linked_list list) {
        if (list == null || list.head == null) {
            System.out.println("null");
            return;
        }
        ListNode listNode = list.head;
        while (listNode != null) {
            if (listNode.next != null) {
                System.out.print("[" + listNode.val + "] -> ");
            } else {
                System.out.println("[" + listNode.val + "]");
            }
            listNode = listNode.next;
        }
    }

    /**
     * 计算链表的相交结点
     * 编写一个程序，找到两个单链表相交的起始节点。
     * <p>
     * 如下面的两个链表：
     * <p>
     * <p>
     * <p>
     * 在节点 c1 开始相交。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *  
     * <p>
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *  
     * <p>
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     *  
     * <p>
     * 注意：
     * <p>
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return null 没有交点，否则返回链表的交点
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        ListNode result = null;
        while (node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (set.contains(node)) {
                result = node;
                break;
            }
            node = node.next;
        }
        return result;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int aLen = calculateLinkedListLength(headA);
        int bLen = calculateLinkedListLength(headB);
        ListNode longerList;
        ListNode shorterList;
        if (aLen > bLen) {
            longerList = headA;
            shorterList = headB;
        } else {
            longerList = headB;
            shorterList = headA;
        }
        longerList = listMoveForwardDelta(longerList, Math.abs(aLen - bLen));
        while (longerList != null && shorterList != null && longerList != shorterList) {
            longerList = longerList.next;
            shorterList = shorterList.next;
        }
        return longerList;
    }

    public int calculateLinkedListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode listMoveForwardDelta(ListNode head, int delta) {
        while (head != null && delta > 0) {
            head = head.next;
            delta--;
        }
        return head;
    }

    /**
     * 判断是否有环
     * 141
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * <p>
     * 示例 3：
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     * 进阶：
     * <p>
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 方法一：用set记录所历遍过的结点，之后判断是否在set中，第一个在set中的结点为环的起始结点
     *
     * @param head 链表的头结点
     * @return true 链表有环 false 链表没有环
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        // 找到第一个已存在set中的节点，返回该节点
        while (head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        return head != null;
    }

    /**
     * 判断是否有环
     * 方法二：快慢指针，见onenote/leetcode/141 142
     *
     * @param head 链表的头结点
     * @return true 链表有环 false 链表没有环
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;
        int vFast = 2;
        int vSlow = 1;
        while (fastPointer != null) {
            // fastPointer 与 slowPointer相应的步数
            for (int i = 0; i < vFast && fastPointer != null; i++) {
                fastPointer = fastPointer.next;
            }
            // 这里slowPointer != null的判断是为了处理边界情况：若链表长度L=1;而vSlow = 2
            for (int i = 0; i < vSlow && slowPointer != null; i++) {
                slowPointer = slowPointer.next;
            }
            // 判断两者是否相遇，相遇则退出循环
            if (fastPointer == slowPointer) {
                break;
            }
        }
        return fastPointer != null;
    }

    /**
     * 142
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * <p>
     * 说明：不允许修改给定的链表。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * <p>
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * <p>
     * <p>
     * 示例 3：
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     * <p>
     * <p>
     *  
     * <p>
     * 进阶：
     * 你是否可以不用额外空间解决此题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 判断是否有环升级版，返回环开始结点
     * 方法一：set，同上
     *
     * @param head 链表的头结点
     * @return null 链表没有环，否则返回链表开始结点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        // 找到第一个已存在set中的节点，返回该节点
        while (head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        return head;
    }

    /**
     * 判断是否有环升级版，返回环开始结点
     * 方法二：快慢指针，见onenote/leetcode/141 142
     *
     * @param head 链表的头结点
     * @return null 链表没有环，否则返回链表开始结点
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;
        ListNode meet = null;
        int vFast = 2;
        int vSlow = 1;
        while (fastPointer != null) {
            // fastPointer 与 slowPointer相应的步数
            for (int i = 0; i < vFast && fastPointer != null; i++) {
                fastPointer = fastPointer.next;
            }
            // 这里slowPointer != null的判断是为了处理边界情况：若链表长度L=1;而vSlow = 2
            for (int i = 0; i < vSlow && slowPointer != null; i++) {
                slowPointer = slowPointer.next;
            }
            // 判断两者是否相遇，相遇则退出循环
            if (fastPointer == slowPointer) {
                meet = fastPointer;
                break;
            }
        }

        if (meet != null) {
            while (head != meet) {
                head = head.next;
                meet = meet.next;
            }
            return head;
        }
        return null;
    }


    /**
     * 19. 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * <p>
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明:
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     * <p>
     * 方法一：两次历遍
     *
     * @param head 链表头结点
     * @param n    倒数第n个
     * @return 新链表头结点
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = calculateLinkedListLength(head);
        if (head == null || n <= 0 || len < n) {
            return head;
        }
        // 要求删除倒数第len个即第一个时，直接返回第2个节点。
        if (n == len) {
            return head.next;
        }

        ListNode node = head;
        for (int i = 0; i < len - n - 1; i++) {
            node = node.next;
        }
        // 这里不用额外处理倒数第一的情况，因为这里指向的是倒数第n个的前一个节点。
        node.next = node.next.next;
        return head;
    }

    /**
     * 方法二：一次历遍
     * 双指针，一个指针先移动n个位置到达n+1下标处
     *
     * @param head 链表头结点
     * @param n    倒数第n个
     * @return 新链表头结点
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int len = calculateLinkedListLength(head);
        if (head == null || n <= 0 || len < n) {
            return head;
        }
        // 要求删除倒数第len个即第一个时，直接返回第2个节点。
        if (n == len) {
            return head.next;
        }

        ListNode pre = head;
        ListNode pos = head;
        for (int i = 0; i < n; i++) {
            pos = pos.next;
        }
        while (pos.next != null) {
            pos = pos.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 21. 合并两个有序链表
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * /**
     * * Definition for singly-linked list.
     * * public class ListNode {
     * *     int val;
     * *     ListNode next;
     * *     ListNode(int x) { val = x; }
     * * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode newHead;
        ListNode next;
        // 确定头节点
        if (l1.val <= l2.val) {
            newHead = l1;
            l1 = l1.next;
        } else {
            newHead = l2;
            l2 = l2.next;
        }
        // 记录新链表的尾节点
        ListNode tail = newHead;
        // 归并后续节点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 处理剩余节点
        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }
        return newHead;
    }

    /**
     * 86. 分隔链表
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * <p>
     * 你应当保留两个分区中每个节点的初始相对位置。
     * <p>
     * 示例:
     * <p>
     * 输入: head = 1->4->3->2->5->2, x = 3
     * 输出: 1->2->2->4->3->5
     *  @param head 链表头结点
     *  @param x 作为参考的x值
     *  @return 新链表的头结点
     */

    public ListNode partition(ListNode head, int x) {
        ListNode more = null;
        ListNode less = null;
        ListNode moreTail = null;
        ListNode lessTail = null;
        while (head != null) {
            if (head.val < x) {
                if (less == null) {
                    less = head;
                    lessTail = less;
                } else {
                    lessTail.next = head;
                    lessTail = lessTail.next;
                }
            } else {
                if (more == null) {
                    more = head;
                    moreTail = more;
                } else {
                    moreTail.next = head;
                    moreTail = moreTail.next;
                }
            }

            head = head.next;
        }
        if (less != null) {
            lessTail.next = more;
        } else {
            less = more;
        }
        if(moreTail != null){
            moreTail.next = null;
        }
        return less;
    }

    /**
     * 建立临时头节点，简化代码
     * @param head 链表头结点
     * @param x 作为参考的x值
     * @return 新链表的头结点
     */
    public ListNode partition2(ListNode head, int x) {
        // 建立两个临时头节点
        ListNode moreHead = new ListNode(0);
        ListNode lessHead = new ListNode(0);
        ListNode moreTail = moreHead;
        ListNode lessTail = lessHead;
        while (head != null) {
            if (head.val < x) {
                lessTail.next = head;
                lessTail = lessTail.next;
            } else {
                moreTail.next = head;
                moreTail = moreTail.next;
            }
            head = head.next;
        }
        lessTail.next = moreHead.next;
        // moreTail 一定要置空，否则会形成环，陷入死循环
        moreTail.next = null;
        return lessHead.next;
    }


}

