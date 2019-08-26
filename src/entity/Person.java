package entity;

public class Person {
 public String sex;
 private String grade;

    public Person() {
    }

    private Person(String sex) {
        this.sex = sex;
    }

     Person(String sex, String grade) {
        this.sex = sex;
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
