import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String faculty;
    private String groupS;

    public Student(Integer id, String name, String surname, String faculty, String group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.groupS = group;
    }



    public Student() {

    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGroup() {
        return groupS;
    }

    public void setGroup(String group) {
        this.groupS = group;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+surname+" "+faculty+" "+groupS;
    }
}
