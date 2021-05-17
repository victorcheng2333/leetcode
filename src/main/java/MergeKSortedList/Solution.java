package MergeKSortedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author victorcheng Created: 2020/2/12 15:06
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    /**
     * https://leetcode.com/problems/merge-k-sorted-lists/
     * 思路：
     * 1、定义一个小顶堆，用于取出最小值，堆容量为 K
     * 2、首先一次将k个 链表向下遍历，放入堆中。
     * 3、堆顶元素出来时：- 将此节点放入结果链表中，记录是哪个链表的元素，取出此链表的下一个数据。继续循环，直到所有链表结束且堆全部取出
     */
    if(lists == null || lists.length == 0){
      return null;
    }
    ListNode result = null;
    ListNode current = null;
    MyCompare compare = new MyCompare();
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, compare);
    for(ListNode n : lists) {
      if (n != null) {
        minHeap.add(n);
      }
    }
    while (!minHeap.isEmpty()) {
      ListNode top = minHeap.poll();
      if (result == null) {
        result = top;
        current = top;
      } else {
        current.next = top;
        current = current.next;
      }
      if (top.next != null) {
        minHeap.add(top.next);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    n1.next = new ListNode(4);
    n1.next.next = new ListNode(5);

    ListNode n2 = new ListNode(1);
    n2.next = new ListNode(3);
    n2.next.next = new ListNode(4);

    ListNode n3 = new ListNode(2);
    n3.next = new ListNode(6);

    ListNode[] lists = new ListNode[] {n1, n2, n3};

    Solution solution = new Solution();
    ListNode result = solution.mergeKLists(lists);
    printListNode(result);
  }

  public static void printListNode(ListNode n) {
    while (n != null) {
      System.out.print(n.val);
      System.out.print("->");
      n = n.next;
    }
  }

}


class MyCompare implements Comparator<ListNode> {
  @Override
  public int compare(ListNode n1, ListNode n2) {
    return n1.val - n2.val;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
