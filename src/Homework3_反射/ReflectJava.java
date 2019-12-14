package Homework3_反射;

import java.lang.reflect.*;

public class ReflectJava {
    public static String PersonNmae="Homework3_反射.Person";

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        System.out.println(ClassToJava(PersonNmae));

    }


    public static String ClassToJava(String ClassNmae) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz=Class.forName(ClassNmae) ;

        StringBuilder javaContext=new StringBuilder();
        javaContext.append("public class "+clazz.getSimpleName()+" {\n");


        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields) {
            field.setAccessible(true);

            javaContext.append("    " + GetModifiers( field.getModifiers())+" "+field.getType().getSimpleName()+" "+field.getName()+";\n");
        }

        Method[] methods = clazz.getDeclaredMethods();
        for(Method method:methods) {
            method.setAccessible(true);
            javaContext.append("    " + GetModifiers( method.getModifiers())+" "+method.getReturnType().getSimpleName()+" "+method.getName()+"(");

            Class<?>[] parameterTypes = method.getParameterTypes();
            Parameter[] parameters = method.getParameters();
            for(int i=0;i<parameterTypes.length;i++) {
                String simpleName = parameterTypes[i].getSimpleName();
                javaContext.append(simpleName+" "+parameters[i].getName());
                if(i != parameterTypes.length-1) javaContext.append(",");
            }
            javaContext.append(")  {}\n");
        }

        Constructor[] constructors = clazz.getConstructors();

        for(Constructor constructor:constructors) {
            constructor.setAccessible(true);
            javaContext.append("    " + GetModifiers( constructor.getModifiers())+" "+constructor.getDeclaringClass().getSimpleName()+"(");

            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Parameter[] parameters = constructor.getParameters();

            for(int i=0;i<parameterTypes.length;i++) {
                String simpleName = parameterTypes[i].getSimpleName();
                javaContext.append(simpleName+" "+parameters[i].getName());
            }
            javaContext.append(")  {}\n");
        }

        javaContext.append("}");
        return javaContext.toString();
    }

    private static String GetModifiers(int modifiers) {
        if(modifiers== Modifier.PUBLIC) {
            return "public";
        }
        else if(modifiers==Modifier.PRIVATE) {
            return "private";
        }else if(modifiers==Modifier.PROTECTED) {
            return "protected";
        }
        return "default";
    }
}
