package timcat.leetcode.day1;

import java.util.List;

/**
 * 题目：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 这里要特别注意没有头结点的处理：　可以手动添加一个头节点，之后返回结果时去掉头结点
// 注意对进位的处理：1. 当链表的长度一致时 2. 当链表的长度不一致，之后剩下的尾数与进位相加之后仍有进位
public class LinkedNumSumSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 给结果链表添加一个头结点方便后面的操作，返回结果时去掉该节点
        ListNode resultListHead = new ListNode(0);
        ListNode resultList = resultListHead;
        // c 存储的是每一次加法的运算
        int c = 0;
        int bitOfSum = 0;

        while(l1 != null){
            if(l2 == null){
                break;
            }else{
                bitOfSum = (l1.getVal() + l2.getVal() + c) % 10;
                c = (l1.getVal() + l2.getVal() + c) / 10;
                resultList.setNext(new ListNode(bitOfSum));
                resultList = resultList.getNext();
            }
            l1 = l1.getNext();
            l2 = l2.getNext();
        }


        if(l2 != null){
            // 若l2的长度l1长
            addNumLeft(resultList, l2, c);
        }else if(l1 != null){
            // 若l1的长度比l2长
            addNumLeft(resultList, l1, c);
        }else{
            // 当l1与l2等长的时候,处理剩余的进位
            solveFinalCarry(c, resultList);
        }

        // 操作的过程有一个头节点，而返回的结果没有头节点，所以需要删去头结点。
        return resultListHead.getNext();
    }

    private void solveFinalCarry(int c, ListNode resultList){
        // 情况１：当l1和l2的长度一致时，前面的所有操作会跳过，判断进位是否为０，否则为其新建节点
        // 情况２：当两者的长度不一致时，进位和剩余的尾数相加后仍有进位时，处理进位，例如： 999 + 1
        if(c != 0){
            resultList.setNext(new ListNode(c));
        }
    }
    private void addNumLeft(ListNode resultList, ListNode leftList, int c){
        int bitOfSum = 0;
        while (leftList != null){
            if(0 == c){
                // 当进位为0的时候，将剩下的所有位赋值给结果链表
                while(leftList != null){
                    resultList.setNext(new ListNode(leftList.getVal()));
                    resultList = resultList.getNext();
                    leftList = leftList.getNext();
                }
            }else{
                // 进位不为０时，需要将进位与当前位进行相加
                //　链表对应节点的和
                bitOfSum = (leftList.getVal() + c) % 10 ;
                c = (leftList.getVal() + c) / 10;
                resultList.setNext(new ListNode(bitOfSum));
                resultList = resultList.getNext();
                leftList = leftList.getNext();
            }
        }
        // 处理最后剩余尾数和进位和的进位
        solveFinalCarry(c, resultList);
    }
}


// Definition for singly-linked list.
class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
