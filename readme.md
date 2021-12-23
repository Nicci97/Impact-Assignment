### Assumptions
- The input string contains only integer numbers (The user will be notified if unsupported characters are present)
- The input string contains only the characters 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9 as well as the comma "," character
- The summarizeCollection method assumes ascending order sorted input, but collect method does not
- For NumberRangeSummarizer.java: duplicate values in the input are ignored by the summarizeCollection method
- For NumberRangeSummarizerAlternative.java: duplicate values in the input are ignored by the collect method

### NumberRangeSummarizer.java
This implementation uses the 'collect' method to return a duplicate-value containing sorted (ascending) collection of integers. 
The summarizeCollection method takes as input a duplicate-value containing collection of integers and ignores the duplicate values
during the process of collection summarization.

The summarizeCollection method is much more complicated here than for the NumberRangeSummarizerAlternative. This implementation was included 
in the submission because the interface did not specify whether this method is allowed to ignore duplicate values.

### NumberRangeSummarizerAlternative.java
This implementation uses the 'collect' method to return a sorted (ascending) collection of all the integers in the input string where 
duplicate values are ignored.

The summarizeCollection method in this implementation is much simpler than the one in 'NumberRangeSummarizer' because duplicate values
are not included in computation for collection summarization. This is the better implementation of the two, because of its simplicity, 
but its validity would depend on whether the 'collect' method is allowed to return a collection without duplicate values. 
