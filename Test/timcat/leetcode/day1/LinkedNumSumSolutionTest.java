package timcat.leetcode.day1;

import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedNumSumSolutionTest {

    LinkedNumSumSolution linkedNumSumSolution = new LinkedNumSumSolution();


    @ParameterizedTest
    // 0
    @CsvFileSource(resources = "linked_num_sum_data.csv")
    void addTwoNumbers(ArgumentsAccessor arguments) {
        int l1_nodes_num = arguments.getInteger(0);
        ListNode l1;
        ListNode l2;
        int i = 0;
        l1 = init(l1_nodes_num, 1, arguments);
        int l2_nodes_num = arguments.getInteger(l1_nodes_num + 1);
        l2 = init(l2_nodes_num, l1_nodes_num + 2, arguments);
        ListNode resultList = linkedNumSumSolution.addTwoNumbers(l1, l2);
        int result = convertListToNum(resultList);
        int resultExpected = arguments.getInteger(l1_nodes_num + l2_nodes_num + 2);
        assertEquals(resultExpected, result);
    }

    private ListNode init(int nodes_num, int index, ArgumentsAccessor arguments){
        ListNode lxHead = new ListNode(arguments.getInteger(index ++));
        ListNode lx = lxHead;
        for(int i = 1; i < nodes_num; i++, index++){
            lx.setNext(new ListNode(arguments.getInteger(index)));
            lx = lx.getNext();
        }
        return lxHead;
    }

    private int convertListToNum(ListNode l){
        int result = 0;
        int base = 1;
        while(null != l){
            result = base * l.getVal() + result;
            base *= 10;
            l = l.getNext();
        }
        return result;
    }
}