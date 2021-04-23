package sort;

import java.util.Arrays;

/**
 * @author victorcheng Created: 2020/2/21 14:29
 */
public class Sort {
  public static void main(String[] args) {
    int[] nums = new int[] {4, 5, 6, 3, 2, 1};
    System.out.println(Arrays.toString(nums));
    new Sort().insertSort(nums);
    System.out.println(Arrays.toString(nums));
  }

  private void insertSort(int[] a) {
    int n = a.length;
    if (n <= 1) return;
    for (int i = 1; i < n; i++) {
      int value = a[i];
      int j = i - 1;
      for (; j >= 0; j --) {
        if (a[j] > value) {
          a[j + 1] = a[j];
        } else {
          break;
        }
      }
      // insert value
      a[j + 1] = value;
    }
  }

  private void bubbleSort(int[] a) {
    int n = a.length;
    if (n < 2) return;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        // compare neighbor and exchange
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }
  }
}
