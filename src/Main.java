import dataStruct.Array;
import dataStruct.LinkClass;
import dataStruct.LinkClass.Node;
import dataStruct.Stack;
import entity.Student;
import java.util.HashMap;
import stream.StreamClass;

public class Main {

    public static void main(String[] args) {
        // objectTest();
        //hashCodeTest();
        //HashMapClass.printHashMap();
        //arrayTest();
        //stackTest();
        //streamTest();
        linkTest();
    }

    public static void objectTest() {
        Object o = new Object();
        Class c = o.getClass();
        String a = "jj";
        Number number = 10;
        String b = "BbCcDd";
        char[] chars = b.toCharArray();
        System.out.println(c);
        System.out.println(a.getClass());
        System.out.println(
                number.getClass() + " byteValue: " + number.byteValue() + " intValue" + number
                        .intValue());
        for (char aChar : chars) {
            System.out.println(aChar + "'s ascii is : " + (int) aChar);
        }

        System.out.println(
                b + "'s hashCode is: " + b.hashCode() + " " + b + "'s calculate hashCode is: "
                        + getStringHashCode(b));
    }

    public static int getStringHashCode(String s) {
        int hash = 0;
        if (s == null || s.length() == 0) {
            return hash;
        }
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            hash = hash * 31 + aChar;
        }
        return hash;
    }

    public static void hashCodeTest() {
        Student student0 = new Student("lihua", 22);
        Student student1 = new Student("lihua", 11);
        HashMap<Student, String> studentStringHashMap = new HashMap<>();
        studentStringHashMap.put(student0, "lihua");
        studentStringHashMap.put(student1, "lihua");
        for (Student student : studentStringHashMap.keySet()) {
            System.out.println(
                    student.getName() + "'s hashCode is :" + student.hashCode() + " age is: "
                            + student.getAge() + " toString: " + student.toString());
        }
    }

    private static void arrayTest() {
//        String array[]=new String[10];
//        array[0]="1";
//        System.out.println("array: "+array[10]);
        Array array = new Array(10);
        System.out.println("array: " + array.findIndex(9));
    }

    private static void stackTest() {
        Stack stack = new Stack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(
                "peek: " + stack.peek() + " pop: " + stack.pop() + " peek: " + stack.peek());
    }

    public static void streamTest() {
        StreamClass.sortUseJava7();
        StreamClass.sortUseJava8();
        StreamClass.switchToUpperCase();
        StreamClass.squareUseJava8();
        StreamClass.squareCommonStreamUseJava8();
        StreamClass.flatMapUseJava8();
        StreamClass.filterUseJava8();
        StreamClass.foreachUseJava8();
        StreamClass.peekUseJava8();
        StreamClass.optionalUseJava8();
        StreamClass.optionalLengthUseJava8();
        StreamClass.reduceUseJava8();
        StreamClass.limitSkipUseJava8();
        StreamClass.sortLimitUseJava8();
        StreamClass.matchUseJava8();
        StreamClass.identifyStream();
        StreamClass.customSupplierUseJava8();
        System.out.println("c++: " + "c++".hashCode() + "php: " + "php".hashCode());
    }

    public static void linkTest() {
        LinkClass linkClass = new LinkClass();
        for (int i = 0; i < 10; i++) {
            LinkClass.Node<String> node = new Node(i + "");
            linkClass.add(node);
        }
        Node temp = linkClass.head;
//        do {
//            System.out.println(temp);
//            temp = temp.next;
//        }
//        while (temp != null);
        linkClass.printLink(temp);
        System.out.println("remove: "+linkClass.remove(1));
        System.out.println("remove: "+linkClass.remove(1));
        Node temp1 = linkClass.head;
        linkClass.printLink(temp1);
//        while (temp1 != null) {
//            System.out.println(temp1);
//            temp1 = temp1.next;
//        }
    }
}
