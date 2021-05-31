package com.mironenko.task1_android;

import android.os.Build;

import androidx.annotation.RequiresApi;

public abstract class Reverse {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String reverseInput(String inputText) {
        StringBuilder resultString = new StringBuilder();
        String[] words = arrayWords(inputText);
        for (String word : words) {
            resultString.append(reverse(word));
            resultString.append(" ");
        }

        return resultString.toString().trim();
    }

    private static String[] arrayWords(String inputString) {
        return inputString.split(" ");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String reverse(String word) {
        char[] str = word.toCharArray();
        int r = str.length - 1;
        int l = 0;
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
        return String.valueOf(str);
    }
}