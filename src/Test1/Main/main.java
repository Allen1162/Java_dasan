package Test1.Main;

import Test1.javaBean.Student;
import Test1.operations.Crud;

import java.util.*;

public class main {
    public static void main(String[] args){
        System.out.println("-----------");
        System.out.println("学生管理系统");
        System.out.println("-----------");

        System.out.println("1：添加学生");
        System.out.println("2：删除学生");
        System.out.println("3：修改学生");
        System.out.println("4：查询全部学生");
        System.out.println("5：根据学号查询学生");
        System.out.println("6：根据姓名查询电话号码");
        System.out.println("0：退出系统");

        List<Student> listStu = new ArrayList<>();
        Map<String, String> mapStu = new HashMap<>();
        new Crud(listStu, mapStu);

        while(true){
            System.out.println("请输入操作序号(0-6):");
            Scanner input = new Scanner(System.in);
            int num = input.nextInt();
            if(num <0 || num>6){
                System.out.println("输入序号不符合要求，请重新输入");
                continue;
            }
            if(num == 1){
                System.out.println("请输入学号：(以回车结束以下类似)");
                String id = input.next();
                System.out.println("请输入姓名：");
                String name = input.next();
                System.out.println("请输入年龄：");
                int age = input.nextInt();
                System.out.println("请输入语文成绩：");
                double chinese = input.nextDouble();
                System.out.println("请输入数学成绩：");
                double math = input.nextDouble();
                System.out.println("请输入英语成绩：");
                double english = input.nextDouble();
                System.out.println("请输入电话号码：");
                String phoneNumebr = input.next();
                Student student = new Student(id,name,age,chinese,math,english,phoneNumebr);
                if(Crud.addStu(student) == true){
                    System.out.println("添加成功！");
                }else{
                    System.out.println("添加失败！");
                }
            }else if(num == 2){
                System.out.println("请输入要删除的学生id：");
                String id = input.next();
                if(Crud.delStu(id) == true){
                    System.out.println("删除成功！");
                }else{
                    System.out.println("删除失败！");
                }
            }else if(num == 3){
                System.out.println("请输入要修改的学生id：");
                String id = input.next();
                if(Crud.updateStu(id) == true){
                    System.out.println("修改成功！");
                }else{
                    System.out.println("修改失败！");
                }
            }else if(num == 4){
                System.out.println("以下为全部学生的信息：");
                if(Crud.findAllStu() == true){
                    System.out.println("查询完毕");
                }else{
                    System.out.println("暂无学生记录");
                }
            }else if (num == 5){
                System.out.println("请输入要查询的学生id：");
                String id = input.next();
                int index=-1;
                if((index = Crud.findStuById(id)) != -1){
                    System.out.println(listStu.get(index));
                }else {
                    System.out.println("无该学生记录");
                }
            }else if(num == 6){
                System.out.println("请输入要查询的学生姓名：");
                String name = input.next();
                String phoneNumber = Crud.findPhoneNumberByName(name);
                if( phoneNumber != null){
                    System.out.println(name + "的电话号码为：" + phoneNumber);
                }else{
                    System.out.println("不存在该学生");
                }
            }else{
                System.out.println("退出系统");
                break;
            }
        }

    }
}