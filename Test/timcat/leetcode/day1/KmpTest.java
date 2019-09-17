package timcat.leetcode.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import timcat.arithmetic.Kmp;

import static org.junit.jupiter.api.Assertions.*;

class KmpTest {
    @ParameterizedTest
    @CsvFileSource(resources = "kmp_test_file.csv", numLinesToSkip = 0)
    void kmp(ArgumentsAccessor arguments) {
        String origin = arguments.getString(0);
        String subString = arguments.getString(1);
        int result = arguments.getInteger(2);
        assertEquals(Kmp.kmp(origin,subString), result);
    }
}