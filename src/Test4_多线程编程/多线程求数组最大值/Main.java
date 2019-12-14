package Test4_多线程编程.多线程求数组最大值;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] data = new int[16];
        System.out.println("请输入16位待排序的数(以空格分隔)，采用四线程排序");
        int[] maxChild = new int[4];
        List<FutureTask<Integer>> futureTaskList = new ArrayList<>();
        int j=0;
        int[] temp = new int[4];
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<16; i++){
            data[i] = scanner.nextInt();
        }
        for(int i=0; i<16; i++){
//            int x = scanner.nextInt();
//            data[i] = x;
            if((i+1)%4 !=0){
                temp[i%4] = data[i];
            }else{
                temp[3] = data[i];
//                for(int kk=0; kk<4; kk++)
//                    System.out.println(temp[kk]);
                FutureTask<Integer> task = new FutureTask<>(new MyThread(temp));
                futureTaskList.add(task);
                new Thread(task).start();
                maxChild[j++] = task.get();
//                System.out.println(maxChild[j-1]);
            }
        }
//        System.out.println(11);
        int max = Integer.MIN_VALUE;

        for(int i=0; i<4; i++){
//            maxChild[i] = futureTaskList.get(i).get();
            System.out.println("每个线程的最大值为：" + maxChild[i]);
            max = Math.max(max, maxChild[i]);
        }

//        for(int i=0; i<4; i++){
//            System.out.println(maxChild[i]);
//        }

        System.out.println("最大值为:"+max);

//        for(int i=0; i<16; i++){
//            System.out.println(data[i]);
//        }


    }

}
