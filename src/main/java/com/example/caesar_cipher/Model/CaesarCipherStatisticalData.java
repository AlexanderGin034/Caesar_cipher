package com.example.caesar_cipher.Model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaesarCipherStatisticalData {
    private String statisticOfCode;
    private String statisticOfSource;

    public CaesarCipherStatisticalData (String statisticOfCode, String statisticOfSource) {
        this.statisticOfCode = statisticOfCode;
        this.statisticOfSource = statisticOfSource;
    }

    public String getResultStatisticData() {
        Map<Character, Long> code = getMapPercentOfSymbol(statisticOfCode);
        Map<Character, Long> source = getMapPercentOfSymbol(statisticOfSource);
        List<Character> charsList = statisticOfCode.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Character, Long> entryCode: code.entrySet()) {
            for (Map.Entry<Character, Long> entrySource: source.entrySet()) {
                if (entryCode.getValue().equals(entrySource.getValue())) {
                    replaceChar(charsList, entryCode.getKey(),entrySource.getKey() );
                }
            }
        }
        return listToStringBuilder(charsList, builder);
    }

    private Map<Character, Long> getMapPercentOfSymbol(String text) {
        Map<Character, Long> statistics = new HashMap<>();
        char[] charsText = text.toLowerCase(Locale.ROOT).toCharArray();
        char[] charsAlphabet = CaesarCipherAlphabet.getAlphabet().toCharArray();
        int sizeChars = charsText.length;
        int countChar;
        double percent;
        char ch;

        for (int i = 0; i < charsAlphabet.length; i++) {
            countChar = getCountOfSymbol(charsAlphabet[i], charsText);
            ch = charsAlphabet[i];

            if (countChar != 0) {
                percent = (double) countChar/sizeChars*100;
                statistics.put(ch, Math.round(percent));
            }
        }
        return statistics;
    }

    public Map<Character, Long> getMapPercentOfSymbolTest(String text) {
        return getMapPercentOfSymbol(text);
    }

    private  int getCountOfSymbol(char ch, char[] chars) {
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (ch == chars[i]) {
                count += 1;
            }
        }
        return count;
    }

    private void replaceChar(List<Character> characterList, Character charMapCode, Character charMapSource) {
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).equals(charMapCode)) {
                characterList.set(i, charMapSource);
            }
        }
    }

    public void replaceCharTest(List<Character> characterList, Character charMapCode, Character charMapSource) {
        replaceChar(characterList, charMapCode, charMapSource);
    }

    private String listToStringBuilder(List<Character> list, StringBuilder builder) {
        for (Character ch: list) {
            builder.append(ch);
        }

        return builder.toString();
    }

    public String listToStringBuilderTest(List<Character> list, StringBuilder builder) {
        return listToStringBuilder(list, builder);
    }

    public String getListToStringBuilder(List<Character> list, StringBuilder builder) {
        return listToStringBuilder(list, builder);
    }
}
