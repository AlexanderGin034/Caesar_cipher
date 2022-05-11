package com.example.caesar_cipher.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherStatisticalDataTest {

    @Test
    void getListToStringBuilder() {
        String str = "Как дела";
        List<Character> list = str.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();

        assertEquals(str, new CaesarCipherStatisticalData("", "")
                .getListToStringBuilder(list, builder));
    }

    @Test
    void getResultStatisticData() {
        CaesarCipherStatisticalData statisticalData = new CaesarCipherStatisticalData("", "");
        String textCode = "МвмБёжнвА";
        String textSource = "Как дела?";

        Map<Character, Long> code = statisticalData.getMapPercentOfSymbolTest(textCode);
        Map<Character, Long> source = statisticalData.getMapPercentOfSymbolTest(textSource);

        List<Character> charsList = textCode.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Character, Long> entryCode: code.entrySet()) {
            for (Map.Entry<Character, Long> entrySource: source.entrySet()) {
                if (entryCode.getValue().equals(entrySource.getValue())) {
                    statisticalData.replaceCharTest(charsList, entrySource.getKey(), entryCode.getKey());
                   // source.remove(entrySource.getKey());
                }
            }
        }
        assertEquals(textSource, statisticalData.listToStringBuilderTest(charsList, builder));
    }

    @Test
    void replaceCharTest() {
        CaesarCipherStatisticalData statisticalData = new CaesarCipherStatisticalData("", "");
        String textCode = "МвмБёжнвА";
        String textResult = "МвмБёжйвА";
        List<Character> charsList = textCode.chars().mapToObj(character -> (char) character).collect(Collectors.toList());
        //charsList.set(6, 'd');
        statisticalData.replaceCharTest(charsList, 'н', 'й');

        assertEquals(textResult, statisticalData.listToStringBuilderTest(charsList, new StringBuilder()));
    }
}