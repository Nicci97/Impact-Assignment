package numberrangesummarizer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizer implements NumberRangeSummarizerInterface {

    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizer();
//        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String input = "1,3,6,7,31,12,13,14,15,21,22,23,24,8,";
        // add test case for String input = "1,3,6,7,31,12,13,14,15,21,22,23,24,8,";
        List<Integer> collection = (List<Integer>) summarizer.collect(input);

        for (Integer x: collection) {
            System.out.println(x);
        }

    }

    /**
     * @param input: A String containing integers where a comma is placed between each neighbouring integer, for example: "1,3,6,7,8,12,13,14,15,21,22,23,24,31"
     * @return An ascending-order sorted List (Collection) of the Integer values contained in the input String
     */
    public Collection<Integer> collect(String input) {
        String[] splitUpInputString = input.split(",");
        List<Integer> list = new ArrayList<>();

        // add array items to list
        for (String element: splitUpInputString)
            list.add(Integer.parseInt(element));

        // sort the list of integers into ascending order
        Collections.sort(list);

        return list;
    }


    public String summarizeCollection(Collection<Integer> input) {
        return null;
    }
}
