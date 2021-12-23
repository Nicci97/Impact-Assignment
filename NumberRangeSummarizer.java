package numberrangesummarizer;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizer implements NumberRangeSummarizerInterface {

    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizer();
        // assume integer input
        String input = "1,3,6,7,31,12,13,14,15,21,22,23,24,8,";
        // empty
        List<Integer> collection = (List<Integer>) summarizer.collect(input);
        String summarizedCollection = summarizer.summarizeCollection(collection);


        System.out.println("Printing summarized collection");
        System.out.println(summarizedCollection);

    }

    /**
     * @param input: A String containing integers where a comma is placed between each neighbouring integer, for example: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
     * @return: An ascending-order sorted List (Collection) of the Integer values contained in the input String
     */
    public Collection<Integer> collect(String input) {
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
    }


    /**
     * @param input: A Collection of Integers, assumed to be in ascending sorted order
     * @return: A string containing a comma delimited list of numbers, grouping the numbers into a range when they are sequential
     */
    public String summarizeCollection(Collection<Integer> input) {
        // return empty string if no integers in input string
        if (input.size() == 0) {
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
                if (arrayInput[i+1] != null && arrayInput[i+1] > currentStepInRange+1) {
                    summarizedCollectionString += "-" + currentStepInRange;
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
