package com.radix;

/*
Make the logic of radix using the respective lists
 */
public class Radix {

    public static int[] sort(int[] numbersToSort) {
        ListsRadix listsRadix = new ListsRadix();
        String[] text = StringUtil.toStringArray(numbersToSort);
        StringUtil.appendZerosToWord(text, '0');

        //Iterate the n digits and add to list
        int actualNDigit = text[0].length() - 1;
        while (actualNDigit >= 0) {
            listsRadix.clearLists();
            for (String s : text) {
                listsRadix.addNumberToLists(s, actualNDigit);
            }
            text = listsRadix.dumpListsToStringArray();
            actualNDigit--;
        }
        return StringUtil.toIntArray(text);
    }
}
