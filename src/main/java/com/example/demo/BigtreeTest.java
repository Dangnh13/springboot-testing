package com.example.demo;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Bigtree exam
 *
 * @author dang.nh.aprotrain@gmail.com
 */
public class BigtreeTest {
public static final String SPLIT_SYMBOL="-";
public static final String VOWELS_REGEX="[ueoaiy]";
    public static final String DUP_SPLIT_SYMBOL="--";
    public static void main(String[] args) {
        // Task 1
        testUpdate("dangnh");
        //String[] classList = {"Ashley", "Robert", "Miles", "Archibald", "Taylor", "Vanessa", "Isaac"};
//        List<String> classList = new ArrayList<>();
//        for (int i = 0; i < 10000000; i++) {
//            classList.add(randomString(20));
//        }

//        String[] classList = {"Chruschtschov", "Hristo", "Nguyen", "Dmitry", "Madchen", "Fujiyama", "Connor"};
//        long startTime = System.currentTimeMillis();
//        System.out.println("Total attendance time: " + takingAttendance(classList));
//        System.out.println("Time spen process: " + (System.currentTimeMillis()-startTime)/1000);
//        System.out.println(cal2("isaac"));


//        String regex = "[ueoaiy]";
//        System.out.println(
//                Arrays.stream(classList).mapToInt(name ->
//                        Arrays.stream(name.replaceAll(regex, "-")
//                                        .replaceAll("--", "-")
//                                        .split("-"))
//                                .mapToInt(e -> (int) Math.pow(2, e.length() - 1))
//                                .sum() + 5
//                ).sum()
//        );
    }

    public static void testUpdate(String test) {
        test = test.concat("123");
        System.out.println(test);
    }

    /**
     * Calculate attendance time of class
     *
     * @param classList list of student name
     * @return total attendance time
     */
    public static int takingAttendance(List<String> classList) {
        return classList.stream()
//                .parallel()
                .mapToInt(BigtreeTest::calculateAttendanceTimeOfOnePerson)
                .sum();
    }

    /**
     * Calculate attendance time of one person in the class
     *
     * @param username who is attendance
     * @return time spent
     */
    public static int calculateAttendanceTimeOfOnePerson(String username) {
        String tmpUserName = username.toLowerCase().replaceAll(VOWELS_REGEX, SPLIT_SYMBOL);
        while (tmpUserName.contains(DUP_SPLIT_SYMBOL)) {
            tmpUserName = tmpUserName.replace(DUP_SPLIT_SYMBOL, SPLIT_SYMBOL);
        }
        return Stream.of(tmpUserName.split(SPLIT_SYMBOL))
                .mapToInt(e -> (int) Math.pow(2, e.length() - 1))
                .sum() + 5;
    }
    /**
     * Calculate attendance time of one person in the class
     *
     * @param username who is attendance
     * @return time spent
     */
    public static int cal3(String username) {
        List<String> vowels = Arrays.asList("u", "e", "o", "a", "i", "y");
        final String splitSymbol = "-";
        final String doubleSymbol = splitSymbol + splitSymbol;
        int timeSpent = 5;
        String tmpUserName = username.toLowerCase();
        for (String vowel : vowels) {
            tmpUserName = tmpUserName.replace(vowel, splitSymbol);
        }
        while (tmpUserName.contains(doubleSymbol)) {
            tmpUserName = tmpUserName.replace(doubleSymbol, splitSymbol);
        }
        String[] segmentNames = tmpUserName.split(splitSymbol);
        for (String segment : segmentNames) {
            timeSpent += Math.pow(2, segment.length() - 1);
        }
        return timeSpent;
    }


    public static int cal2(String username) {
        int rs = 5;
        List<String> vowels = Arrays.asList("u", "e", "o", "a", "i", "y");
        String segment = "";
        List<String> segmentList = new ArrayList<>();
        for (int i = 0; i < username.length(); i++) {
            if (!vowels.contains(String.valueOf(username.charAt(i)))) {
                segment = segment.concat(String.valueOf(username.charAt(i)));
            } else {
                segmentList.add(segment);
                segment = "";
            }
        }
        if (!segment.isEmpty()) segmentList.add(segment);

        rs += segmentList.stream().filter(e -> !e.isEmpty())
                .mapToInt(e -> (int) Math.pow(2, e.length() - 1))
                .sum();
        return rs;
    }

    static String randomString(final int length) {
        Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }
}
