import java.util.*;

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {

    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(int num) {

        Node node = root;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    public int getMax(int num) {

        Node node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (node.containsKey(1 - bit)) {

                maxXor |= (1 << i);
                node = node.get(1 - bit);

            } else {

                node = node.get(bit);
            }
        }

        return maxXor;
    }
}

class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int q = queries.length;

        int[][] offlineQueries = new int[q][3];

        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][1];
            offlineQueries[i][1] = queries[i][0];
            offlineQueries[i][2] = i;
        }

        Arrays.sort(offlineQueries, (a, b) -> Integer.compare(a[0], b[0]));

        Trie trie = new Trie();

        int[] ans = new int[q];

        int index = 0;

        for (int[] query : offlineQueries) {

            int m = query[0];
            int x = query[1];
            int originalIndex = query[2];

            while (index < nums.length && nums[index] <= m) {
                trie.insert(nums[index]);
                index++;
            }

            if (index == 0) {
                ans[originalIndex] = -1;
            } else {
                ans[originalIndex] = trie.getMax(x);
            }
        }

        return ans;
    }
}