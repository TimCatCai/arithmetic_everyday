package timcat.arithmetic;

import java.util.ArrayList;
public class Kmp {

    private static int [] kmpNext(String subString){
        int [] next = new int[subString.length() + 1];
        int i = 0;
        next[i] = -1;
        int nextCompareIndex = -1 ;
        while(i < subString.length()){
            if(nextCompareIndex < 0 || subString.charAt(i) == subString.charAt(nextCompareIndex)){
                i++;
                next[i] = ++ nextCompareIndex;
            }else{
                nextCompareIndex = next[nextCompareIndex];
            }
        }

        return next;
    }

    public static int kmp(String origin, String subString){
        int [] next = kmpNext(subString);
        int currentMatchingLen = 0;
        int i = 0;
        while(i < origin.length() && currentMatchingLen < subString.length()){
            if(currentMatchingLen < 0 || origin.charAt(i) == subString.charAt(currentMatchingLen)){
                i++;
                currentMatchingLen++;
            }else{
                currentMatchingLen = next[currentMatchingLen];
            }

            if(subString.length() == currentMatchingLen){
                i = i - subString.length();
            }
        }

        return i == origin.length() ? -1 : i;
    }

    public ArrayList<Integer> kmpAll(String origin, String subString){
        int [] next = kmpNext(subString);
        int currentMatchingLen = 0;
        int i = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i < origin.length()){
            if(currentMatchingLen < 0 || origin.charAt(i) == subString.charAt(currentMatchingLen)){
                i++;
                currentMatchingLen++;
            }else{
                currentMatchingLen = next[currentMatchingLen];
            }

            if(subString.length() == currentMatchingLen){
                result.add(i - subString.length());
                currentMatchingLen = next[currentMatchingLen];
            }
        }

        return result;
    }

}
