
import java.util.List;

class Node {

    Node[] links = new Node[26];
    boolean isEnd;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        isEnd = true;
    }

    boolean isEnd() {
        return isEnd;
    }
}

class Trie {

    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }

            node = node.get(ch);
        }

        node.setEnd();
    }

    public boolean checkIfAllPrefixExists(String word) {

        Node node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            node = node.get(ch);

            if (node == null || !node.isEnd()) {
                return false;
            }
        }

        return true;
    }
}

class Solution {

    public String completeString(List<String> nums) {

        Trie trie = new Trie();

        for (String word : nums) {
            trie.insert(word);
        }

        String ans = "";

        for (String word : nums) {

            if (trie.checkIfAllPrefixExists(word)) {

                if (word.length() > ans.length()) {
                    ans = word;
                } else if (word.length() == ans.length()
                        && word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }

        return ans.equals("") ? "None" : ans;
    }
}