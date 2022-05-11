package com.example.caesar_cipher.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CaesarCipherBruteForce {

    private String text;

    public CaesarCipherBruteForce(String text) {
        this.text = text;
    }

    public String isBruteForce() {
        int key = 1;

        while (key <= CaesarCipherAlphabet.getAlphabet().toCharArray().length) {
            String strEncode = new CaesarCipherCodeImpl(text, String.valueOf(key)).decode();
            char[] charsStr = strEncode.toCharArray();
            key += 1;
            if (isUpperCase(charsStr) && isY(charsStr) && isSibilantConsonants(charsStr) &&
                isThreeVowels(charsStr) && isHardSymbol(charsStr) && isSoftSymbol(charsStr) &&
                    isSpace(charsStr) && isQuote(charsStr)){
                return strEncode;
            }
        }
        return "Упс, текст не расшифрован :( ";
    }

    private boolean isUpperCase(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (checkList(chars[i], CaesarCipherAlphabet.getAlphabetUp())) {
                if (i == 0 || i == chars.length-1 || checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetPunctuationMarks()[0])) continue;
                if (checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetlow()) ||
                        checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetPunctuationMarks()) ||
                        (checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetUp()) &&
                        checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetlow()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getIsUpperCase(char[] chars) {
        return isUpperCase(chars);
    }

    private boolean isSpace(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(i == chars.length-1 || i == 0) continue;
            if (checkList(chars[i], CaesarCipherAlphabet.getAlphabetPunctuationMarks()) &&
                    !checkList(chars[i], CaesarCipherAlphabet.getAlphabetPunctuationMarks()[0]) &&
                    !checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetQuotes()) &&
                    !checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetPunctuationMarks()) &&
                    checkList(chars[i+1], CaesarCipherAlphabet.getAlphabet().toCharArray())) {
                if (checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetSpase()) ||
                        checkList(chars[i+1], '\n') ||
                        checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetPunctuationMarks()[3])) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getIsSpace(char[] chars) {
        return isSpace(chars);
    }
    
    private boolean isQuote(char[] chars) {
        char[] ch = CaesarCipherAlphabet.getAlphabetPunctuationMarks();
        int countOfQuote = 0;

        for (int i = 0; i < chars.length; i++) {
            if (checkList(chars[i], ch[0])) {
                countOfQuote += 1;
                if (i == chars.length-1) continue;
                if (checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetSpase()) ||
                        i == 0 || checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetPunctuationMarks())) continue;
                if (countOfQuote % 2 != 0) {
                    if (checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetSpase())) {
                        continue;
                    }else {
                        return false;
                    }
                }else {
                    if (//checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetSpase()) ||
                            checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetPunctuationMarks()) ||
                                i != chars.length-1 || checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetPunctuationMarks())) {
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean getIsQuote(char[] chars) {
        return isQuote(chars);
    }

    private boolean isSoftSymbol(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1) continue;
            if (checkList(chars[i], CaesarCipherAlphabet.getAlphabetSoftSymbol())) {
                if (checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetSoftConsonantsBefore())) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getIsSoftSymbol(char[] chars) {
        return isSoftSymbol(chars);
    }

    private boolean isHardSymbol(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1) continue;
            if (checkList(chars[i], CaesarCipherAlphabet.getAlphabetHardSymbol())) {
                if (checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetHardVowels()) && i != 0) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getIsHardSymbol(char[] chars) {
        return isHardSymbol(chars);
    }

    private boolean isThreeVowels(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1) continue;
            if (checkList(chars[i], CaesarCipherAlphabet.getAlphabetVowels()) &&
                    checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetVowels()) &&
                    !checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetConnectingVowels()) &&
                    checkList(chars[i+2], CaesarCipherAlphabet.getAlphabetVowels())) {
                return false;
            }
            continue;
        }
        return true;
    }

    public boolean getIsThreeVowels(char[] chars) {
        return isThreeVowels(chars);
    }

    private boolean isY(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(checkList(chars[i], CaesarCipherAlphabet.getAlphabetVowels()[15])){
                if (checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetVowels()) ||
                        checkList(chars[i-1], CaesarCipherAlphabet.getAlphabetSpase())) {
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getIsY(char[] chars) {
        return isY(chars);
    }

    private boolean isSibilantConsonants(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1) continue;
            if (checkList(chars[i], CaesarCipherAlphabet.getAlphabetSibilantConsonants())) {
                if (checkList(chars[i+1], CaesarCipherAlphabet.getAlphabetSibilantConsonants())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getIsSibilantConsonants(char[] chars) {
        return isSibilantConsonants(chars);
    }

    private boolean checkList(char ch, char[] alphabet) {
        for (char charArr: alphabet) {
            if (ch == charArr) {
                return true;
            }
        }
        return false;
    }

    private boolean checkList(char char1, char char2) {
        if (char1 == char2) return true;
        return false;
    }
}
