public class Solution {
    public int majorityElement(int[] num) {
        int mostEle = num[0];
        int counter = 1;
        
        for (int i = 1; i < num.length; i++) {
            if (mostEle == num[i]) {
                counter++;
            }
            else {
                if (counter == 0) {
                    mostEle = num[i];
                    counter++;
                }
                else {
                    counter--;
                }
            }
        }
        return mostEle;
    }
}