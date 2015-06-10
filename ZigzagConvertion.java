public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0) {
            return "";
        }
        if (nRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j+=size) {
                res.append(s.charAt(j));
                if (i != nRows - 1 && i != 0) {
                    int temp = j + size - 2 * i;
                    if (temp < s.length()) {
                        res = res.append(s.charAt(temp));
                   }
                }
            }
        }
        return res.toString();
    }
}