package string;

public class ReverseString {

  public static void main(String[] args) {
    char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
    ReverseString r = new ReverseString();
    r.reverseString(s);
    System.out.println(s);
  }

  public void reverseString(char[] s) {
    for (int i = 0; i < s.length / 2 ; i++) {
      int j = s.length - 1 - i;
      char temp = s[i];
      s[i] = s[j];
      s[j] = temp;
    }
  }
}
