package timcat.arithmetic;

import java.util.*;

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
    public List<List<String>> iterationMethod( String [] data){
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


    public List<List<String>> permutationRec(String [] data){
        int num = 1;

        for (int i = data.length; i > 0; i--) {
            num *= i;
        }

        List<List<String>> result = new ArrayList<>(num);
        permutationRecBase(data, 0, result);
        return result;
    }

    public  void permutationRecBase(String [] data, int step, List<List<String>> result){
        if(step + 1 == data.length){
            //　这里一定要使用Arrays.copyOf复制data数组的数据，不能直接当参数传入，否则result数组的所有元素会指向data数组，
            //　对data数组的修改都会反应到result数组的所有元素上，造成result数组的所有元素都是最初传入的data或计算完的data数组（两者的值相等）,
            //　即运算结果不会改变data数组
            List<String> onePermutation = Arrays.asList(Arrays.copyOf(data, data.length));
            result.add(onePermutation);
            return;
        }
        else{
            String temp;
            for(int i = step; i < data.length; i++){
                // 对于不同下标的位置的交换，交换前先判断交换的元素的是否是一样的，如果是一样则不交换
                // 对于同一下标的交换，让其执行一次并原样输出
                if(i != step && data[i].equals(data[step])){
                    continue;
                }
                // 将当前的位置与迭代位置交换
                temp = data[i];
                data[i] = data[step];
                data[step] = temp;

                permutationRecBase(data, step + 1, result);

                // 恢复交换前状态
                temp = new String(data[i]);
                data[i] = data[step];
                data[step] = temp;
            }
        }
    }
}
