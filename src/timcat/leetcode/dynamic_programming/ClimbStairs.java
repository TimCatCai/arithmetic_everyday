package timcat.leetcode.dynamic_programming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {

    /**
     * 递归法
     * 在最底下楼梯时，只能是走一阶或者两阶，剩下的是走法是这两种走法的剩下楼梯走法之和。
     * 其他的情况与第一二阶类似，也即递归调用过程
     *
     * 效率：二叉树形式，接近2^n
     * @param n 台阶数量
     * @return 返回总的走法数
     */
    public int recursion(int n) {
        // 台阶为1时，走法是1，台阶为2时，走法是2（1+1，2）
        if(n == 1 || n == 2){
            return n;
        }
        return recursion(n-1) + recursion(n - 2);
    }
}
