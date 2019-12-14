package Homework5_多线程;

import java.util.concurrent.Callable;

public class CalculateThread extends Thread/*implements Callable<Interger> */{

    private int min;
    private int max;
    private int sum;
    private boolean isPrime;
    private boolean isEnd;

    public boolean isEnd() {
        return isEnd;
    }

    public int getSum() {
        return sum;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public CalculateThread(int min, int max){
        this.min = min;
        this.max = max;
        isPrime = true;
        sum=0;
        isEnd = false;
    }

    @Override
    public void run() {
        for(int i=min; i<=max; i++){
            isPrime = true;
            for(int j=2; j<= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                sum++;
            }
        }
        isEnd = true;
    }

//    @Override
//    public Interger call() throws Exception {
//        return null;
//    }

    //    @Override
//    public Boolean call() throws Exception {
//        for(int i=2; i<= Math.sqrt(number); i++){
//            if(number % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
}
