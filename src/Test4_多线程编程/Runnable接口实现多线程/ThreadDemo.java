package Test4_多线程编程.Runnable接口实现多线程;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyThread("线程对象A")) ;
        Thread threadB = new Thread(new MyThread("线程对象B")) ;
        Thread threadC = new Thread(new MyThread("线程对象C")) ;
        threadA.start();          // 启动多线程
        threadB.start();          // 启动多线程
        threadC.start();          // 启动多线程
    }
}
