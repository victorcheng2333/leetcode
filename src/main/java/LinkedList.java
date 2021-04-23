import java.util.HashMap;

public class LinkedList {
  public boolean hasCycle(ListNode head) {
    HashMap<ListNode, Integer> map = new HashMap();
    ListNode current = head;
    Integer pos = new Integer(0);
    while (current != null) {
      if (map.containsKey(current)) {
        System.out.println(map.get(current));
        return true;
      }
      map.put(current, pos);
      current = current.next;
      pos ++;
    }
    return false;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    ListNode head = new ListNode(3);
    head.next = new ListNode(2);
    head.next.next = new ListNode(0);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = head.next;
    boolean hasCycle = list.hasCycle(head);
    System.out.println("has cycle:" + hasCycle);
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
