package Homework5_多线程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int min,max;
        while(true){
            System.out.println("请输入要计算的素数的范围（用空格分隔，如 80 100）");
            Scanner scanner = new Scanner(System.in);
            String[] borderString;
            String input = scanner.nextLine();
            borderString = input.split(" ");
//            System.out.println(borderString[0]);
//            System.out.println(borderString[1]);
            if(borderString.length!=2){
                System.out.println("请只输入范围 即两个数字");
                continue;
            }
            min = Integer.valueOf(borderString[0]);
            max = Integer.valueOf(borderString[1]);
            min = min < max ? min : max;
            max = max > min ? max : min;
            break;
        }


        long startTime = System.currentTimeMillis();
        int count = 0;
        for(int i=min; i<=max; i++){
            boolean flag = true;
            for(int j=2; j<= Math.sqrt(i); j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("单线程用时:" + (endTime-startTime)*1.0/1000 + "s");

        System.out.println("用四线程处理");
        int middle = new Double(Math.ceil((min+max)*1.0/2)).intValue();
        int littleMiddle = new Double(Math.ceil((min+middle)*1.0)/2).intValue();
        int bigMiddle = new Double(Math.ceil((max+middle)*1.0)/2).intValue();
        System.out.println(littleMiddle);
        System.out.println(middle);
        System.out.println(bigMiddle);

        CalculateThread calculateThread1 = new CalculateThread(min, littleMiddle);
        CalculateThread calculateThread2 = new CalculateThread(littleMiddle+1, middle);
        CalculateThread calculateThread3 = new CalculateThread(middle+1,bigMiddle);
        CalculateThread calculateThread4 = new CalculateThread(bigMiddle+1, max);



        startTime = System.currentTimeMillis();
        calculateThread1.start();
        calculateThread2.start();
        calculateThread3.start();
        calculateThread4.start();
        calculateThread1.join();
        calculateThread2.join();
        calculateThread3.join();
        calculateThread4.join();
        //if(calculateThread1.isEnd() && calculateThread2.isEnd()) {
            count = 0;
            count += calculateThread1.getSum() + calculateThread2.getSum()+calculateThread3.getSum()+calculateThread4.getSum();
       // }


        endTime = System.currentTimeMillis();
        System.out.println(min + "~" + max + "范围内的素数个数：" + count);
        System.out.println("用时:" + (endTime-startTime)*1.0/1000 + "s");

//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        List<Future<Boolean>> futureList =new ArrayList<>();
//        int sum=0;
//        startTime = System.currentTimeMillis();
//        for(int i=min; i<=max ; i++){
//            CalculateThread calculateThread = new CalculateThread(i);
//            Future<Boolean> future = pool.submit(calculateThread);
//            futureList.add(future);
//        }
//
//        for(Future<Boolean> future : futureList){
//            if(future.get()){
//                sum++;
//            }
//        }
//
//        pool.shutdown();
//        endTime = System.currentTimeMillis();
//        System.out.println(min + "~" + max + "范围内的素数个数：" + sum);
//        System.out.println("用时:" + (endTime-startTime)/1000 + "s");

    }



}
