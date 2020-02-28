package timcat.leetcode.xiaoxiang.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackArithmetic {
    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        boolean isMatching = true;
        for (int i = 0; i < s.length() && isMatching; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '}':
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
            if (!isMatching) {
                break;
            }
        }
        if (!stack.empty()) {
            isMatching = false;
        }
        return isMatching;
    }

    private boolean mactchingPair(char ch, Stack<Character> stack) {
        if (stack.empty()) {
            return false;
        }
        char peek = stack.pop();
        switch (ch) {
            case '}':
                return peek == '{';
            case ')':
                return peek == '(';
            case ']':
                return peek == '[';
            default:
                return false;
        }
    }
    /**
     * 225 使用队列实现栈的下列操作：
     *
     * push(x) -- 元素 x 入栈
     * pop() -- 移除栈顶元素
     * top() -- 获取栈顶元素
     * empty() -- 返回栈是否为空
     * 注意:
     *
     * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
     * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
     * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    class MyStack {
        private Queue<Integer> queue;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            int size = queue.size();
            queue.add(x);
            for (int i = 0; i < size; i++) {
                queue.add(queue.remove());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * 232. 用栈实现队列
     * 使用栈实现队列的下列操作：
     * <p>
     * push(x) -- 将一个元素放入队列的尾部。
     * pop() -- 从队列首部移除元素。
     * peek() -- 返回队列首部的元素。
     * empty() -- 返回队列是否为空。
     * 示例:
     * <p>
     * MyQueue queue = new MyQueue();
     * <p>
     * queue.push(1);
     * queue.push(2);
     * queue.peek();  // 返回 1
     * queue.pop();   // 返回 1
     * queue.empty(); // 返回 false
     * 说明:
     * <p>
     * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
     */

    class MyQueue {

        private Stack<Integer> stack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            Stack<Integer> tempStack = new Stack<>();
            while (!stack.empty()) {
                tempStack.push(stack.pop());
            }
            stack.push(x);
            while (!tempStack.empty()) {
                stack.push(tempStack.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.empty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */


    /**
     * 面试题30. && 155. 最小栈
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     * 示例:
     * <p>
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     */
    class MinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.empty()) {
                minStack.push(x);
            } else {
                int topInMin = minStack.peek();
                if (x <= topInMin) {
                    minStack.push(x);
                } else {
                    minStack.push(topInMin);
                }
            }
        }

        public void pop() {
            if (!dataStack.empty()) {
                dataStack.pop();
            }
            if (!minStack.empty()) {
                minStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */


    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     * 方法一： 暴力法
     * 时间复杂度： O(n^2) 数组中的每个元素都需要向左向右扫描。
     * <p>
     * 空间复杂度 O(1) 的额外空间。
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        int leftMax;
        int rightMax;
        for (int i = 0; i < height.length; i++) {
            // 左右最大值都设置为当前位置
            leftMax = rightMax = height[i];
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }
            sum += Math.min(leftMax, rightMax) - height[i];
        }
        return sum;
    }

    /**
     * 方法二：动态规划
     * 时间复杂度：O(n)。
     * <p>
     * 存储最大高度数组，需要两次遍历，每次 O(n) 。
     * 最终使用存储的数据更新ans ，O(n)。
     * 空间复杂度：O(n) 额外空间。
     * <p>
     * 和方法 1 相比使用了额外的 O(n) 空间用来放置 left_max 和 right_max 数组。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[rightMax.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    /**
     * 方法三：栈的使用
     * 复杂性分析
     * <p>
     * 时间复杂度：O(n)。
     * 单次遍历 O(n) ，每个条形块最多访问两次（由于栈的弹入和弹出），并且弹入和弹出栈都是 O(1)的。
     * 空间复杂度：O(n)。 栈最多在阶梯型或平坦型条形块结构中占用 O(n)的空间。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-le
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int trap3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int top;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] >= height[stack.peek()]) {
                top = stack.pop();
                // 处理开头处假蓄水的情况
                if (stack.empty()) {
                    break;
                }
                sum += (Math.min(height[stack.peek()], height[i]) - height[top]) * (i - 1 - stack.peek());
            }
            stack.push(i);
        }
        return sum;
    }

    /**
     * 方法四：双指针
     */
    public int trap4(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int leftPtr = 0;
        int rightPtr = height.length - 1;
        int leftMax = height[leftPtr];
        int rightMax = height[rightPtr];
        int sum = 0;
        while (leftPtr <= rightPtr) {
            if (height[leftPtr] < height[rightPtr]) {
                if (height[leftPtr] <= leftMax) {
                    sum += leftMax - height[leftPtr];
                } else {
                    leftMax = height[leftPtr];
                }
                leftPtr++;
            } else {
                if (height[rightPtr] <= rightMax) {
                    sum += rightMax - height[rightPtr];
                } else {
                    rightMax = height[rightPtr];
                }
                rightPtr--;
            }
        }
        return sum;
    }

    /**
     * 71. 简化路径
     * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
     * <p>
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
     * <p>
     * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入："/home/"
     * 输出："/home"
     * 解释：注意，最后一个目录名后面没有斜杠。
     * 示例 2：
     * <p>
     * 输入："/../"
     * 输出："/"
     * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
     * 示例 3：
     * <p>
     * 输入："/home//foo/"
     * 输出："/home/foo"
     * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     * 示例 4：
     * <p>
     * 输入："/a/./b/../../c/"
     * 输出："/c"
     * 示例 5：
     * <p>
     * 输入："/a/../../b/../c//.//"
     * 输出："/c"
     * 示例 6：
     * <p>
     * 输入："/a//b////c/d//././/.."
     * 输出："/a/b/c"
     */
    public String simplifyPath(String path) {
        if (path == null) {
            return null;
        }
        String[] spiltStrings = path.split("/");
        Stack<String> stack = new Stack<>();
        String temp;
        for (int i = 1; i < spiltStrings.length; i++) {
            temp = spiltStrings[i];
            switch (temp) {
                case ".":
                    // 什么也不做
                case "":
                    // 什么也不做
                    break;
                case "..":
                    // 弹栈
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    break;
                default:
                    // 其它入栈
                    stack.push(temp);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0, "/");
            result.insert(1, stack.pop());
        }
        if(result.length() == 0){
            result.append("/");
        }
        return result.toString();
    }
}
