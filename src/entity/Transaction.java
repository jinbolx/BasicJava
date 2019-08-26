package entity;

public class Transaction implements Comparable {

    private int id;
    private String type;
    private double balance;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Transaction(int id, String type, double balance, String name) {
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + "id=" + id + ",type=" + type + ",balance" + balance + ",name=" + name + "]";
    }

    @Override
    public int compareTo(Object o) {
        if (((Transaction) o).getBalance() < this.balance) {
            return 1;
        } else if (((Transaction) o).balance > this.balance) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int a=31;
        int b=32;
        System.out.println(String.format("and=%s,or=%s,xor=%s",a&b,a|b,a^b));
        Student src=new Student();
        src.setAge(11);
        src.setName("zhang");
        src.setSex("boy");
        Student dest=new Student();
        cloneTest(src,dest);
        System.out.println("dest: "+dest.toString());
        int a1[][]=new int[0][];
        arrayTest(a1);
    }
    public static void arrayTest(int[][]a){
        int [][]b={{2,3},{4,2},{2333}};
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.println("arrayElement: "+b[i][j]);
            }
        }
    }

    public static Student cloneTest(Student src,Student dest){
//        try {
//          return   src.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return null;
        dest.setName(src.getName());
        dest.setAge(src.getAge());
        return dest;
    }

}
