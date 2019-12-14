package Homework1_HelloWorld;

public class HelloWorld1 implements HelloWorld2 {

    private String helloWorldString = "Hello WorldString1";
    public static String helloWorldString2 = "Hello WorldString2";
    private String helloWorldString3;

    public HelloWorld1(String helloWorldString3) {
        this.helloWorldString3 = helloWorldString3;
    }

    public String getHelloWorldString3() {
        return helloWorldString3;
    }

    public String getHelloWorldString() {
        return helloWorldString;
    }

    public static void output1(){
        System.out.println("Hello World 1" + " outpupt1()");
    }

    public static void outpupt1(int i){  //4
        System.out.println("Hello World" + "重载outpupt1(int" + i + ")");
    }

    public static void output1(String s){  //5
        System.out.println("Hello World" + "重载outpupt1(String" + s + ")");
    }

    @Override
    public void output2() {
        System.out.println("Hello World 2" +"实现接口");
    }
}
