package Homework4_注解;

@Entity("People")
public class People {

    @ID
    @Column(/*value = "学号",*/ nullable = true)
    private Integer id;

    @Column(/*value = "姓名", */nullable = false, length = 16)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
