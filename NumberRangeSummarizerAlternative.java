package numberrangesummarizer;

import java.util.*;

/**
 * A class that takes as command line input a String containing a comma separated list of integer numbers and prints out a string
 * containing a comma delimited list of numbers, grouping the numbers into a range when they are sequential
 * Note: This implementation handles duplicate input values in the collect method
 */
public class NumberRangeSummarizerAlternative implements NumberRangeSummarizerInterface {

    public static void main(String[] args) {
        // initialise NumberRangeSummarizer
        NumberRangeSummarizerAlternative summarizer = new NumberRangeSummarizerAlternative();

        // create collection from command line input (args[0])
        List<Integer> collection = (List<Integer>) summarizer.collect(args[0]);
        String summarizedCollection = summarizer.summarizeCollection(collection);

        // print out result of computation
        System.out.println("Input String: " + args[0]);
        System.out.println("Summarised Collection: " + summarizedCollection);
    }

    /**
     * @param input: A String containing a comma delimited list of integers. Eg: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
     * @return: An ascending-order sorted List (Collection) of the Integer values contained in the input String. The output
     * list contains only one instance of each integer value in the input string, that is duplicate values are excluded.
     */
    public Collection<Integer> collect(String input) {
        try {
            String[] splitUpInputString = input.split(",");
            List<Integer> list = new ArrayList<>();

            // add array items to list (ensuring no duplicates)
            for (String element: splitUpInputString) {
                if (!element.equals("") && !list.contains(element)) {
                    list.add(Integer.parseInt(element));
                }
            }

            // sort the list of integers into ascending order
            Collections.sort(list);

            return list;

        } catch (NumberFormatException e) {
            System.out.println("The provided input string contains invalid characters," +
                    " please ensure the input file contains only the characters corresponding to numbers 0-9 and the comma character ','.");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
            System.exit(0);
        }
        return null;
    }


    /**
     * @param input: A Collection of Integers, assumed to be in ascending sorted order and to contain no duplicate values
     * @return: A string containing a comma delimited list of numbers, grouping the numbers into a range when they are sequential
     */
    public String summarizeCollection(Collection<Integer> input) {
        // return empty string if no integers in input string
        if (input == null || input.size() == 0) {
            return "";
        }

        //convert list to array
        Integer[] arrayInput = new Integer[input.size()];
        input.toArray(arrayInput);

        int prevValue = arrayInput[0];
        int rangeStartIndex = 0;
        String summarizedCollectionString = prevValue + "";
        for (int i = 1; i < arrayInput.length; i++) {
            if (arrayInput[i] == prevValue+1) {
                // if current value is in the range of the previous value
                if (i == arrayInput.length-1) {
                    // if is last in range
                    summarizedCollectionString += "-" + arrayInput[i];
                }
                prevValue++;
            } else if (arrayInput[i] > prevValue+1) {
                // if current value is not in the range of the previous value
                if (rangeStartIndex == i-1) {
                    // if previous range had just 1 element
                    summarizedCollectionString += ", " + arrayInput[i];
                    prevValue = arrayInput[i];
                    rangeStartIndex = i;
                } else {
                    // if previous range had more than 1 element
                    summarizedCollectionString += "-" + prevValue + ", " + arrayInput[i];
                    prevValue = arrayInput[i];
                    rangeStartIndex = i;
                }
            }
        }

        return summarizedCollectionString;
    }
}
