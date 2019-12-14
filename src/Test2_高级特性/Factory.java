package Test2_高级特性;

public class Factory {

    public static IFood getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        return (IFood) clazz.newInstance();
    }

}
