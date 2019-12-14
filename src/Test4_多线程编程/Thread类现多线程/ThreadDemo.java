package Test4_多线程编程.Thread类现多线程;

public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread("线程A").start();   // 实例化线程对象并启动
        new MyThread("线程B").start();   // 实例化线程对象并启动
        new MyThread("线程C").start();   // 实例化线程对象并启动
    }
}
