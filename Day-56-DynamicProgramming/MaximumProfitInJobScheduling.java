import java.util.*;

class Solution {

    class Job {
        int start;
        int end;
        int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.start - b.start);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, jobs, dp);
    }

    private int solve(int index, Job[] jobs, int[] dp) {

        if (index >= jobs.length)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int notTake = solve(index + 1, jobs, dp);

        int nextIndex = findNextJob(jobs, jobs[index].end);

        int take = jobs[index].profit + solve(nextIndex, jobs, dp);

        return dp[index] = Math.max(take, notTake);
    }

    private int findNextJob(Job[] jobs, int targetEnd) {

        int low = 0;
        int high = jobs.length - 1;
        int ans = jobs.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (jobs[mid].start >= targetEnd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}