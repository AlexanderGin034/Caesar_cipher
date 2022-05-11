package com.example.caesar_cipher.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CaesarCipherCodeImpl implements CaesarCipherCode {
    private String textArea;
    private int key;

    public CaesarCipherCodeImpl(String textArea, String key) throws NumberFormatException{
        this.textArea = textArea;
        if (Integer.parseInt(key) > 0) {
            this.key = Integer.parseInt(key);
        }else {
            throw new NumberFormatException();
        }
    }

    @Override
    public String encoding() {
        char[] charsTextArea = textArea.toCharArray();
        char[] charsAlphabet = CaesarCipherAlphabet.getAlphabet().toCharArray();
        StringBuilder builder = new StringBuilder();
        int keyCast = 0;
        int countMatch;

        for (int i = 0; i < charsTextArea.length; i++) {
            countMatch = 0;
            for (int j = 0; j < charsAlphabet.length; j++) {
                if (charsTextArea[i] == charsAlphabet[j]) {
                    countMatch = 1;
                    keyCast = j;
                    for (int k = 1; k <= key; k++) {
                        if ((keyCast+1) > charsAlphabet.length-1) {
                            keyCast = 0;
                        }else {
                            keyCast += 1;
                        }
                    }
                    builder.append(charsAlphabet[keyCast]);
                    break;
                }
            }
            if (countMatch == 0) builder.append(charsTextArea[i]);
        }
        return builder.toString();
    }

    @Override
    public String decode() {
        char[] charsTextArea = textArea.toCharArray();
        char[] charsAlphabet = CaesarCipherAlphabet.getAlphabet().toCharArray();
        StringBuilder builder = new StringBuilder();
        int keyCast = 0;
        int countMatch;

        for (int i = 0; i < charsTextArea.length; i++) {
            countMatch = 0;
            for (int j = 0; j < charsAlphabet.length; j++) {
                if (charsTextArea[i] == charsAlphabet[j]) {
                    keyCast = j;
                    countMatch = 1;
                    for (int k = 1; k <= key; k++) {
                        if ((keyCast-1) < 0) {
                            keyCast = charsAlphabet.length-1;
                        }else {
                            keyCast -= 1;
                        }
                    }
                    builder.append(charsAlphabet[keyCast]);
                    break;
                }
            }
            if (countMatch == 0) builder.append(charsTextArea[i]);
        }
        return builder.toString();
    }
}
