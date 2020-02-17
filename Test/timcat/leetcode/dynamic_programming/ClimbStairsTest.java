package timcat.leetcode.dynamic_programming;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsTest {
    private ClimbStairs climbStairs = new ClimbStairs();
    @ParameterizedTest
    @CsvFileSource(resources = "climb_stairs.csv")
    void recursion(ArgumentsAccessor argumentsAccessor) {
        int stairsNum = argumentsAccessor.getInteger(0);
        int totalKinds = argumentsAccessor.getInteger(1);
        assertEquals(totalKinds, climbStairs.recursion(stairsNum));
    }
}