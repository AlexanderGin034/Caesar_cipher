package com.example.caesar_cipher.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherBruteForceTest {
    String startText = "Среди геймеров бытует мнение, будто видеоигры должны быть вне политики. Однако история говорит об обратном. Ещё в прошлом веке темы, связанные с политикой, поднимались в видеоиграх постоянно  всё-таки ими занимались люди, у которых были свои мысли и переживания. Один из самых ярких примеров  игры -х для консоли, центральной темой которых была защита окружающей среды. Ну а самым известным символом той эпохи, который спустя столько лет остаётся на слуху, был Соник.";
    String startText2 = "н. э.).";
    String startText3 = "Гм... да... всё в руках человека, и всё-то он мимо носу проносит, единственно от одной трусости... это уж аксиома... Любопытно, чего люди больше всего боятся? Нового шага, нового собственного слова они всего больше боятся... А впрочем, я слишком много болтаю. Оттого и ничего не делаю, что болтаю. Пожалуй, впрочем, и так: оттого болтаю, что ничего не делаю. Это я в этот последний месяц выучился болтать, лежа по целым суткам в углу и думая... о царе Горохе. Ну зачем я теперь иду? Разве я способен на это? Разве это серьезно? Совсем не серьезно. Так, ради фантазии сам себя тешу; игрушки! Да, пожалуй что и игрушки!»";
    String startText4 = "Марк Юний Брут (лат. Marcus Junius Brutus; зима 85 года до н. э., Рим—23 октября 42 года до н. э., у Филипп, Македония) — римский политический деятель и военачальник из плебейского рода Юниев, известный в первую очередь как убийца Гая Юлия Цезаря. На ранних этапах своей карьеры, в 50-е годы до н. э., считался видным оратором и получил почётный титул princeps iuventutis — «первый среди молодёжи». В гражданской войне между Цезарем и Помпеем встал на сторону последнего (49 год до н. э.). После битвы при Фарсале перешёл на сторону Цезаря и занял видное место в его окружении. Получил претуру на 44 год до н. э. и должен был стать консулом в 41 году. Несмотря на это и на близкие отношения с Цезарем (некоторые источники сообщают, что Гай Юлий мог быть его биологическим отцом), Брут стал одним из организаторов и непосредственных участников убийства диктатора, которое произошло 15 марта 44 года до н. э. Целью заговорщиков было восстановление республики, но они не получили поддержки в Риме и были вынуждены оставить Италию. Брут уехал в Македонию, где собрал армию для борьбы с политическими наследниками Гая Юлия — Марком Антонием, Октавианом и Марком Эмилием Лепидом, создавшими Второй триумвират. Он разбил цезарианского наследника Иллирии и силой заставил города Ликии дать ему денег и солдат. Объединившись с Гаем Кассием Лонгином, Брут сразился с главными силами врага при Филиппах в октябре 42 года до н. э. и покончил с собой после поражения.";
    String mineEncoding = new CaesarCipherCodeImpl(startText2, "1").encoding();
    String mineDecode = new CaesarCipherCodeImpl(mineEncoding, "1").decode();
    CaesarCipherBruteForce bruteForce = new CaesarCipherBruteForce(mineEncoding);
    char[] mineChars = startText2.toCharArray();

    @Test
    void isBruteForce() {
        System.out.println(mineDecode);
        assertEquals(startText2, bruteForce.isBruteForce());
        System.out.println(bruteForce.isBruteForce());
    }

    @Test
    void getIsUpperCase() throws NumberFormatException {
        System.out.println(mineChars);
        new CaesarCipherBruteForce(mineDecode).getIsUpperCase(mineChars);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsUpperCase(mineChars));
    }

    @Test
    void getIsSpace() {
        System.out.println();
        new CaesarCipherBruteForce(mineDecode).getIsSpace(mineChars);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsSpace(mineChars));
    }

    @Test
    void getIsQuote() {
        System.out.println(mineDecode);
        new CaesarCipherBruteForce(mineDecode).getIsQuote(mineChars);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsQuote(mineChars));
    }

    @Test
    void getIsSoftSymbol() {
        System.out.println(mineDecode);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsSoftSymbol(mineChars));
    }

    @Test
    void getIsHardSymbol() {
        System.out.println(mineDecode);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsHardSymbol(mineChars));
    }

    @Test
    void getIsThreeVowels() {
        System.out.println(mineDecode);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsThreeVowels(mineChars));
    }

    @Test
    void getIsY() {
        System.out.println(mineDecode);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsY(mineChars));
    }

    @Test
    void getIsSibilantConsonants() {
        System.out.println(mineDecode);
        assertEquals(true, new CaesarCipherBruteForce(mineDecode).getIsSibilantConsonants(mineChars));
    }
}