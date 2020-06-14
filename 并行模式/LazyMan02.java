//本方式是对直接在方法上加锁的一个优化, 好处在于只有第一次初始化获取了锁.
//后续调用getInstance已经是无锁状态. 只是写法上稍微繁琐点.
private volatile Singleton singleton = null;
public static Singleton getInstance() {
    if (singleton == null) {
        synchronized (Singleton.class) {
            if (singleton == null) {
                singleton = new Singleton();
            }
        }
    }
    return singleton;
}
