package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A class that takes as command line input a String containing a comma separated list of integer numbers and prints out a string
 * containing a comma delimited list of numbers, grouping the numbers into a range when they are sequential
 * Note: This implementation handles duplicate input values in the summarizeCollection method
 */
public class NumberRangeSummarizer implements NumberRangeSummarizerInterface {

    public static void main(String[] args) {
        // initialise NumberRangeSummarizer
        NumberRangeSummarizer summarizer = new NumberRangeSummarizer();

        // create collection from command line input (args[0])
        List<Integer> collection = (List<Integer>) summarizer.collect(args[0]);
        String summarizedCollection = summarizer.summarizeCollection(collection);

        // print out result of computation
        System.out.println("Input String: " + args[0]);
        System.out.println("Summarised Collection: " + summarizedCollection);
    }

    /**
     * @param input: A String containing a comma delimited list of integers. Eg: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
     * @return: An ascending-order sorted List (Collection) of the Integer values contained in the input String
     */
    public Collection<Integer> collect(String input) {
        try {
            String[] splitUpInputString = input.split(",");
            List<Integer> list = new ArrayList<>();

            // add array items to list
            for (String element: splitUpInputString) {
                if (!element.equals("")) {
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
     * @param input: A Collection of Integers, assumed to be in ascending sorted order
     * @return: A string containing a comma delimited list of numbers, grouping the numbers into a range when they are sequential
     * Duplicate values in the input are ignored by the summarizeCollection method, i.e. any duplicates are regarded as only one instance of the value
     *
     */
    public String summarizeCollection(Collection<Integer> input) {
        // return empty string if no integers in input string
        if (input == null || input.size() == 0) {
            return "";
        }

        //convert list to array
        Integer[] arrayInput = new Integer[input.size()];
        input.toArray(arrayInput);

        // populate summarized string with integers and ranges
        int startOfRange = arrayInput[0];
        int currentStepInRange = startOfRange;
        String summarizedCollectionString = startOfRange + "";
        for (int i = 1; i < arrayInput.length; i++) {
            // ignore duplicate values
            if (arrayInput[i] == currentStepInRange) {
                continue;
            }

            if (arrayInput[i] == currentStepInRange + 1) {
                // if a part of a range
                currentStepInRange += 1;
                int indexNextUniqueVal = 0;
                while (arrayInput[i+indexNextUniqueVal] == currentStepInRange && indexNextUniqueVal+i+1 < arrayInput.length) {
                    indexNextUniqueVal++;
                }

                if (arrayInput[i+indexNextUniqueVal] > currentStepInRange+1) {
                    // if next different element is not part of current range
                    summarizedCollectionString += "-" + currentStepInRange;
                } else if (arrayInput[i+indexNextUniqueVal] == currentStepInRange) {
                    // if next different element is part of current range and is the last element
                    int finalIndexForNextValueInSequence = i+indexNextUniqueVal;
                    while (finalIndexForNextValueInSequence < arrayInput.length-1) {
                        if (arrayInput[finalIndexForNextValueInSequence+1] == currentStepInRange) {
                            finalIndexForNextValueInSequence++;
                        } else {
                            break;
                        }
                    }
                    if (finalIndexForNextValueInSequence == arrayInput.length-1) {
                        summarizedCollectionString += "-" + (currentStepInRange);
                    }
                }
            } else {
                // if not a part of a range
                summarizedCollectionString += ", " + arrayInput[i];
                currentStepInRange = arrayInput[i];
            }
        }

        return summarizedCollectionString;
    }
}
