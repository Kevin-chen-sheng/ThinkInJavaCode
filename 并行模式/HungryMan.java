//缺点在于对象在一开始就直接初始化了.
public class Singleton1 {
    private Singleton1() {}
    private static final Singleton1 single = new Singleton1();
    public static Singleton1 getInstance() {
        return single;
    }
}
