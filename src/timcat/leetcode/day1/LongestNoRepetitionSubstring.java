package timcat.leetcode.day1;

import java.util.HashSet;
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
        Set<String> container = new HashSet<>(subString.length());
        for(int i = 0; i < subString.length(); i++){
            String concurrentChar = subString.substring(i,i + 1);
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
}
