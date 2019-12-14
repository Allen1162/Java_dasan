package Homework3_反射;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class readProperties {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileReader fileReader = new FileReader("src/Homework3_反射/person.properties");
        properties.load(fileReader);
        fileReader.close();
        String name = properties.getProperty("name");
        String sex = properties.getProperty("sex");
        int age = Integer.valueOf(properties.getProperty("age"));
        String idNO = properties.getProperty("idNo");
        String isMerriedString = properties.getProperty("isMerried");
        boolean isMerried=false;
        if(isMerriedString.equals("true")) isMerried = true;

        Person newPerson = new Person();
        System.out.println(newPerson.toString());
        newPerson.setName(name);
        newPerson.setSex(sex);
        newPerson.setAge(age);
        newPerson.setIdNo(idNO);
        newPerson.setIsMerried(isMerried);

        System.out.println(newPerson.toString());
    }



}
