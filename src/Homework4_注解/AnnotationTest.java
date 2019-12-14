package Homework4_注解;

public class AnnotationTest {

    public static void main(String[] args) {
        TableInfo tableInfo = new TableInfo();
        tableInfo.parse(People.class);
        System.out.println(tableInfo.toString());
        System.out.println(tableInfo.add());
        System.out.println(tableInfo.update());
        System.out.println(tableInfo.delete());
    }

}
