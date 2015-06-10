/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        if(intervals == null || newInterval == null){
            return intervals;
        }
        
        ArrayList<Interval> results = new ArrayList<Interval>();
        int insertPos = 0;
        
        for(Interval interval: intervals){
            if(newInterval.end < interval.start){
                results.add(interval);
            }
            else if(interval.end < newInterval.start){
                results.add(interval);
                insertPos++;
            }
            else{
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        results.add(insertPos, newInterval);
        return results;
    }
}