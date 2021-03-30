package design_pattern.singleton;

public class Singleton {
    private static volatile Singleton singleton;
    // 避免构造方法被访问 new Singleton()
    private Singleton() {}

    public static Singleton getInstance() {
        // two phase check
        if (singleton == null) {
            // class 级别的锁，保证只有一个对象可以进入临界区
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

// 利用内部类持有静态对象的方式
class Singleton2 {
    private Singleton2() {}

    public static Singleton2 getInstance() {
        return Holder.singleton;
    }

    private static class Holder {
        private static Singleton2 singleton = new Singleton2();
    }
}