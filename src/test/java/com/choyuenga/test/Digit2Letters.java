package com.choyuenga.test;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Digit2Letters
 * @Description This is a digits to letters' test of the mini-coding test
 * @Author Hugo Cho
 * @DATE 2019-06-18 23:17
 * @Version 1.0
 */
public class Digit2Letters {


    @Test
    public void digits2Letters() {
        int[] testArray = {0,2,3};
        String splicingStrings = changeArray2String(testArray);
        List<String> result = letterCombinations(splicingStrings);
        for (String s : result) {
            System.out.println(s);
        }
    }

    /**
     * Given an integer array containing digits from [0, 9],it might be like [12,0,4].
     * This method will change the inputArray to String like 1204
     *
     * @param inputArray Array which need to change
     * @return array element splicing strings
     */
    private String changeArray2String(int[] inputArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputArray.length; i++) {
            sb.append(inputArray[i]);
        }
        return sb.toString();
    }

    /**
     * Calculate letter combinations based on strings.
     * The string might be like 23,this method will calculate all combinations -> ad ae af bd be bf cd ce cf
     *
     * @param digits splicing strings
     * @return letterCombinations
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        //Iterate digits to get mapping of digit to letters like telephone buttons
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);

            String str = null;
            //0 and 9 are not processed
            switch (digit) {
                case '2':
                    str = "abc";
                    break;
                case '3':
                    str = "def";
                    break;
                case '4':
                    str = "ghi";
                    break;
                case '5':
                    str = "jkl";
                    break;
                case '6':
                    str = "mno";
                    break;
                case '7':
                    str = "pqrs";
                    break;
                case '8':
                    str = "tuv";
                    break;
                case '9':
                    str = "wxyz";
                    break;
                default:
                    str = "";
            }
            //Processing the result list of digit to letters
            result = getNewString(result, str);
        }
        return result;
    }

    /**
     * Put the old result list it will be return the new result list.
     *
     * @param oldList old result list
     * @param digitString  digit to letters
     * @return new result list
     */
    private List<String> getNewString(List<String> oldList, String digitString) {
        if (oldList.size() == 0) {
            oldList = new ArrayList<>(digitString.length());
            for (int i = 0; i < digitString.length(); i++) {
                oldList.add(digitString.charAt(i) + "");
            }
            return oldList;
        }
        //The length of the result of the new result list should be the sum of the length of the old list and the length of digitString
        ArrayList<String> newList = new ArrayList<>(oldList.size() * digitString.length());
        for (String string : oldList) {
            for (int i = 0; i < digitString.length(); i++) {
                newList.add(string + digitString.charAt(i));
            }
        }
        //help GC
        oldList = null;
        return newList;
    }

}
