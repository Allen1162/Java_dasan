package Test4_多线程编程.Runnable接口实现多线程;

public class MyThread implements Runnable {
    private String title;       // 成员属性

    public MyThread(String title) {    // 属性初始化
        this.title = title;
    }

    @Override
    public void run() {        // 【方法覆写】线程方法
        for (int x = 0; x < 10; x++) {
            System.out.println(this.title + "运行，x = " + x);
        }
    }
}
