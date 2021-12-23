### Assumptions
- The input string contains only integer numbers (The user will be notified if unsupported characters are present)
- The input string contains only the characters 0, 1, 2, 3, 4, 5, 6, 7, 8, and 9 as well as the comma "," character
- The summarizeCollection method assumes ascending order sorted input, but collect method does not
- Duplicate values in the input are ignored by the summarizeCollection method, i.e. any duplicates are regarded as only one instance of the value

### NumberRangeSummarizer
This implementation uses the 'collect' method to return a duplicate-value containing sorted (ascending) collection of integers.
The summarizeCollection method is much more complicated here than for the NumberRangeSummarizerAlternative but since the interface 
did not specify whether this method can validly ignore duplicate values, this implementation was still included. 

### NumberRangeSummarizerAlternative
This implementation uses the 'collect' method to return a sorted (ascending) collection of all the integers in the input string where duplicate values are ignored.
The summarizeCollection method in this implementation is much simpler than the one in 'NumberRangeSummarizer' because duplicate values
are not included in the method's input collection. This is the better implementation of the two, because of its simplicity, but its validity 
would depend on whether the 'collect' method is allowed to return a collection with/without duplicate values. 
