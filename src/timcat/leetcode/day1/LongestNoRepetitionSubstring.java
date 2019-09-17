package timcat.leetcode.day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestNoRepetitionSubstring {
    /**
     * 暴力法中判断一个子序列中是否含有重复的字符
     * @param subString 判断的子序列
     * @return  若含有重复的字符则返回false, 否则返回True
     */
    private boolean isAllUnique(String subString){
        boolean result = true;
        // 将不重复的字符放入该集合中
        // 后续的字符若已经在该集合中，则将结果值设为false，并退出循环，否则将其放入集合中
        // 这里HashSet的大小不能初始化为字符串长度，因为可能的长度为字符集的长度
        Set<Character> container = new HashSet<>();
        for(int i = 0; i < subString.length(); i++){
            Character concurrentChar = subString.charAt(i);
            if(container.contains(concurrentChar)){
                result = false;
                break;
            }else{
                container.add(concurrentChar);
            }
        }
        return result;
    }

    /**
     * 暴力法判断一个字符串的最长非重复子串
     * @param s 将要判断的字符串
     * @return  该字符串中不含有重复字符的最长子串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 保存当前不含有重复字符的最长子串的长度
        int max = 0;
        boolean isSubstringUnique;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <= s.length(); j++){
                isSubstringUnique = isAllUnique(s.substring(i, j));
                // 当子串不含重复字符且其长度超过之前的max值时，更新max的值
                if(isSubstringUnique && j - i > max){
                    max = j - i;
                }
            }
        }
        return max;
    }

    /**
     * 使用滑动窗口解决一个字符串的最长非重复子串
     * 当发现字符串的所有字符都相同时，为算法最坏情况，时间复杂度为O(2n), 字符串不含重复字符时为O(n)
     * 空间复杂度为O(m), m为字符集的长度
     * @param s 将要判断的字符串
     * @return 该字符串中不含有重复字符的最长子串的长度
     */
    public int slideWindowWithHashSet(String s){
        int max = 0;
        // 存放滑动窗口中所有非重复的字符
        Set<Character> container = new HashSet<>();
        Character currentChar;
        int currentSlideWindowLen;
        int leftPtr = 0;
        int rightPtr;
        for(rightPtr = 0; rightPtr < s.length(); rightPtr++){
            currentChar = s.charAt(rightPtr);
            if(container.contains(currentChar)){
                currentSlideWindowLen = rightPtr - leftPtr;
                max = Math.max(currentSlideWindowLen, max);
                leftPtr = resizeSlideWindow(container, s, leftPtr, rightPtr, currentChar);
            }else{
                container.add(currentChar);
            }
        }
        currentSlideWindowLen = rightPtr - leftPtr;
        max = Math.max(currentSlideWindowLen, max);
        return max;
    }

    /**
     * 将滑动窗口中，重复字符之前所有的字符从滑动窗口中移除
     * @param slideWindow 存储滑动窗口中所有非重复的字符
     * @param leftPtr 滑动窗口的左指针
     * @param rightPtr 滑动窗口的右指针
     * @param targetChar 发生重复的字符
     * @return 重复字符的下一个字符的下标
     */
    private int resizeSlideWindow(Set<Character> slideWindow, String s, int leftPtr, int rightPtr, char targetChar){
        boolean searched = false;
        Character currentChar;
        while(leftPtr < rightPtr && !searched){
            currentChar = s.charAt(leftPtr);
            if(currentChar.equals(targetChar)){
                searched = true;
            }else{
                slideWindow.remove(s.charAt(leftPtr));
            }
            leftPtr ++;
        }
        return leftPtr;
    }
    /**
     * 使用优化的滑动窗口解决一个字符串的最长非重复子串
     * 即使用HashMap 记录字符所对应的下标，当出现重复字符时，直接跳过重复字符
     * 时间复杂度为n, 控件复杂度为O(m), m为字符集的长度
     * @param s 将要判断的字符串
     * @return 该字符串中不含有重复字符的最长子串的长度
     */
    public int slideWindowWithHashMap(String s){
        int max = 0;
        // 保存滑动窗口的左指针，右指针由迭代的i充当
        int leftPtr = 0;
        int rightPtr;
        int currentSlideWindowLength;
        Character currentChar;
        // key值保存的是当前滑动窗口的所有唯一的字符，对应的value值是字符所在下标
        // 空间复杂度是字符集的长度，而不是字符串的长度，所以这里不能指定为字符串的长度
        // 这里的128默认为ASCII的字符集长度，即只包含英文字符
        Map<Character, Integer> container = new HashMap<>(128);
        for(rightPtr = 0; rightPtr <  s.length(); rightPtr++){
            currentChar = s.charAt(rightPtr);
            // 若container中包含了该字符，调整滑动窗口的左指针指向该字符的下一个字符，并判断max是否需要更新
            if(container.containsKey(currentChar) && leftPtr <= container.get(currentChar)){
                currentSlideWindowLength = rightPtr - leftPtr;
                // 若当前滑动窗口的长度大于max，更新max的值
                max = Math.max(currentSlideWindowLength, max);
                // 调整左指针
                leftPtr = container.get(currentChar) + 1;
            }
            // 添加新的字符或者更新已有字符的下标
            // 这个根据下标与左指针的值判断是否是重复及下标更新的方法用得妙
            // 此前还想着要清空hashMap里重复的值，这样效率不是最优的，最差为2n, 跟用集合来放非重复字符的解法效率一致
            container.put(currentChar, rightPtr);
        }

        // 处理整个字符串都不含重复字符的情况
        currentSlideWindowLength = rightPtr - leftPtr;
        max = Math.max(max, currentSlideWindowLength);
        return max;
    }

}
