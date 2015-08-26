/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
<<<<<<< HEAD
For example,
Given n = 3, there are a total of 5 unique BST's.
=======

For example,
Given n = 3, there are a total of 5 unique BST's.

>>>>>>> c82b2decd465a6c9af48d90d8d57606a4456d950
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

<<<<<<< HEAD

=======
>>>>>>> c82b2decd465a6c9af48d90d8d57606a4456d950
public class Solution {
    public int numTrees(int n) {
        if(n < 0){
            return 0;
        }
        int[] count = new int[n + 2];
        count[0] = 1;
        count[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
