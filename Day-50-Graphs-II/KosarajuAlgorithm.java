import java.util.*;

class Solution {

    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // First and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Build valid intervals
        for (int c = 0; c < 26; c++) {

            if (last[c] == -1) {
                continue;
            }

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            for (int i = left; i <= right && valid; i++) {

                int ch = s.charAt(i) - 'a';

                if (first[ch] < left) {
                    valid = false;
                    break;
                }

                right = Math.max(right, last[ch]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Sort by ending index
        intervals.sort((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        List<String> answer = new ArrayList<>();

        int end = -1;

        for (int[] interval : intervals) {

            if (interval[0] > end) {

                answer.add(s.substring(interval[0], interval[1] + 1));
                end = interval[1];
            }
        }

        return answer;
    }
}