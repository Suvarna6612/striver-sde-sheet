class TrieNode {
    TrieNode[] children;
    int prefixCount;
    int endCount;

    TrieNode() {
        children = new TrieNode[26];
        prefixCount = 0;
        endCount = 0;
    }
}

class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
            node.prefixCount++;
        }

        node.endCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[index];
        }

        return node.endCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                return 0;
            }

            node = node.children[index];
        }

        return node.prefixCount;
    }

    public void erase(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            TrieNode next = node.children[index];
            next.prefixCount--;
            node = next;
        }

        node.endCount--;
    }
}