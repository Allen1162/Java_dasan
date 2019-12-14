package Test4_多线程编程.并发资源访问;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();    // 定义资源对象
         new Thread(mt).start();      // 第一个线程启动
         new Thread(mt).start();      // 第二个线程启动
         new Thread(mt).start();      // 第三个线程启动
    }
}
