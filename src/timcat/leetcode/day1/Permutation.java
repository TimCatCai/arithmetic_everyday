package timcat.leetcode.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 排列问题求解
 * @author TimcatCai
 * @version 2019/07/25
 */
public class Permutation {

    /**
     * 循环排列问题
     * 循环次数是固定的，只能选择3个
     */
    public static List<List<String>> iterationMethod( String [] data){
        final int count = 3;
        List<List<String>> result = new ArrayList<>();
        for (String element1 : data) {
            for (String element2 : data) {
                for (String element3 : data) {
                     if(!element1.equals(element2)
                          && !element1.equals(element3)
                          && !element2.equals(element3)){
                         List<String> tempList = new ArrayList<>();
                         tempList.add(element1);
                         tempList.add(element2);
                         tempList.add(element3);
                         result.add(tempList);
                     }
                }
            }
        }
        return result;
    }
}
