package Homework1_HelloWorld;

public interface HelloWorld2 {
    public void output2();
    public default void output3(){
        System.out.println("Hello World 3" + "接口默认实现");
    }
}
