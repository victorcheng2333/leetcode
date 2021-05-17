public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int dis = 0;
        while (x > 0 || y > 0) {
            var xLast = x & 1;
            var yLast = y & 1;
            if (xLast != yLast) dis ++;
            x = x >> 1;
            y = y >> 1;
        }
        return dis;
    }

    public static void main(String[] args) {
        var x = 4;
        var y = 4;
        System.out.println(new HammingDistance().hammingDistance(x, y));
    }
}
