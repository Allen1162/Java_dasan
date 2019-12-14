package Homework1_HelloWorld;

public class Main {

    public static void main(String[] args) {
        HelloWorld1 helloWorld1 = new HelloWorld1("Hello WorldString3");

        System.out.println(helloWorld1.getHelloWorldString() +" private String helloWorldString = Hello WorldString1");
        System.out.println(HelloWorld1.helloWorldString2 + " public static String helloWorldString2 ");
        System.out.println(helloWorld1.getHelloWorldString3() + " private String helloWorldString3 构造函数传值");
        HelloWorld1.output1();
        HelloWorld1.outpupt1(1);
        HelloWorld1.output1("啦啦啦啦");
        helloWorld1.output2();
        helloWorld1.output3();
    }

}
