package timcat.Test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import timcat.leetcode.day1.Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PermutationTest {
    private Permutation permutation = new Permutation();

    @ParameterizedTest
    @CsvFileSource(resources = "permutation_test.csv")
    public void iterationMethod(ArgumentsAccessor argumentsAccessor) {
        int dataLen = argumentsAccessor.getInteger(0);
        int i;
        String [] data = new String[dataLen];
        for(i = 0; i < dataLen; i++){
            data[i] = argumentsAccessor.getString(i + 1);
        }

        int resultLen = argumentsAccessor.getInteger(++ i);
        List<List<String>> result = new ArrayList<>(resultLen);
        List<String> oneResult;
        for(i++,resultLen += i;i < resultLen;i++){
            oneResult = Arrays.asList(argumentsAccessor.getString(i).split(" "));
            result.add(oneResult);
        }

        List<List<String>> resultComputed = permutation.permutationRec(data);

        String[][] resultArray = new String[result.size()][result.get(0).size()];
        for(i = 0; i < result.size();i++){
            for(int j = 0; j < result.get(i).size(); j++){
                resultArray[i][j] = result.get(i).get(j);
            }
        }

        String[][] resultComputedArray = new String[resultComputed.size()][resultComputed.get(0).size()];
        for(i = 0; i < resultComputed.size();i++){
            for(int j = 0; j < resultComputed.get(i).size(); j++){
                resultComputedArray[i][j] = resultComputed.get(i).get(j);
            }
        }
        for(i = 0; i < resultComputed.size();i++){
            assertArrayEquals(resultArray[i], resultComputedArray[i]);
        }
    }
}