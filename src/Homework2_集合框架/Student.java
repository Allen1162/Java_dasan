package Homework2_集合框架;

import java.util.List;

public class Student {

    private String id;
    private String name;
    private String sex;
    private String stuClass;
    private List<Score> scores;

    public Student(String id, String name, String sex, String stuClass) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.stuClass = stuClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
