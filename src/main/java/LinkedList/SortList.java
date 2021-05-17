package LinkedList;

// https://leetcode.com/problems/sort-list/
public class SortList {

  ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), p = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1 != null) {
      p.next = l1;
    }
    if (l2 != null) {
      p.next = l2;
    }
    return dummy.next;
  }

  // merge sort
  public ListNode sortList(ListNode head) {
    // 递归边界条件
    if (head == null || head.next == null) return head;

    // 一分为二，找到中间node，通过快慢指针的方式
    ListNode fast = head, slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode right = sortList(slow.next);
    slow.next = null; // 从中间切断左右两侧链表
    ListNode left = sortList(head);
    return mergeTwoSortedList(left, right);
  }
}
