/***
Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II

Special Case: n = 3, k = 4, k needs to mod

Thinking: (Example, n = [0, 1, 2, 3, 4, 5, 6], k = 3, output: 4 5 6 0 1 2 3)
1. Divide the array into to part base on the k: 0 1 2 3 4 5 6 -> 0 1 2 3, 4 5 6
2. Reverse the first part: 3 2 1 0 4 5 6
3. Reverse the second part: 3 2 1 0 6 5 4
4. Reverse the whole array: 4 5 6 0 1 2 3 
This solution is in O(1) space in O(n) time
***/

public void rotateArray(int[] n, int k) {
	if (n == null || k < 0) {
		return;
	}

	public void rotate(int[] nums, int k) {
    
        if (nums == null || k < 0) {
            return;
        }
        
        int len = nums.length;
        
        k = k % len;
        
        int aPart = len - k;
        
        reverse(nums, 0, aPart - 1);
        reverse(nums, aPart, len - 1);
        reverse(nums, 0, len - 1);
         
    }
    
    private void reverse(int[] nums, int left, int right) {
        if (nums == null || left < 0 || right < 0) {
            return;
        }
        
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
} 