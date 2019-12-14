package Homework3_反射;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

public class writeToFile {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        String fileName = "src/Homework3_反射/person.properties";
        File file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
        }else{
            file.delete();
            file.createNewFile();
        }
        Person person = new Person();
        person.setIdNo("5122245566");
        person.setName("张小平");
        person.setAge(23);
        person.setSex("Male");
        person.setIsMerried(true);

        Class clazz = person.getClass();
//        Field idField = clazz.getDeclaredField("idNo");
//        Field nameField= clazz.getDeclaredField("name");
//        Field ageField = clazz.getDeclaredField("age");
//        Field sexField = clazz.getDeclaredField("sex");
//        Field isMerriedField = clazz.getDeclaredField("isMerried");
//
//        idField.setAccessible(true);
//        System.out.println(idField.getName() + idField.get(person));
        Field[] fields = clazz.getDeclaredFields();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for(Field field : fields){
            field.setAccessible(true);
            System.out.println(field.getName() + ":" + field.get(person));
            fileOutputStream.write((field.getName() + "=" + field.get(person) + "\n").getBytes());
            field.setAccessible(false);
        }
        fileOutputStream.close();
    }



}
