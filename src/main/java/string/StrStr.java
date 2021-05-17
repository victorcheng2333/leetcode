package string;

// https://leetcode.com/problems/implement-strstr/
public class StrStr {
  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    int n = haystack.length(), m = needle.length();
    for (int i = 0; i <= n - m; i++) {
      int j = 0, k = i;
      for (; j < m && k < n && needle.charAt(j) == haystack.charAt(k); ++j, ++k);
      if (j == m) return i;
    }
    return -1;
  }
}
