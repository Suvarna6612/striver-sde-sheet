import java.util.*;

class Solution {
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;

        int[][] meetings = new int[n][3];

        for(int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
            meetings[i][2] = i;
        }

        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 1;
        int lastEnd = meetings[0][1];

        for(int i = 1; i < n; i++) {
            if(meetings[i][0] > lastEnd) {
                count++;
                lastEnd = meetings[i][1];
            }
        }

        return count;
    }
}