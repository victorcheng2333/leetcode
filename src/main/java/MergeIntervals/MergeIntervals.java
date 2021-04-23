package MergeIntervals;

import java.util.Arrays;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    int[][] result = new int[intervals.length][2];
    int size = 0;
    // 按区间开始下标排序
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    for (int[] in : intervals) {
      if (size == 0 || in[0] > result[size-1][1]) {
        result[size][0] = in[0];
        result[size][1] = in[1];
        ++size;
      } else {
        result[size-1][1] = Math.max(result[size-1][1], in[1]);
      }
    }

    return Arrays.copyOf(result, size);
  }
}
