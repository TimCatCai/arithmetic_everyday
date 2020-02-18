package timcat.leetcode.xiaoxiang.linkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListArithmeticTest {
    LinkedListArithmetic linkedListArithmetic = new LinkedListArithmetic();
    @ParameterizedTest
    @CsvFileSource(resources = "linked_lists_file.csv")
    void reverseAll(ArgumentsAccessor argumentsAccessor) {
        Linked_list list = createList(argumentsAccessor);
        linkedListArithmetic.printList(list);
        linkedListArithmetic.reverseAll(list);
        linkedListArithmetic.printList(list);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "reverse_partly_test_file.csv")
    void reversePartly(ArgumentsAccessor argumentsAccessor) {
            int len = argumentsAccessor.getInteger(0);
            int pairs = argumentsAccessor.getInteger(len + 1);
            for(int i = 0; i < pairs; i++){
                Linked_list list = createList(argumentsAccessor);
                int m = argumentsAccessor.getInteger(len + 2 + 2*i);
                int n = argumentsAccessor.getInteger(len + 2 + 2*i + 1);
                System.out.println("m=" + m + " n=" + n);
                linkedListArithmetic.printList(list);
                linkedListArithmetic.reversePartly(list,m,n);
                linkedListArithmetic.printList(list);
                System.out.println();
            }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "linked_lists_file.csv")
    void printList(ArgumentsAccessor argumentsAccessor) {
        Linked_list list = createList(argumentsAccessor);
        linkedListArithmetic.printList(list);
    }

    Linked_list createList(ArgumentsAccessor argumentsAccessor) {
        int number = argumentsAccessor.getInteger(0);
        Linked_list list = new Linked_list();
        Node node = null;
        int value;
        for (int i = 0; i < number; i++) {
            value = argumentsAccessor.getInteger(i + 1);
            if(node == null){
                list.head = new Node(value);
                node = list.head;
            }else{
                node.next = new Node(value);
                node = node.next;
            }
        }
        return list;
    }
}