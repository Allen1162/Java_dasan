package Test4_多线程编程.Callable接口实现多线程;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {   // 线程执行方法
        for (int x = 0; x < 10; x++) {
            System.out.println("********* 线程执行、x = " + x);
        }
        return "www.mldn.cn";       // 返回结果
    }
}
