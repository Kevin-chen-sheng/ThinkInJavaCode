//生产者核心代码
while(isRunning) {
    Thread.sleep(r.nextInt(SLEEP_TIME));
    data = new PCData(count.incrementAndGet);
    // 构造任务数据
    System.out.println(data + " is put into queue");
    if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
        // 将数据放入队列缓冲区中
        System.out.println("faild to put data : " + data);
    }
}
//消费者核心代码
while (true) {
    PCData data = queue.take();
    // 提取任务
    if (data != null) {
        // 获取数据, 执行计算操作
        int re = data.getData() * 10;
        System.out.println("after cal, value is : " + re);
        Thread.sleep(r.nextInt(SLEEP_TIME));
    }
}
