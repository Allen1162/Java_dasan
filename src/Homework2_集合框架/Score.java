package Homework2_集合框架;

import java.util.List;

public class Score {

    private String id;
    private String courseName;
    private double score;
//    private List<Student> students;

    public Score(String id, String courseName, double score) {
        this.id = id;
        this.courseName = courseName;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }
}
