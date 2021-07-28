import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class MergeKSortedArray {
    static int[][] testInput1 = new int[][]
            {{1,1,2,5,7,8},
                    {3,5,9,12},
                    {1},
                    {4,4,4,4,7}};

    public static void main(String[] args) {
        int[] output1 = sort(testInput1);
        IntStream.of(output1).forEach(i -> System.out.print(i + ","));
    }

    public static int[] sort(int[][] input) {
        if (input == null) return new int[0];
        Queue<Elem> heap = new PriorityQueue<Elem>(input.length, (a, b) -> a.val - b.val);
        int allElemCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != null && input[i].length > 0) {
                Elem e = new Elem(i, 0, input[i][0]);
                heap.add(e);
                allElemCount += input[i].length;
            }
        }
        int[] result = new int[allElemCount];
        int index = 0;
        while (!heap.isEmpty()) {
            Elem e = heap.poll();
            result[index] = e.val;
            index++;
            if (e.col+1 < input[e.row].length) {
                heap.add(new Elem(e.row, e.col+1, input[e.row][e.col+1]));
            }
        }
        return result;
    }

}

class Elem {
    public int row, col, val;
    public Elem(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}