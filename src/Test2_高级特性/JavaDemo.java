package Test2_高级特性;

public class JavaDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IFood bread = Factory.getInstance("Test2_高级特性.Bread");
        IFood milk = Factory.getInstance("Test2_高级特性.Milk");
        bread.eat();
        milk.eat();
    }

}
