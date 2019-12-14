package Homework3_反射;

public class Person {
    private String name;
    private String sex;
    private Integer age;
    private String idNo;
    private Boolean isMerried;
    public String getName() {
        return name;
    }
    public void setName(String name/*, Double d*/){
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getIdNo() {
        return idNo;
    }
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    public Boolean getIsMerried() {
        return isMerried;
    }
    public void setIsMerried(Boolean isMerried) {
        this.isMerried = isMerried;
    }
    public Person(String idNo) {
    }
    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", idNo='" + idNo + '\'' +
                ", isMerried=" + isMerried +
                '}';
    }
}
