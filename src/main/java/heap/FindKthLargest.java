package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {
  public int findKthLargest(int[] nums, int k) {
    Queue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
      if (minHeap.size() < k) {
        minHeap.add(num);
      } else if (num > minHeap.peek()) {
        minHeap.poll();
        minHeap.add(num);
      }
    }
    return minHeap.peek();
  }
}
