package com.mironenko.task1_android;

import android.annotation.SuppressLint;

public abstract class Reverse {
    public static CharSequence reverseInput(CharSequence text) {
        StringBuilder resultString = new StringBuilder();
        String inputString = text.toString();
        String[] words = arrayWords(inputString);
        for (String str : words) {
            resultString.append(reverse(str));
            resultString.append(" ");
        }
        return resultString;
    }

    private static String[] arrayWords(String inputString) {
        return inputString.split(" ");
    }



    @SuppressLint("NewApi")
    private static char[] reverse(String word) {
        char[] str = word.toCharArray();
        int r = str.length - 1, l = 0;
        while (l < r) {
            if (!Character.isAlphabetic(str[l]))
                l++;
            else if (!Character.isAlphabetic(str[r]))
                r--;
            else {
                char tmp = str[l];
                str[l] = str[r];
                str[r] = tmp;
                l++;
                r--;
            }
        }
        return str;
    }
}
