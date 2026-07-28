class Node {

    Node[] links = new Node[26];

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
}

class Solution {

    public int countDistinctSubstring(String s) {

        Node root = new Node();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            Node node = root;

            for (int j = i; j < s.length(); j++) {

                char ch = s.charAt(j);

                if (!node.containsKey(ch)) {

                    node.put(ch, new Node());

                    count++;
                }

                node = node.get(ch);
            }
        }

        return count + 1;
    }
}