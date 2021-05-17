package heap;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
  private Queue<Integer> minHeap = new PriorityQueue<>();
  private int k;

  // Time: O(n * log(k))
  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (int num : nums) add(num);
  }

  // Time: O(log(k))
  public int add(int val) {
    if (minHeap.size() < k) {
      minHeap.add(val);
    } else if (val > minHeap.peek()) {
      minHeap.poll();
      minHeap.add(val);
    }
    return minHeap.peek();
  }
}
