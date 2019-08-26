package dataStruct;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println("name: "+name+" age: "+age);
    }


    @Override
    public int compareTo(Student o) {
        return Integer.compare(age,o.age);
    }
}
