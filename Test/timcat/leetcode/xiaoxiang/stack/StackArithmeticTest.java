package timcat.leetcode.xiaoxiang.stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class StackArithmeticTest {
    StackArithmetic stackArithmetic = new StackArithmetic();

    @ParameterizedTest
    @CsvFileSource(resources = "stack_trap3_test.csv")
    void trap3(ArgumentsAccessor argumentsAccessor) {
        int num = argumentsAccessor.getInteger(0);
        int[] height = new int[num];
        for (int i = 0; i < num; i++) {
            height[i] = argumentsAccessor.getInteger(i + 1);
        }
        int result = argumentsAccessor.getInteger(num + 1);
        assertEquals(result, stackArithmetic.trap3(height));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "stack_trap3_test.csv")
    void trap4(ArgumentsAccessor argumentsAccessor) {
        int num = argumentsAccessor.getInteger(0);
        int[] height = new int[num];
        for (int i = 0; i < num; i++) {
            height[i] = argumentsAccessor.getInteger(i + 1);
        }
        int result = argumentsAccessor.getInteger(num + 1);
        assertEquals(result, stackArithmetic.trap4(height));
    }

    @Test
    void test() {
        String path = "/a/../../b/../c//.///";
        String[] spiltStrings = path.split("/");
        System.out.println("Size: " + spiltStrings.length);
        System.out.println("------------------");
        for (int i = 0; i < spiltStrings.length; i++) {
            System.out.println(i + ": |" + spiltStrings[i] + "|");
        }
        System.out.println("------------------");

    }


    @ParameterizedTest
    @CsvFileSource(resources = "simplify_path_test.csv")
    void simplifyPath(ArgumentsAccessor argumentsAccessor) {
        String in = argumentsAccessor.getString(0);
        String out = argumentsAccessor.getString(1);
        assertEquals(out, stackArithmetic.simplifyPath(in));
    }
}