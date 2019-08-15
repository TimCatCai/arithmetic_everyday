package timcat.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import timcat.leetcode.day1.Permutation;

import java.util.List;

import static org.junit.Assert.*;

public class PermutationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void iterationMethod() {
        String [] test = new String[]{"a","b","c"};
        List<List<String>> result = Permutation.iterationMethod(test);
        System.out.println(result);
    }
}