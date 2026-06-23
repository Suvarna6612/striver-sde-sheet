import java.util.*;

class Solution {

    static class Node {
        int value;
        int row;
        int col;

        Node(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public List<Integer> mergeKSortedArrays(int[][] arr, int k) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
        }

        while (!pq.isEmpty()) {

            Node curr = pq.poll();
            result.add(curr.value);

            int row = curr.row;
            int col = curr.col;

            if (col + 1 < arr[row].length) {
                pq.offer(new Node(arr[row][col + 1], row, col + 1));
            }
        }

        return result;
    }
}