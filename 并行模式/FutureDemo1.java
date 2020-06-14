//通过FutureTask实现
//注意其中两个耗时操作.
//如果doOtherThing耗时2s, 则整个函数耗时2s左右.
//如果doOtherThing耗时0.2s, 则整个函数耗时取决于RealData.costTime, 即1s左右结束.
public class FutureDemo1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return new RealData().costTime();
            }
        });
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(future);

        System.out.println("RealData方法调用完毕");
        // 模拟主函数中其他耗时操作
        doOtherThing();
        // 获取RealData方法的结果
        System.out.println(future.get());
    }

    private static void doOtherThing() throws InterruptedException {
        Thread.sleep(2000L);
    }
}

class RealData {

    public String costTime() {
        try {
            // 模拟RealData耗时操作
            Thread.sleep(1000L);
            return "result";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "exception";
    }

}
