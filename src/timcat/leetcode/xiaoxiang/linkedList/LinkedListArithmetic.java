package timcat.leetcode.xiaoxiang.linkedList;

import java.util.*;

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
     * 23. 合并K个排序链表
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * <p>
     * 方法：分治法
     *
     * @param lists 包含所有链表头指针的数组
     * @return 返回合并后的链表头指针
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ArrayList<ListNode> newLists = new ArrayList<>(lists.length / 2 + 1);
        for (int i = 0; i < lists.length; i += 2) {
            if (i + 1 >= lists.length) {
                // 剩下最后一个链表，直接放入新链表头指针数组
                newLists.add(lists[i]);
            } else {
                // 有成对的链表，合并
                newLists.add(mergeTwoLists(lists[i], lists[i + 1]));
            }
        }
        return mergeKLists(newLists.toArray(new ListNode[0]));
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
     *
     * @param head 链表头结点
     * @param x    作为参考的x值
     * @return 新链表的头结点
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
        if (moreTail != null) {
            moreTail.next = null;
        }
        return less;
    }

    /**
     * 建立临时头节点，简化代码
     *
     * @param head 链表头结点
     * @param x    作为参考的x值
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


    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }

    /**
     * 138 & 35. 复制带随机指针的链表
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     * <p>
     * 要求返回这个链表的 深拷贝。
     * <p>
     * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     * <p>
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * 示例 4：
     * <p>
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     * <p>
     * <p>
     * 提示：
     * <p>
     * -10000 <= Node.val <= 10000
     * Node.random 为空（null）或指向链表中的节点。
     * 节点数目不超过 1000 。
     * <p>
     * 方法一：在第一次循环链表时，建立新链表的next指向
     *
     * @param head 链表头节点
     * @return 新链表头节点
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        // 新链表的临时头节点
        Node newHead = new Node(0);
        Node newTail = newHead;
        while (temp != null) {
            // 建立新链表的顺序指向
            newTail.next = new Node(temp.val);
            newTail = newTail.next;
            // 将链表所有节点放入哈希表
            map.put(temp, newTail);
            temp = temp.next;
        }
        Node originList = head;
        Node newList = newHead.next;
        // 建立新链表的随机指向
        while (originList != null && newList != null) {
            newList.random = map.get(originList.random);
            originList = originList.next;
            newList = newList.next;
        }
        return newHead.next;
    }

    /**
     * 方法二：在第二次循环链表时，建立新链表的next指向和random指向
     * 与方法一的区别是：方法一只需要查一次哈希表得到random域即可，但需要额外历遍新链表，
     * 方法二需要查两次哈希表，不需重新历遍新链表
     *
     * @param head 链表头节点
     * @return 新链表头节点
     */
    public Node copyRandomList2(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        // 新链表的临时头节点
        Node newHead = new Node(0);
        Node newTail = newHead;
        while (temp != null) {
            // 将链表所有节点放入哈希表
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            // 建立新链表next域
            newTail.next = map.get(temp);
            newTail = newTail.next;
            // 建立新链表random域
            newTail.random = map.get(temp.random);
            temp = temp.next;
        }
        return newHead.next;
    }

    /**
     * 方法三： 一次历遍旧链表
     * 时间复杂度：O(N)O(N) 。因为我们需要将原链表逐一遍历。
     * 空间复杂度：O(N)O(N) 。 我们需要维护一个字典，保存旧的节点和新的节点的对应。因此总共需要 NN 个节点，需要 O(N)O(N) 的空间复杂度。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public Node copyRandomList3(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        // 新链表的临时头节点
        Node newHead = new Node(0);
        Node newTail = newHead;
        Node nextNode;
        Node randomNode;
        while (temp != null) {
            // 判断是否在哈希表中
            nextNode = map.get(temp);
            if (nextNode == null) {
                nextNode = new Node(temp.val);
                map.put(temp, nextNode);
            }

            // 建立新链表的顺序指向
            newTail.next = nextNode;
            newTail = newTail.next;

            // 建立random域指向
            if (temp.random != null) {
                randomNode = map.get(temp.random);
                if (randomNode == null) {
                    randomNode = new Node(temp.random.val);
                    map.put(temp.random, randomNode);
                }
                nextNode.random = randomNode;
            }
            temp = temp.next;
        }
        return newHead.next;
    }

    /**
     * 方法四：图论法
     * 时间复杂度：O(N)O(N) ，其中 NN 是链表中节点的数目。
     * 空间复杂度：O(N)O(N) 。如果我们仔细分析，我们需要维护一个回溯的栈，同时也需要记录已经被深拷贝过的节点，也就是维护一个已访问字典。渐进时间复杂度为 O(N)O(N) 。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public Node copyRandomList4(Node head) {
        Map<Node, Node> nodesVisited = new HashMap<>();
        return copyRandomListGraphic(head, nodesVisited);
    }

    public Node copyRandomListGraphic(Node head, Map<Node, Node> nodesVisited) {
        if (head == null || nodesVisited == null) {
            return null;
        }
        if (nodesVisited.containsKey(head)) {
            return nodesVisited.get(head);
        } else {
            Node newNode;
            newNode = new Node(head.val);
            nodesVisited.put(head, newNode);
            newNode.next = copyRandomListGraphic(head.next, nodesVisited);
            newNode.random = copyRandomListGraphic(head.random, nodesVisited);
            return newNode;
        }
    }

    /**
     * 方法四：O(1) 空间的迭代
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * 与上面提到的维护一个旧节点和新节点对应的字典不同，我们通过扭曲原来的链表，并将每个拷贝节点都放在原来对应节点的旁边。
     * 这种旧节点和新节点交错的方法让我们可以在不需要额外空间的情况下解决这个问题
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/fu-zhi-dai-sui-ji-zhi-zhen-de-lian-biao-by-leetcod/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public Node copyRandomList5(Node head) {
        if (head == null) {
            return null;
        }

        Node nextNode;
        Node temp = head;
        Node newNode;
        // 构建next域
        while (temp != null) {
            nextNode = temp.next;
            newNode = new Node(temp.val);
            temp.next = newNode;
            newNode.next = nextNode;
            temp = nextNode;
        }
        // 构建random域
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node newHead = head.next;
        newNode = newHead;
        Node originalNode = head;
        while (newNode.next != null) {
            originalNode.next = newNode.next;
            originalNode = originalNode.next;
            newNode.next = originalNode.next;
            newNode = newNode.next;
        }
        originalNode.next = null;
        return newHead;
    }

    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     *
     * @param head 要进行交换的链表的头指针
     * @return 新的链表的头指针
     * <p>
     * 复杂度分析
     * 时间复杂度：O(N)，其中 NN 指的是链表的节点数量。
     * 空间复杂度：O(1)。
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-19/
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead;
        ListNode current = tempHead.next;
        ListNode next = current.next;
        ListNode post;
        while (current != null && next != null) {
            post = next.next;
            current.next = post;
            pre.next = next;
            next.next = current;

            // 指针移动
            pre = current;
            current = post;
            if (current != null) {
                next = current.next;
            }
        }
        return tempHead.next;
    }

    /**
     * 方法二：递归法
     * 算法：
     * <p>
     * 从链表的头节点 head 开始递归。
     * 每次递归都负责交换一对节点。由 firstNode 和 secondNode 表示要交换的两个节点。
     * 下一次递归则是传递的是下一对需要交换的节点。若链表中还有节点，则继续递归。
     * 交换了两个节点以后，返回 secondNode，因为它是交换后的新头。
     * 在所有节点交换完成以后，我们返回交换后的头，实际上是原始链表的第二个节点。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-19/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 时间复杂度：O(N)O(N)，其中 NN 指的是链表的节点数量。
     * 空间复杂度：O(N)O(N)，递归过程使用的堆栈空间。
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 示例 :
     * <p>
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * <p>
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * <p>
     * 说明 :
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head 所要反转的链表的头指针
     * @param k    为一组的常数k
     * @return 新的链表的头指针
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode tempNode = tempHead;
        ListNode pre = tempHead;
        ListNode post;
        // 指向反转完成部分的链表的最后一个节点
        ListNode newPartTail;
        while (tempNode != null) {
            int i;
            for (i = 0; i < k && tempNode != null; i++) {
                tempNode = tempNode.next;
            }
            if (k == i && tempNode != null) {
                post = tempNode.next;
                newPartTail = pre.next;
                // 将要逆置的部分的最后一个节点指向空
                tempNode.next = null;
                pre.next = reverseList(pre.next);
                newPartTail.next = post;
                // 逆置完成后再将tempNode的指向将要逆置下部分的上一个结点，即逆置完成部分的最后一个节点
                tempNode = newPartTail;
                pre = newPartTail;
            }
        }
        return tempHead.next;
    }

    /**
     * 61. 旋转链表
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     * <p>
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     * 方法一：前后对换法
     * 时间：O(n)
     * 空间：O(1)
     * @param head 所要旋转链表的头指针
     * @param k    移动的常数k
     * @return 新链表的头节点
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        ListNode tempNode = head;
        int len = 0;
        while (tempNode != null) {
            len++;
            tempNode = tempNode.next;
        }
        // 倒数第n个及以后往前移动
        int n = k % len;
        if (n != 0) {
            tempNode = head;
            for (int i = 0; i < len - n - 1; i++) {
                tempNode = tempNode.next;
            }
            ListNode newHead = tempNode.next;
            // 使新链表的最后一个节点的下一个节点为空
            tempNode.next = null;

            // 将链表的两部分拼接
            tempNode = newHead;
            for (int i = 0; i < n - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = head;
            return newHead;
        } else {
            return head;
        }
    }

    /**
     * 方法二：环形链表法
     * 时间：O(n)
     * 空间：O(1)
     * @param head 所要旋转链表的头指针
     * @param k    移动的常数k
     * @return 新链表的头节点
     */
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        ListNode tempNode = head;
        ListNode pre = head;
        int len = 0;
        while (tempNode != null) {
            len++;
            pre = tempNode;
            tempNode = tempNode.next;
        }
        // 倒数第n个及以后往前移动
        int n = k % len;
        // 链表最后一个和第一相连
        pre.next = head;

        tempNode = head;
        for (int i = 0; i < len - n; i++) {
            pre = pre.next;
            tempNode = tempNode.next;
        }
        head = tempNode;
        pre.next = null;
        return head;
    }
    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     * 时间：O(n)
     * 空间：O(1)
     * @param head 所要操作链表的头节点
     * @return 新的链表的头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        int currentValue = head.val;
        ListNode pre = head;
        ListNode tempNode = head.next;
        while(tempNode != null){
            if(tempNode.val == currentValue){
                // 重复节点，删除该节点
                pre.next = tempNode.next;
            }else{
                // 非重复节点，更新当前值并移动pre指针
                currentValue = tempNode.val;
                pre = tempNode;
            }
            tempNode = tempNode.next;
        }
        return head;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     * @param head 所要操作链表的头节点
     * @return 新的链表的头节点
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null){
            return null;
        }
        // 建立临时头节点
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead;
        ListNode tempNode = head.next;
        int currentValue = head.val;
        int count = 0;
        while(tempNode != null){
            if(tempNode.val == currentValue){
                count ++;
            }else{
                if(count >= 1){
                  // 有重复节点，删除
                  pre.next = tempNode;
                  count = 0;
                }else{
                    // 无重复节点，移动pre
                    pre = pre.next;
                }
                currentValue = tempNode.val;
            }
            tempNode = tempNode.next;
        }
        // 处理最后可能的重复节点
        if(count >= 1){
            pre.next = null;
        }
        return tempHead.next;
    }

}

