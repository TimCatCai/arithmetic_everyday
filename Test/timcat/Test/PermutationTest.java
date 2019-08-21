package timcat.Test;


import org.junit.jupiter.api.Test;
import timcat.leetcode.day1.Permutation;

import java.util.List;


public class PermutationTest {


    @Test
    public void iterationMethod() {
        String [] test = new String[]{"a","b","c"};
        List<List<String>> result = Permutation.iterationMethod(test);
        System.out.println(result);
    }
}