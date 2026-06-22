import java.util.*;

class Solution {

    static class Node {
        int sum;
        int i;
        int j;

        Node(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public int[] maxSumCombinations(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> b.sum - a.sum);

        HashSet<String> visited = new HashSet<>();

        pq.offer(new Node(
                nums1[n - 1] + nums2[n - 1],
                n - 1,
                n - 1));

        visited.add((n - 1) + "#" + (n - 1));

        int[] ans = new int[k];
        int idx = 0;

        while (idx < k) {

            Node curr = pq.poll();

            ans[idx++] = curr.sum;

            int i = curr.i;
            int j = curr.j;

            if (i - 1 >= 0 &&
                !visited.contains((i - 1) + "#" + j)) {

                pq.offer(new Node(
                        nums1[i - 1] + nums2[j],
                        i - 1,
                        j));

                visited.add((i - 1) + "#" + j);
            }

            if (j - 1 >= 0 &&
                !visited.contains(i + "#" + (j - 1))) {

                pq.offer(new Node(
                        nums1[i] + nums2[j - 1],
                        i,
                        j - 1));

                visited.add(i + "#" + (j - 1));
            }
        }

        return ans;
    }
}