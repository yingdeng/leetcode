/***
Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeros in n!.

Note, Your solution should be in logarithmic time complexity.

Example: 11 ! = 39916800, output: 2
11! = 11*10*9*8*7*6*5*4*3*2*1
10*5*2 = 100, so there is 2 zeroes in the result

Challenge: O(log N) time
***/

public int trailingZeroes(int n) {
	if (n < 0) {
		reuturn 0;
	}
    
    int count = 0;
    for (; n > 0; n /= 5) {
        count += n / 5;
    }

    return count;
}