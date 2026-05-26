/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if(n==0)return true;
        Collections.sort(intervals, (a,b) -> {
            if(a.start == b.start)return a.end - b.end;
            return a.start - b.start;
        });
        Interval inter = intervals.get(0);
        for(int i=1;i<n;i++){
            if(inter.end > intervals.get(i).start)return false;
            inter = intervals.get(i);
        }
        return true;
    }
}
