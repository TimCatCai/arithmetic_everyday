package timcat.leetcode.day1;

public class Test {
    public static void main(String [] args){
        SumOfTwo sumOfTwo = new SumOfTwo();
        int [] test1 = {66};
        int test1Target = 9;
        printResult(sumOfTwo.violentMethod(test1,test1Target),test1);
        test1Target = 22;
        printResult(sumOfTwo.violentMethod(test1,test1Target),test1);
        test1Target = 33;
        printResult(sumOfTwo.violentMethod(test1,test1Target),test1);

        test1Target = 9;
        printResult(sumOfTwo.oneHashMatch(test1,test1Target),test1);
        test1Target = 22;
        printResult(sumOfTwo.oneHashMatch(test1,test1Target),test1);
        test1Target = 33;
        printResult(sumOfTwo.oneHashMatch(test1,test1Target),test1);

        test1Target = 9;
        printResult(sumOfTwo.twoHashMatch(test1,test1Target),test1);
        test1Target = 22;
        printResult(sumOfTwo.twoHashMatch(test1,test1Target),test1);
        test1Target = 33;
        printResult(sumOfTwo.twoHashMatch(test1,test1Target),test1);
    }

    private static void printResult(int [] result,int [] test){
        if(result[0] != -1 && result[1] != -1){
            System.out.println("First: index: " + result[0] + " data: " + test[result[0]]
                    + " Second: index: " + result[1] + " data: " + test[result[1]]);
        }else{
            System.out.println("No such data in the array");
        }
    }
}
