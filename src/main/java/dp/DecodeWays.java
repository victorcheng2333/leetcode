package dp;

public class DecodeWays {

  public int numDecodings(String s) {
    int [] d = new int[s.length() + 1];
    d[0] = 1;
    d[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= s.length(); i ++) {
      if (s.charAt(i - 1) != '0') d[i] += d[i - 1];
      if (isValidTwoDigit(s.charAt(i - 2), s.charAt(i - 1))) d[i] += d[i - 2];
    }
    return d[s.length()];
  }

  public boolean isValidTwoDigit(char a, char b) {
    return (a == '1' && b <= '9') || (a == '2' && b <= '6');
  }

  public int decode(char[] c, int i) {
    if (i == c.length) return 1;
    if (i > c.length) return 0;
    int num = 0;
    if (c[i] != '0') num += decode(c, i + 1);
    if (i + 1 < c.length && isValidTwoDigit(c[i], c[i + 1])) num += decode(c, i + 2);
    return num;
  }

  public int decodeRecursive(String s) {
    return decode(s.toCharArray(), 0);
  }
}
