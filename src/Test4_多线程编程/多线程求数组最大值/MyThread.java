package Test4_多线程编程.多线程求数组最大值;

        import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {

    private int[] data;

    public MyThread(int[] data){
        this.data = data;
    }

    @Override
    public Integer call() throws Exception {
        int length = data.length;
        if(length==0) return -11111;
        int max = data[0];
        for(int i=1; i<length; i++){
            max = Math.max(max, data[i]);
        }
//        System.out.println(max);
        return max;
    }
}
