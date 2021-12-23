package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UnitTestsNumberRangeSummarizer {

    private static NumberRangeSummarizer summarizer = new NumberRangeSummarizer();
    private static int passedCount = 0;

    public static void main(String[] args) {
        /** Test Cases 1-7 are for the collect method*/
        test1(); // test base case ascending order input string
        test2(); // test extra comma values in input string
        test3(); // test out of order input string
        test4(); // test out of order and negative value input string
        test5(); // empty input string
        test6(); // only comma containing input string
        test7(); // duplicate value input string

        /** Test Cases 8-11 are for the summarizeCollection method*/
        test8(); // test base case ascending order input
        test9(); //  negative value input
        test10(); // empty input
        test11(); // duplicate value input
        test12(); // range at start of string
        test13(); // range at end of string

        System.out.println("Passed test cases: " + passedCount + "/13");
    }

    /**
     * Test the Collect method
     * Test the provided input example, an ascending ordered input list with ranges and stand-alone values
     */
    private static void test1() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Integer[] expectedElements = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 1 FAILED");
                return;
            }
        }
        System.out.println("Test 1 PASSED");
        passedCount++;
    }

    /**
     * Test the Collect method
     * Test extra comma values in the input
     * Uses the provided input example, an ascending ordered input list with ranges and stand-alone values
     */
    private static void test2() {
        String input = ",,,1,3,6,7,8,,,12,,13,14,15,21,22,23,24,31,,,";
        Integer[] expectedElements = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 2 FAILED");
                return;
            }
        }
        System.out.println("Test 2 PASSED");
        passedCount++;
    }

    /**
     * Test the Collect method
     * Test out-of-order input
     * Uses the provided input example with ranges and stand-alone values
     */
    private static void test3() {
        String input = "1,22,6,7,31,12,13,14,15,21,3,23,24,8";
        Integer[] expectedElements = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 3 FAILED");
                return;
            }
        }
        System.out.println("Test 3 PASSED");
        passedCount++;
    }

    /**
     * Test the Collect method
     * Test out-of-order and negative value input
     * Uses the provided input example with ranges and stand-alone values
     */
    private static void test4() {
        String input = "-3,21,31,22,15,8,-14,-1,-12,6,23,24,7,-13";
        Integer[] expectedElements = {-14,-13,-12,-3,-1,6,7,8,15,21,22,23,24,31};
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 4 FAILED");
                return;
            }
        }
        System.out.println("Test 4 PASSED");
        passedCount++;
    }

    /**
     * Test the Collect method
     * Test empty input string
     */
    private static void test5() {
        String input = "";
        Integer[] expectedElements = {};
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 5 FAILED");
                return;
            }
        }
        System.out.println("Test 5 PASSED");
        passedCount++;
    }

    /**
     * Test the Collect method
     * Test empty input string with commas
     */
    private static void test6() {
        String input = ",,,";
        Integer[] expectedElements = {};
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 6 FAILED");
                return;
            }
        }
        System.out.println("Test 6 PASSED");
        passedCount++;
    }

    /**
     * Test the Collect method
     * Duplicate value input
     */
    private static void test7() {
        String input = "1,3,3,3,6,7,8,12,13,14,15,21,21,22,23,24,31";
        Integer[] expectedElements = {1,3,3,3,6,7,8,12,13,14,15,21,21,22,23,24,31};
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 7 FAILED");
                return;
            }
        }
        System.out.println("Test 7 PASSED");
        passedCount++;
    }

    /**
     * Test the summarizeCollection method
     * Test the provided input example, an ascending ordered input list with ranges and stand-alone values
     */
    private static void test8() {
        List<Integer> list = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31);
        Collection<Integer> collection = list;

        String summarisedString = summarizer.summarizeCollection(collection);
        if (summarisedString.equals("1, 3, 6-8, 12-15, 21-24, 31")) {
            System.out.println("Test 8 PASSED");
            passedCount++;
        } else {
            System.out.println("Test 8 FAILED");
        }
    }



    /**
     * Test the summarizeCollection method
     * Test negative value input
     */
    private static void test9() {
        List<Integer> list = Arrays.asList(-14,-13,-12,-3,-1,6,7,8,15,21,22,23,24,31);
        Collection<Integer> collection = list;

        String summarisedString = summarizer.summarizeCollection(collection);
        if (summarisedString.equals("-14--12, -3, -1, 6-8, 15, 21-24, 31")) {
            System.out.println("Test 9 PASSED");
            passedCount++;
        } else {
            System.out.println("Test 9 FAILED");
        }
    }

    /**
     * Test the summarizeCollection method
     * Test empty input
     */
    private static void test10() {
        List<Integer> list = Arrays.asList();
        Collection<Integer> collection = list;

        String summarisedString = summarizer.summarizeCollection(collection);
        if (summarisedString.equals("")) {
            System.out.println("Test 10 PASSED");
            passedCount++;
        } else {
            System.out.println("Test 10 FAILED");
        }
    }

    /**
     * Test the summarizeCollection method
     * Duplicate value input
     */
    private static void test11() {
        List<Integer> list = Arrays.asList(1,3,3,3,6,7,8,12,13,14,15,21,21,22,23,24,31);
        Collection<Integer> collection = list;

        String summarisedString = summarizer.summarizeCollection(collection);
        if (summarisedString.equals("1, 3, 6-8, 12-15, 21-24, 31")) {
            System.out.println("Test 11 PASSED");
            passedCount++;
        } else {
            System.out.println("Test 11 FAILED");
        }
    }

    /**
     * Test the summarizeCollection method
     * Range at the start of the string
     */
    private static void test12() {
        List<Integer> list = Arrays.asList(1,2,3,6,7,8,12,13,14,15,21,22,23,24,31);
        Collection<Integer> collection = list;

        String summarisedString = summarizer.summarizeCollection(collection);
        if (summarisedString.equals("1-3, 6-8, 12-15, 21-24, 31")) {
            System.out.println("Test 12 PASSED");
            passedCount++;
        } else {
            System.out.println("Test 12 FAILED");
        }
    }


    /**
     * Test the summarizeCollection method
     * Range at the end of the string
     */
    private static void test13() {
        List<Integer> list = Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31,32,33);
        Collection<Integer> collection = list;

        String summarisedString = summarizer.summarizeCollection(collection);
        if (summarisedString.equals("1, 3, 6-8, 12-15, 21-24, 31-33")) {
            System.out.println("Test 13 PASSED");
            passedCount++;
        } else {
            System.out.println("Test 13 FAILED");
        }
    }

}
