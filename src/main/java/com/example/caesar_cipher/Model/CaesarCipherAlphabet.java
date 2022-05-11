package com.example.caesar_cipher.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaesarCipherAlphabet {
    private static String ALPHABET_RUS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    private static String ALPHABET_UP = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static String ALPHABET_LOW = "бвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static String ALPHABET_END_SYMBOL = ".!?";
    private static String ALPHABET_SPACE = " ";
    private static String ALPHABET_VOWELS = "АОУИЙЕЁЮЯЫЭаоуийеёюяыэ";
    private static String ALPHABET_PUNCTUATION_MARKS =  "\",:.!?";
    private static String ALPHABET_SOFT_SYMBOL = "ь";
    private static String ALPHABET_HARD_SYMBOL = "ъ";
    private static String ALPHABET_SOFT_HARD_VOWELS = "еёюяи ";
    private static String ALPHABET_HARD_VOWELS = "еюя";
    private static String ALPHABET_SOFT_CONSONANTS_BEFORE = "лстчнрдвпшщжзм";
    private static String ALPHABET_SIBILANT_CONSONANTS = "ШЩшщ";
    private static String ALPHABET_CONNECTING_VOWELS = "оеОЕЯя";
    private static String ALPHABET_QUOTES = "«»\"";

    private CaesarCipherAlphabet(){}

    public static String getAlphabet(){
        return ALPHABET_RUS;
    }
    public static char[] getAlphabetUp() {
        return ALPHABET_UP.toCharArray();
    }
    public static char[] getAlphabetlow() {
        return ALPHABET_LOW.toCharArray();
    }
    public static char[] getAlphabetEndSymbol() {
        return ALPHABET_END_SYMBOL.toCharArray();
    }
    public static char[] getAlphabetSpase() {
        return ALPHABET_SPACE.toCharArray();
    }
    public static char[] getAlphabetVowels() {
        return ALPHABET_VOWELS.toCharArray();
    }
    public static char[] getAlphabetPunctuationMarks() {
        return ALPHABET_PUNCTUATION_MARKS.toCharArray();
    }
    public static char getAlphabetSoftSymbol() {
        return ALPHABET_SOFT_SYMBOL.charAt(0);
    }
    public static char getAlphabetHardSymbol() {
        return ALPHABET_HARD_SYMBOL.charAt(0);
    }
    public static char[] getAlphabetSoftHardVowels() {
        return ALPHABET_SOFT_HARD_VOWELS.toCharArray();
    }
    public static char[] getAlphabetHardVowels() {
        return ALPHABET_HARD_VOWELS.toCharArray();
    }
    public static char[] getAlphabetSoftConsonantsBefore() { return ALPHABET_SOFT_CONSONANTS_BEFORE.toCharArray(); }
    public static char[] getAlphabetSibilantConsonants() { return ALPHABET_SIBILANT_CONSONANTS.toCharArray(); }
    public static char[] getAlphabetConnectingVowels() {
        return ALPHABET_CONNECTING_VOWELS.toCharArray();
    }
    public static char[] getAlphabetQuotes() { return ALPHABET_QUOTES.toCharArray(); }
 }
