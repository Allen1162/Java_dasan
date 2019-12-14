package Test4_多线程编程.并发资源访问;

public class MyThread implements Runnable {
    private int ticket = 5;      // 定义总票数

    @Override
    public void run() {        // 线程的主体方法
        for (int x = 0; x < 100; x++) {   // 进行100次的卖票处理
            if (this.ticket > 0) {    // 有剩余票
                System.out.println("卖票，ticket = " + this.ticket--);
            }
        }
    }
}
