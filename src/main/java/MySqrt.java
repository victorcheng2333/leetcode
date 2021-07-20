public class MySqrt {
    double sqrt(int x, int precision) {
        double left = 0, right = x;
        while(left <= right) {
            double mid = (left + right) / 2;
            if (Math.abs(mid * mid - x) <= Math.pow(10, 0-precision)) {
                return mid;
            } else if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return 0f;
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.println(new MySqrt().sqrt(a, 6));
    }
}
