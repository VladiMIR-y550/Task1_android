package com.mironenko.task1_android;

import android.os.Build;
import android.text.Editable;

import androidx.annotation.RequiresApi;

public abstract class Reverse {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Editable reverseInput(Editable inputText) {
        StringBuilder resultString = new StringBuilder();
        String inputString = inputText.toString();
        String[] words = arrayWords(inputString);
        for (int i = 0; i < words.length; i++) {
            if (i != words.length - 1) {
                resultString.append(reverse(words[i]));
                resultString.append(" ");
            } else {
                resultString.append(reverse(words[i]));
            }
        }

        return inputText.replace(0, inputText.length(), resultString);
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
        return String.valueOf(str).intern();
    }
}