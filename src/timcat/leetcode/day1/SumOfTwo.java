package timcat.leetcode.day1;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode problem 1
 *
 * @author TimcatCai
 * @vertion 2019/07/19
 */
public class SumOfTwo {
    /**
     * 暴力匹配法
     *
     * @param data   查找两个匹配数据的数组
     * @param target 目标两数和
     * @return 返回包含满足目标值的两个数组数据，若这两整数不存在，则两个值都为-1
     */
    public int[] violentMethod(int[] data, int target) {

        // 迭代整个数组的数据，因为最后一个数据后面没有数据，因而不需要搜索后面呢的数据
        for (int i = 0; i < data.length - 1; i++) {
            //当前数据小于或等于目标值才搜索下面的数据
            if (data[i] <= target) {
                for (int j = i + 1; j < data.length; j++) {
                    if (data[j] <= target && data[i] + data[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }

        }

        return new int[]{-1, -1};
    }

    /**
     * 两遍哈希法
     *
     * @param nums   查找两个匹配数据的数组
     * @param target 目标两数和
     * @return 返回包含满足目标值的两个数组数据，若这两整数不存在，则两个值都为-1
            */
    public int[] twoHashMatch(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> tempContainer = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tempContainer.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempContainer.containsKey(target - nums[i]) && tempContainer.get(target - nums[i]) != i) {
                result[0] = i;
                result[1] = tempContainer.get(target - nums[i]);
            }
        }

        return result;
    }


    /**
     * 一次哈希法
     *
     * @param nums   查找两个匹配数据的数组
     * @param target 目标两数和
     * @return 返回包含满足目标值的两个数组数据，若这两整数不存在，则两个值都为-1
     */
    public int[] oneHashMatch(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> tempContainer = new HashMap<>(target);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                if (tempContainer.containsKey(target - nums[i])) {
                    result[0] = i;
                    result[1] = tempContainer.get(target - nums[i]);
                    break;
                } else {
                    tempContainer.put(nums[i], i);
                }
            }
        }
        return result;
    }
}
