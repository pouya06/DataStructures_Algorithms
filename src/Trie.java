import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            Character currentChar = word.charAt(i);

            TrieNode exsistingOrCurrentNode;
            if (children.containsKey(currentChar)) {
                // get it and operates
                exsistingOrCurrentNode = children.get(currentChar);
            } else {
                // insert new one
                exsistingOrCurrentNode = new TrieNode(currentChar);
                children.put(currentChar, exsistingOrCurrentNode);
            }

            children = exsistingOrCurrentNode.children;

            if (word.length() - 1 == i) {
                exsistingOrCurrentNode.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        Map<Character, TrieNode> children = root.children;

        TrieNode t = null;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);

            if (children.containsKey(character)) {
                t = children.get(character);
                children = t.children;
            } else {
                return false;
            }
        }

        return t != null && t.isLeaf;
    }

    private static class TrieNode {
        Character data;
        Map<Character, TrieNode> children = new HashMap<>();
        Boolean isLeaf;

        public TrieNode() {

        }

        public TrieNode(Character data) {
            this.data = data;
        }
    }
}
