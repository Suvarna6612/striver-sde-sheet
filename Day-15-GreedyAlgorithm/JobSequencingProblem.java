import java.util.*;

class Solution {
    public int[] JobScheduling(int[][] Jobs) {

        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        int maxDeadline = 0;

        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        int[] slots = new int[maxDeadline + 1];
        Arrays.fill(slots, -1);

        int jobsDone = 0;
        int maxProfit = 0;

        for (int[] job : Jobs) {

            int deadline = job[1];
            int profit = job[2];

            for (int j = deadline; j > 0; j--) {

                if (slots[j] == -1) {
                    slots[j] = job[0];
                    jobsDone++;
                    maxProfit += profit;
                    break;
                }
            }
        }

        return new int[]{jobsDone, maxProfit};
    }
}