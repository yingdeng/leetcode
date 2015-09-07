/***

Largest Number Total 
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Thinking: Using comparator to compare strings
          a = 3, b = 30, 330 > 303 -> 330, 34, 5, 9
          a = 330, b = 34, 33034 < 34330 -> 34330, 5, 9
          a = 34330, b = 5, 343305 < 534330 -> 534330, 9
          a = 534330, b = 9, 5343309 < 9534330 -> 9534330 (output as String)

***/

public class Solution {
    public String largestNumber(int[] nums) {
        
    }
}