package numberrangesummarizer;

import java.util.List;

public class UnitTestsNumberRangeSummarizer {

    private static NumberRangeSummarizer summarizer = new NumberRangeSummarizer();

    public static void main(String[] args) {
        /** Test Cases 1-7 are for the collect method*/
        test1(); // test base case ascending order input string
        test2(); // test extra comma values in input string
        test3(); // test out of order input string
        test4(); // test out of order and negative value input string
        test5(); // empty input string
        test6(); // only comma containing input string
        test7(); // duplicate value input string


    }

    /**
     * Test the Collect method
     * Test the provided input example, an ascending ordered input list with ranges and stand-alone values
     */
    public static void test1() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Integer[] expectedElements = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        summarizer.collect(input);
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 1 FAILED");
                return;
            }
        }
        System.out.println("Test 1 PASSED");
    }

    /**
     * Test the Collect method
     * Test extra comma values in the input
     * Uses the provided input example, an ascending ordered input list with ranges and stand-alone values
     */
    public static void test2() {
        String input = ",,,1,3,6,7,8,,,12,,13,14,15,21,22,23,24,31,,,";
        Integer[] expectedElements = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        summarizer.collect(input);
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 2 FAILED");
                return;
            }
        }
        System.out.println("Test 2 PASSED");
    }

    /**
     * Test the Collect method
     * Test out-of-order input
     * Uses the provided input example with ranges and stand-alone values
     */
    public static void test3() {
        String input = "1,22,6,7,31,12,13,14,15,21,3,23,24,8";
        Integer[] expectedElements = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        summarizer.collect(input);
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 3 FAILED");
                return;
            }
        }
        System.out.println("Test 3 PASSED");
    }

    /**
     * Test the Collect method
     * Test out-of-order and negative value input
     * Uses the provided input example with ranges and stand-alone values
     */
    public static void test4() {
        String input = "-3,21,31,22,15,8,-14,-1,-12,6,23,24,7,-13";
        Integer[] expectedElements = {-14,-13,-12,-3,-1,6,7,8,15,21,22,23,24,31};
        summarizer.collect(input);
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 4 FAILED");
                return;
            }
        }
        System.out.println("Test 4 PASSED");
    }

    /**
     * Test the Collect method
     * Test empty input string
     */
    public static void test5() {
        String input = "";
        Integer[] expectedElements = {};
        summarizer.collect(input);
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 5 FAILED");
                return;
            }
        }
        System.out.println("Test 5 PASSED");
    }

    /**
     * Test the Collect method
     * Test empty input string with commas
     */
    public static void test6() {
        String input = ",,,";
        Integer[] expectedElements = {};
        summarizer.collect(input);
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 6 FAILED");
                return;
            }
        }
        System.out.println("Test 6 PASSED");
    }

    /**
     * Test the Collect method
     * Duplicate value input
     */
    public static void test7() {
        String input = "1,3,3,3,6,7,8,12,13,14,15,21,21,22,23,24,31";
        Integer[] expectedElements = {1,3,3,3,6,7,8,12,13,14,15,21,21,22,23,24,31};
        summarizer.collect(input);
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i) != expectedElements[i]) {
                System.out.println("Test 7 FAILED");
                return;
            }
        }
        System.out.println("Test 7 PASSED");
    }

}
