package Test1.operations;

import Test1.javaBean.Student;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Crud {

    private static List<Student> listStu;
    private static Map<String, String> mapStu;

    public Crud(List<Student> listStu, Map<String,String> mapStu) {
        this.listStu = listStu;
        this.mapStu = mapStu;
    }

    public static boolean addStu(Student student){
        boolean isSuccess = false;

        listStu.add(student);
        mapStu.put(student.getName(),student.getPhoneNumber());
        isSuccess = true;

        return isSuccess;
    }

    public static boolean delStu(String id){
        boolean isSuccess = false;
        int index;
        if((index=findStuById(id))!=-1){
            Student student = listStu.get(index);
            listStu.remove(index);
            mapStu.remove(student.getName());
            isSuccess = true;
        }
        return isSuccess;
    }

    public static int findStuById(String id){
        for(int index=0; index<listStu.size(); index++){
            if(listStu.get(index).getId().equals(id)){
//                return listStu.get(index);
                return index;
            }
//                return null;
        }
        return -1;
    }

    public static boolean findAllStu(){
        boolean isSuccess = false;
        int index;
        for(index =0; index<listStu.size(); index++){
            System.out.println(listStu.get(index).toString());
        }
        if(listStu.size() > 0)
        isSuccess = true;
        return isSuccess;
    }

    public static boolean updateStu(String id){
        boolean isSuccess = false;

        int index = findStuById(id);
        if(index == -1){
            System.out.println("无该学生记录，退出修改操作");
            return isSuccess;
        }
        Student student = listStu.get(index);
        System.out.println(student);
        System.out.println("修改名字？1代表是，0代表否");
        Scanner input = new Scanner(System.in);
        int flag = input.nextInt();
        if(flag == 1){
            System.out.println("请输入新名字：");
            String newName = input.next();
            String oldName = student.getName();
            student.setName(newName);
            String phoneNumber = mapStu.get(oldName);
            mapStu.remove(oldName);
            mapStu.put(newName, phoneNumber);
            isSuccess = true;
        }else{
        }
        return isSuccess;
    }

    public static String findPhoneNumberByName(String name){
        for(Map.Entry<String, String> entry : mapStu.entrySet()){
            if(entry.getKey().equals(name)){
                return entry.getValue();
            }
        }
        return null;
    }
}