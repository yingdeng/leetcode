public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<>();
        if (strs.length == 0 || strs == null) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // Sort the string;
            char[] charStr = strs[i].toCharArray();
            Arrays.sort(charStr);
            String tempStr = new String(charStr);
            
           // determine whether the string in the map or not;
           if (!map.containsKey(tempStr)) {
               map.put(tempStr, i);
           }
           else {
               if (map.get(tempStr) >= 0) {
                   res.add(strs[map.get(tempStr)]);
                   map.put(tempStr, -1);
               }
               //res.add(strs[i]);
           }
        }
        return res;
    }
}