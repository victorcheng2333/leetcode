package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequent {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (Integer num : nums) {
      Integer freq = freqMap.getOrDefault(num, 0);
      freqMap.put(num, freq + 1);
    }
    Queue<Map.Entry<Integer, Integer>> pq =
        new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());
    for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
      pq.add(e);
      if (pq.size() > k) pq.poll();
    }
    int[] result = new int[k];
    int i = 0;
    for (Map.Entry<Integer, Integer> e : pq) {
      result[i] = e.getKey();
      i++;
    }
    return result;
  }
}
