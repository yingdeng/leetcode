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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        if(intervals.size() <= 0 || intervals == null){
            return intervals;
        }
        
        ArrayList<Interval> results = new ArrayList<Interval>();
        
        Collections.sort(intervals, new compareIntervals());
        
        Interval last = intervals.get(0);
        
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start <= last.end){
                last.end = Math.max(last.end, curr.end);
            }
            else{
                results.add(last);
                last = curr;
            }
        }
        results.add(last);
        return results;
    }
    
    private class compareIntervals implements Comparator<Interval>{
            
            public int compare(Interval a, Interval b){
                if(a.start == b.start){
                    return a.end - b.end;
                }
                else{
                    return a.start - b.start;
                }
            }
    }

}