package Test4_多线程编程.Callable接口实现多线程;

import java.util.concurrent.FutureTask;

public class ThreadDemo {
    public static void main(String[] args) throws Exception {   // 将Callable实例包装在FutureTask类之中，这样可以就可以与Runnable接口关联
        FutureTask<String> task = new FutureTask<>(new MyThread());
        new Thread(task).start();       // 线程启动
         System.out.println("【线程返回数据】" + task.get()); // 获取返回结果
    }
}
