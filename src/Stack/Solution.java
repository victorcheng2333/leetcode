package Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author victorcheng Created: 2020/2/17 15:40
 * 有效括号序列
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
class Solution {

  public boolean isValid(String s) {
    HashMap<Character, Character> marks = new HashMap<Character, Character>();
    marks.put(')', '(');
    marks.put('}', '{');
    marks.put(']', '[');
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i ++) {
      Character mark = s.charAt(i);
      // 左括号
      if (!marks.containsKey(mark)) {
        stack.push(mark);
      } else {
        // 右括号
        if (stack.isEmpty()) {
          return false;
        }
        Character top = stack.pop();
        System.out.println(marks.get(mark));
        if (!top.equals(marks.get(mark))) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s = "()";
    Solution solution = new Solution();
    System.out.println(solution.isValid(s));
  }
}
