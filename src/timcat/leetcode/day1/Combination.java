package timcat.leetcode.day1;

import java.util.HashSet;
import java.util.Set;

public class Combination {

    /**
     * 循环排列问题
     * 循环次数是固定的，只能选择3个
     */
    public static Set<Set<String>> iterationMethod(String [] data){
        Set<Set<String>> result = new HashSet<>();
        final int count = 3;
        for (String element1 : data) {
            for (String element2 : data) {
                for (String element3 : data) {
                    Set<String> tempCollection = new HashSet<>();
                    tempCollection.add(element1);
                    tempCollection.add(element2);
                    tempCollection.add(element3);
                    if (tempCollection.size() == count){
                        result.add(tempCollection);
                    }
                }
            }
        }
        return result;
    }
}
