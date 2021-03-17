package utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static String emailDomain = "@qa.guru";

    public static String getRandomString(int length) { //формирует рандомный текст, кол-во символов = length
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomMessage(int min, int max) { //метод формирует рандомное сообщение
        String[] words = {"and", "or", "but", "because",
                "red", "white", "Jane", "John", "Bobby",
                "man", "woman", "fish", "elephant", "unicorn",
                "a", "the", "every", "some", "any", "all",
                "big", "tiny", "pretty", "bald", "small",
                "runs", "jumps", "talks", "sleeps", "walks",
                "loves", "hates", "sees", "knows", "looks for", "finds",
                ", ", ", ", ", ", ". ", ". "};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words.length - 1);
            message.append(words[wordIndex] + " ");
        }

        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static int getRandomInt(int min, int max) { // метод формирует рандомную цифру
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomPhone() { // метод формирует рандомный номер телефона
        return getRandomLong(11111111111111111L, 99999999999999999L) + "";
    }

    public static String getRandomPhone(String code) {
        return code + getRandomLong(11111111111111111L, 99999999999999999L);
    }

    public static String getRandomPhoneTenDigits() {
        return String.valueOf(getRandomLong(1111111111L, 9999999999L));
    }

    public static String getDifficultRandomPhone(String code) {
        return code + " (" + getRandomLong(111L, 999L) + ") " + getRandomLong(11111L, 999999L) + "-" + getRandomLong(111L, 999999L);
    }

    public static Long getRandomLong(Long min, Long max) {  // метод формирует рандомное число long
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomEmail() { // метод формирует рандомный email
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        return getRandomString(5) + timestamp + emailDomain;
    }

    public static String getRandomGender() {
        String[] gender = {"Female", "Male", "Other"};
        int genderIndex = getRandomInt(0, 2);
        return gender[genderIndex];
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int hobbyIndex = getRandomInt(0, 2);
        return hobbies[hobbyIndex];
    }

    public static String getRandomMonth() {
        int monthIndex = getRandomInt(1, 12);
        return Month.of(monthIndex).getDisplayName(TextStyle.FULL, Locale.forLanguageTag("en"));
    }

    public static String getRandomYear() {
        Random rand = new Random();
        return String.valueOf(1900 + rand.nextInt(2020 - 1900 + 1));
    }

}