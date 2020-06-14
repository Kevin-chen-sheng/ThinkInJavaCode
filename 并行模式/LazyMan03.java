//该方式既解决了同步问题, 也解决了写法繁琐问题. 推荐使用改写法.
public class Singleton {
    private static class LazyHolder {
       private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
       return LazyHolder.INSTANCE;
    }
}
