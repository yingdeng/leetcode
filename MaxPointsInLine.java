/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Float, Integer> map = new HashMap<>();
            int numOfSame = 0;
            int localMax = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    numOfSame++;
                    continue;
                }
                float ratio = ((float)(points[i].y - points[j].y))/(points[i].x - points[j].x);
                if (map.containsKey(ratio)) {
                    map.put(ratio, map.get(ratio) + 1);
                }
                else {
                    map.put(ratio, 2);
                }
            }
            for (Integer value: map.values()) {
                    localMax = Math.max(localMax, value);
                }
                localMax += numOfSame;
                max = Math.max(max, localMax);
        }
        return max;
    }
}