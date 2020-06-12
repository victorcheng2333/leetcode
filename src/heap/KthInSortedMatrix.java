package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthInSortedMatrix {

  class Elem implements Comparable<Elem> {
    int row, col, val;

    Elem(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }

    @Override
    public int compareTo(Elem o) {
      return this.val - o.val;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int m = matrix.length, n = matrix[0].length;
    // 构造一个小顶堆
    Queue<Elem> minHeap = new PriorityQueue<>();
    for (int i = 0 ; i < m; i++) {
      minHeap.add(new Elem(i, 0, matrix[i][0]));
    }
    for (int i = 0; i < k - 1; i++) {
      Elem elem = minHeap.poll();
      ++elem.col;
      if (elem.col < n) {
        elem.val = matrix[elem.row][elem.col];
        minHeap.add(elem);
      }
    }
    return minHeap.poll().val;
  }
}
