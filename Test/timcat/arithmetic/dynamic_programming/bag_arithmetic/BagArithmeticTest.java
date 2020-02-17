package timcat.arithmetic.dynamic_programming.bag_arithmetic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class BagArithmeticTest {
    BagArithmetic arithmetic = new BagArithmetic();

    @ParameterizedTest
    @CsvFileSource(resources = "napsack.csv")
    void napsack(ArgumentsAccessor argumentsAccessor) {
        int capacity = argumentsAccessor.getInteger(0);
        int goodNumber = argumentsAccessor.getInteger(1);
        Goods[] goods = new Goods[goodNumber + 1];
        int i;

        for (i = 1; i <= goodNumber; i++) {
            goods[i] = new Goods();
            goods[i].weight = argumentsAccessor.getInteger(i*2);
            goods[i].value = argumentsAccessor.getInteger(i*2+1);
        }
        // 输出信息
        int[][] wv = new int[goodNumber][3];
        for (int j = 0; j < goodNumber; j++) {
            wv[j][0] = j + 1;
            wv[j][1] = goods[j + 1].weight;
            wv[j][2] = goods[j + 1].value;

        }
        String[] title = {"物品", "重量", "价值/美元"};
        arithmetic.printTable(title, wv);
        assertEquals(argumentsAccessor.getInteger(i*2), arithmetic.napsack(capacity, goods));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "napsack.csv")
    void MFKnapsack(ArgumentsAccessor argumentsAccessor) {
        int capacity = argumentsAccessor.getInteger(0);
        int goodNumber = argumentsAccessor.getInteger(1);
        Goods[] goods = new Goods[goodNumber + 1];
        int i;

        for (i = 1; i <= goodNumber; i++) {
            goods[i] = new Goods();
            goods[i].weight = argumentsAccessor.getInteger(i*2);
            goods[i].value = argumentsAccessor.getInteger(i*2+1);
        }
        // 输出信息
        int[][] wv = new int[goodNumber][3];
        for (int j = 0; j < goodNumber; j++) {
            wv[j][0] = j + 1;
            wv[j][1] = goods[j + 1].weight;
            wv[j][2] = goods[j + 1].value;

        }
        String[] title = {"物品", "重量", "价值/美元"};
        arithmetic.printTable(title, wv);
        assertEquals(arithmetic.napsack(capacity,goods), arithmetic.MFKnapsack(capacity, goods));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "napsack.csv")
    void sourceBack(ArgumentsAccessor argumentsAccessor) {
        napsack(argumentsAccessor);

    }
}