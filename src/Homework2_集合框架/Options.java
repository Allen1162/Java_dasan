package Homework2_集合框架;

import java.util.ArrayList;
import java.util.List;

public class Options {

    public static void main(String[] args) {
        Student HJL = new Student("201725010408", "黄俊霖", "男", "计机四班");
        Score hjlCScore = new Score(HJL.getId(), "C语言", 100.0);
        Score hjlJavaScore = new Score(HJL.getId(), "Java", 90.0);
        Score hjlAlgorithmScore = new Score(HJL.getId(), "算法", 80.0);
        List<Score> hjlList = new ArrayList<>();
        hjlList.add(hjlCScore);
        hjlList.add(hjlJavaScore);
        hjlList.add(hjlAlgorithmScore);
        HJL.setScores(hjlList);

        Student Allen = new Student("408", "那星阿伦", "男", "计机四班");
        Score AllenCScore = new Score(Allen.getId(), "C语言", 90.0);
        Score AllenJavaScore = new Score(Allen.getId(), "Java", 80.0);
        Score AllenAlgorithmScore = new Score(Allen.getId(), "算法", 70.0);
        List<Score> AllenList = new ArrayList<>();
        AllenList.add(AllenCScore);
        AllenList.add(AllenJavaScore);
        AllenList.add(AllenAlgorithmScore);
        Allen.setScores(AllenList);

        Student LYW = new Student("201725010413", "林勇威", "男", "计机四班");
        Score LYWCScore = new Score(LYW.getId(), "C语言", 80.0);
        Score LYWJavaScore = new Score(LYW.getId(), "Java", 70.0);
        Score LYWAlgorithmScore = new Score(LYW.getId(), "算法", 60.0);
        List<Score> LYWList = new ArrayList<>();
        LYWList.add(LYWCScore);
        LYWList.add(LYWJavaScore);
        LYWList.add(LYWAlgorithmScore);
        LYW.setScores(LYWList);

        List<Score> CCourse = new ArrayList<>();
        CCourse.add(hjlCScore);
        CCourse.add(AllenCScore);
        CCourse.add(LYWCScore);

        List<Score> JavaCourse = new ArrayList<>();
        JavaCourse.add(hjlJavaScore);
        JavaCourse.add(AllenJavaScore);
        JavaCourse.add(LYWJavaScore);

        List<Score> AlgorithmCourse = new ArrayList<>();
        AlgorithmCourse.add(hjlAlgorithmScore);
        AlgorithmCourse.add(AllenAlgorithmScore);
        AlgorithmCourse.add(LYWAlgorithmScore);


//        List<String> idList = new ArrayList<>();
//        idList.add(HJL.getId());
//        idList.add(Allen.getId());
//        idList.add(LYW.getId());

        //(2)要求输出每门课程的所有学生的平均成绩
        getAvgByScoreList(CCourse);
        System.out.println();
        getAvgByScoreList(JavaCourse);
        System.out.println();
        getAvgByScoreList(AlgorithmCourse);
        System.out.println();

        //(3)输出某门课程的最高成绩，最低成绩
        getMaxAndMinScore(CCourse);
        System.out.println();
        getMaxAndMinScore(JavaCourse);
        System.out.println();
        getMaxAndMinScore(AlgorithmCourse);
        System.out.println();

        //(4)可以查询某个学生的所有成绩
        getStuAllScores(HJL);
        System.out.println();
        getStuAllScores(Allen);
        System.out.println();
        getStuAllScores(LYW);
        System.out.println();
    }

    public static void getAvgByScoreList(List<Score> scoreList){
        double sum = 0.0;
        int count = 0;
        for(Score score : scoreList){
            System.out.println("id：" + score.getId() + "的" + score.getCourseName() + "的成绩为：" + score.getScore());
            sum += score.getScore();
            count++;
        }
        System.out.println("该门课程的平均成绩为：" + sum/count);
    }

    public static void getMaxAndMinScore(List<Score> scoreList){
        double max=0, min=100;
        for(Score score : scoreList){
            if(score.getScore() > max) max = score.getScore();
            if(score.getScore() < min) min = score.getScore();
        }
        System.out.println(scoreList.get(0).getCourseName() + "的最高成绩：" + max + ", 最低成绩：" + min);
    }

    public static void getStuAllScores(Student student){
        List<Score> scoreList = student.getScores();
        System.out.println("id:" + student.getId() + ",名字:" + student.getName() + "的所有课程信息如下：");
        for(Score score : scoreList){
            System.out.println("课程名：" + score.getCourseName() +", 成绩：" + score.getScore());
        }
    }
}
