package LinkedList;

public class RemoveNthNode {
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy, q = dummy;

    // q 先移动 n step
    for(; n > 0 && q.next != null ; --n) q = q.next;
    if (n != 0) return dummy.next;

    while (q.next != null) {
      p = p.next;
      q = q.next;
    }
    // remove node p
    p.next = p.next.next;
    return dummy.next;
  }
}
