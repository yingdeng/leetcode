public class Solution {
    public int lengthOfLongestSubstring(String s) {
     if (s == null || s.length()== 0) {
         return 0;
     }     
     char[] arr = s.toCharArray();
     int max = 0;
     int left = 0;
     HashSet<Character> set = new HashSet<>();
     int i;
     for (i = 0; i < arr.length; i++) {
          if (set.contains(arr[i])) {
              while (left < i && arr[i] != arr[left]) {
                        set.remove(arr[left]);
                        left++;
              }
              left++;
          }
         else {
              set.add(arr[i]);
              max = Math.max(max, i-left+1);
         }
     }
     //max = Math.max(max, i - left);
     return max;
    }
}