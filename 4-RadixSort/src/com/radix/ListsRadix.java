package com.radix;

import java.util.ArrayList;
import java.util.Hashtable;

/*
Implementation of the 10 lists to make the sorting
 */
public class ListsRadix {
    final Hashtable<Integer, ArrayList<String>> lists;
    final int SIZE_LIST = 10;

    public ListsRadix() {
        lists = new Hashtable<>();
        for (int i = 0; i < SIZE_LIST; i++) {
            lists.put(i, new ArrayList<>());
        }
    }

    public void clearLists() {
        for (int i = 0; i < SIZE_LIST; i++) {
            lists.put(i, new ArrayList<>());
        }
    }

    public void addNumberToLists(String number, int actualNDigit) {
        //Get the digit to determine de number of list
        int digit = Integer.parseInt(String.valueOf(number.charAt(actualNDigit)));
        //Add the number to the array list of the ideal list
        lists.get(digit).add(number);
    }

    public String[] dumpListsToStringArray() {
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            ArrayList<String> currentList = lists.get(i);
            out.addAll(currentList);
        }
        return out.toArray(new String[0]);
    }
}
