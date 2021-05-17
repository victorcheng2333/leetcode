package tree;

public class Trie {

  private class TrieNode {
    TrieNode[] children;
    boolean endOfWord;
    TrieNode() {
      this.children = new TrieNode[26];
      this.endOfWord = false;
    }
  }

  private TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    this.root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode cur = root;
    for (int i = 0; i < word.length(); i++) {
      int idx = word.charAt(i) - 'a';
      if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
      cur = cur.children[idx];
    }
    cur.endOfWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode endNode = findEndNode(word);
    return endNode != null && endNode.endOfWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode endNode = findEndNode(prefix);
    return endNode != null;
  }

  private TrieNode findEndNode(String str) {
    TrieNode cur = root;
    for (int i = 0; cur != null && i < str.length(); i++) {
      int idx = str.charAt(i) - 'a';
      cur = cur.children[idx];
    }
    return cur;
  }
}
