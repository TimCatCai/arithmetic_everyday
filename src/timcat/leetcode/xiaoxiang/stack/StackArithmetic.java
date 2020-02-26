package timcat.leetcode.xiaoxiang.stack;

import java.util.Stack;

public class StackArithmetic {
    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s == null){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        boolean isMatching = true;
        for(int i = 0; i < s.length() && isMatching;i++){
            char ch = s.charAt(i);
            switch (ch){
                case  '}':
                    isMatching = mactchingPair(ch, stack);
                    break;
                case ')':
                    isMatching = mactchingPair(ch, stack);
                    break;
                case ']':
                    isMatching = mactchingPair(ch, stack);
                    break;
                default:
                    stack.push(ch);
            }
            if(!isMatching){
                break;
            }
        }
        if(!stack.empty()){
            isMatching = false;
        }
        return isMatching;
    }

    private boolean mactchingPair(char ch, Stack<Character> stack){
        if(stack.empty()){
            return false;
        }
        char peek = stack.pop();
        switch (ch){
            case  '}':
                return peek == '{';
            case ')':
                return peek == '(';
            case ']':
                return peek == '[';
            default:
                return false;
        }
    }
}
