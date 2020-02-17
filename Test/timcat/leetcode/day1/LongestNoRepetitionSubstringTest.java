package timcat.leetcode.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class LongestNoRepetitionSubstringTest {
    private LongestNoRepetitionSubstring testTarget = new LongestNoRepetitionSubstring();
    @ParameterizedTest
    @CsvFileSource(resources = "longest_no_repetition_substring_file.csv")
    void lengthOfLongestSubstring(ArgumentsAccessor arguments) {
        String stringTarget = arguments.getString(0);
        int resultExcepted = arguments.getInteger(1);
        int result = testTarget.lengthOfLongestSubstring(stringTarget);
        assertEquals(resultExcepted, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "longest_no_repetition_substring_file.csv")
    void slideWindowWithHashMap(ArgumentsAccessor arguments){
        String stringTarget = arguments.getString(0);
        int resultExcepted = arguments.getInteger(1);
        int result = testTarget.slideWindowWithHashMap(stringTarget);
        assertEquals(resultExcepted, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "longest_no_repetition_substring_file.csv")
    public void slideWindowWithHashSet(ArgumentsAccessor arguments){
        String stringTarget = arguments.getString(0);
        int resultExcepted = arguments.getInteger(1);
        int result = testTarget.slideWindowWithHashSet(stringTarget);
        assertEquals(resultExcepted, result);
    }
}