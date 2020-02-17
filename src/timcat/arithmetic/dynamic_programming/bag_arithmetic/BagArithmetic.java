package timcat.arithmetic.dynamic_programming.bag_arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 背包问题动态规划解法
 */
public class BagArithmetic {
    /**
     * 背包问题求解
     *
     * @param goods    物品数组，为了更好表达算法思路，这里下标从1开始
     * @param capacity 非负，表示背包能够承受的重量
     * @return 前i个物品的最优可行子集的价值
     */
    public int napsack(int capacity, Goods... goods) {
        // 记录表格，第一行和第一列为0
        int[][] valueTable = new int[goods.length][capacity + 1];

        /**
         * 递推式：
         *      F(i,j) = max{F(i-1,j-wi) + vi, F(i-1, j)}   j-wi >= 0
         *             = F(i-1,j) j-wi < 0
         */
        for (int i = 1; i < goods.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j - goods[i].weight >= 0) {
                    valueTable[i][j] = Math.max(valueTable[i - 1][j - goods[i].weight] + goods[i].value, valueTable[i - 1][j]);
                } else {
                    valueTable[i][j] = valueTable[i - 1][j];
                }
            }
        }
        String[] title = new String[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            title[i] = String.valueOf(i);
        }
        printTable(title, valueTable);
        return valueTable[goods.length - 1][capacity];
    }

    /**
     * 有记忆功能的背包问题求解
     *
     * @param goods    物品数组，为了更好表达算法思路，这里下标从1开始
     * @param capacity 非负，表示背包能够承受的重量
     * @return 前i个物品的最优可行子集的价值
     */
    public int MFKnapsack(int capacity, Goods... goods) {
        // 记录表格，第一行和第一列为0
        Integer[][] valueTable = new Integer[goods.length][capacity + 1];
        // 初始化0行0列
        for (int i = 0; i < valueTable.length; i++) {
            valueTable[i][0] = 0;
        }

        for (int i = 0; i < valueTable[0].length; i++) {
            valueTable[0][i] = 0;
        }
        return iterateNapack(goods.length - 1, capacity, goods, valueTable);
    }

    private int iterateNapack(int i, int j, Goods[] goods, Integer[][] valueTable) {
        /**
         * 递推式：
         *      F(i,j) = max{F(i-1,j-wi) + vi, F(i-1, j)}   j-wi >= 0
         *             = F(i-1,j) j-wi < 0
         */
        if (valueTable[i][j] == null) {
            if (j - goods[i].weight >= 0) {
                return Math.max(iterateNapack(i - 1, j - goods[i].weight, goods, valueTable)
                        + goods[i].value, iterateNapack(i - 1, j, goods, valueTable));
            } else {
                return iterateNapack(i - 1, j, goods, valueTable);
            }
        } else {
            return valueTable[i][j];
        }
    }

    String printTable(String[] title, int[][] value) {

        StringBuilder table = new StringBuilder();
        int maxLen = 0;
        for (String s : title) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        table.append("\n");
        for (int[] ints : value) {
            for (int anInt : ints) {
                if (String.valueOf(anInt).length() > maxLen) {
                    maxLen = String.valueOf(anInt).length();
                }
            }
        }
        maxLen *= 3;

        for (String s : title) {
            table.append(String.format("%-" + maxLen + "s", s));
        }
        table.append("\n");
        for (int[] ints : value) {
            for (int anInt : ints) {
                table.append(String.format("%-" + maxLen + "s", anInt));
            }
            table.append("\n");
        }
        System.out.println(table.toString());
        return table.toString();
    }

    public List<List<Goods>> sourceBack(int[][] valueTable, Goods[] goods) {
        List<List<Goods>> resultLists = new ArrayList<>();
        List<Goods> oneList = new ArrayList<>(goods.length);
        resultLists.add(oneList);
        iterateSourceBack(valueTable.length - 1, valueTable[0].length - 1, valueTable, oneList, resultLists, goods);
        return resultLists;
    }

    private void iterateSourceBack(int i, int j, int[][] valueTable, List<Goods> oneList, List<List<Goods>> resultLists, Goods[] goods) {
        if (i == 0 || j == 0) {
            return;
        }
        if (valueTable[i][j] > valueTable[i - 1][j]) {
            oneList.add(goods[i]);
            iterateSourceBack(i - 1, j - goods[i].weight, valueTable, oneList, resultLists, goods);
        } else if (j - goods[i].weight >= 0) {
            if (valueTable[i - 1][j - goods[i].weight] + goods[i].value == valueTable[i - 1][j]) {
                // 创建新的分支，两个方向都可以进行，即goods[i]在集合内或不在集合内都可以
                List<Goods> anotherList = new ArrayList<>(goods.length);
                anotherList.addAll(oneList);
                resultLists.add(anotherList);
                anotherList.add(goods[i]);
                iterateSourceBack(i - 1, j - goods[i].weight, valueTable, anotherList, resultLists, goods);
            }
            // goods[i] 在不在最优解集合内， 都要迭代f(i-1,j)
            iterateSourceBack(i - 1, j, valueTable, oneList, resultLists, goods);
        }
    }


}

