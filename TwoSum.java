public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
                         return null;
                }
                HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
                for (int i = 0; i < nums.length; i++) {
                        hash.put(nums[i], i+1);
                }
                int[] result = new int[2];
                for (int i = 0; i < nums.length; i++) {
                        if (hash.containsKey(target - nums[i])) {
                                  int index1 = i + 1;
                                  int index2 = hash.get(target - nums[i]);
                                  if (index1 == index2) {
                                      continue;
                                  }
                                  result[0] = index1;
                                  result[1] = index2;
                                  return result;
                        }
                }
                return result;
    }
}