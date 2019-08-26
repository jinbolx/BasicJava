package stream;

import static java.util.stream.Collectors.toList;

import entity.Student;
import entity.Transaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamClass {

    public static List<Transaction> initList() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction(1, "已付款", 100.0, "交易1"));
        list.add(new Transaction(2, "待付款", 1100.0, "交易2"));
        list.add(new Transaction(3, "已付款", 10.0, "交易3"));
        list.add(new Transaction(4, "已付款", 11.0, "交易4"));
        list.add(new Transaction(5, "已付款", 110.0, "交易5"));
        list.add(new Transaction(6, "已付款", 2100.0, "交易6"));
        list.add(new Transaction(7, "已付款", 3100.0, "交易7"));
        list.add(new Transaction(8, "已付款", 1100.0, "交易8"));
        return list;
    }

    public static void sortUseJava7() {
        List<Transaction> currentList = initList();
        List<Transaction> validList = new ArrayList<>();
        for (Transaction t :
                currentList) {
            if (t.getType().equals("已付款")) {
                validList.add(t);
            }
        }
        Collections.sort(validList, new ComparatorImpl());
        for (int i = 0; i < validList.size(); i++) {
            System.out.println(validList.get(i).toString());
        }
        List<Integer> ids = new ArrayList<>();
        for (Transaction t :
                validList) {
            ids.add(t.getId());
        }
        System.out.println("ids: " + ids.toString());
    }

    public static void sortUseJava8() {
        List<Transaction> currentList = initList();
        String[] a = new String[2];
        List<Integer> ids = currentList.stream()
                .filter(t -> t.getType().equals("已付款"))
                //.sorted(Transaction::compareTo)
                .sorted(Comparator.comparing(Transaction::getBalance))
                .map(Transaction::getId)
                .collect(toList());
        System.out.println("java8: ids: " + ids.toString());
    }

    public static class ComparatorImpl implements Comparator<Transaction> {

        @Override
        public int compare(Transaction t1, Transaction t2) {
            if (t1.getBalance() > t2.getBalance()) {
                return 1;
            } else if (t1.getBalance() < t2.getBalance()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void switchToUpperCase() {
        Stream<String> stream = Stream.of("b", "c", "a");
        List<String> outList = stream
                .map(String::toUpperCase)
                .sorted(Comparator.comparing(String::hashCode))
                .collect(toList());
        System.out.println("outList: " + outList.toString());
    }

    public static void squareUseJava8() {
        IntStream stream = IntStream.of(1, 2, 3, 5, 3, 4);
        int[] integerList = stream
                .map(t -> t * t)
                .sorted()
                .toArray();
        List list = Collections.singletonList(integerList);
        System.out.println(Arrays.toString(integerList));
    }

    public static void squareCommonStreamUseJava8() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 6, 4, 3);
        List<Integer> integerList = stream
                .map(n -> n * n)
                .sorted()
                .collect(toList());
        System.out.println(integerList);
    }

    public static void flatMapUseJava8() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(2, 3, 1),
                Arrays.asList(4, 5, 2),
                Arrays.asList(6, 7, 8)
        );
        Stream<Integer> outputStream = inputStream
                .flatMap(Collection::stream)
                .sorted();
        List<Integer> outputList = outputStream.collect(toList());
        System.out.println(outputList);
    }

    public static void filterUseJava8() {
        Integer[] nums = {1, 2, 3, 4, 383, 23, 22, 6, 9, 20};
        Integer[] filterNums = Stream.of(nums)
                .filter(n -> n % 2 == 1)
                .sorted()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(filterNums));
    }

    public static void foreachUseJava8() {
        List<Transaction> transactionList = initList();
        transactionList.stream()
                .filter(t -> t.getBalance() > 100)
                .collect(Collectors.toList())
                .forEach(t -> {
                    System.out.println("foreachUseJava8");
                    System.out.println(t.toString());
                });
        System.out.println();
        System.out.println();
    }

    public static void peekUseJava8() {
        List<Transaction> transactionList = initList();
        List<Transaction> list = transactionList.stream()
                .filter(t -> t.getBalance() > 100)
                .peek(t -> System.out.println(t.toString()))
                .sorted(Transaction::compareTo)
                .peek(t -> System.out.println(t.toString()))
                .collect(toList());

    }

    public static void optionalUseJava8() {
        List<String> list = Arrays.asList("abd", "", null, "c");
//        for (String s : list) {
//            Optional.ofNullable(s).ifPresent(System.out::println);
//        }
        list.stream()
                .filter(t -> Optional.ofNullable(t).isPresent())
                .forEach(System.out::println);

    }

    public static void optionalLengthUseJava8() {
        List<String> list = Arrays.asList("abd", "", null, "c");
        list.stream()
                .map(t -> Optional.ofNullable(t).map(String::length).orElse(-1))
                .peek(System.out::println)
                .toArray(Integer[]::new);
        //.collect(toList());
        String[] array = new String[]{"abd", "", null, "c"};
//        Arrays.stream(array)
//                .map(t -> Optional.ofNullable(t).map(String::length).orElse(-1))
//                .peek(System.out::println)
//                .toArray(Integer[]::new);
        Optional.ofNullable(null).ifPresent(t -> {

        });
    }

    public static void reduceUseJava8() {
        List<String> list = Arrays.asList("g", "a", "b", "e", "f", "c", "d");
        String text = list.stream()
                .sorted(String::compareTo)
                .reduce("", String::concat);
        Stream.of(text)
                .forEach(System.out::println);
        double a = Stream.of(1.0, 3.0, -3.0, -4.0)
                .reduce(Double::min).get();
        System.out.println("double: " + a);
        System.out.println(Stream.of(1, 2, 3, 4, 9)
                .reduce(0, Integer::sum));

    }

    public static void limitSkipUseJava8() {
        List<Student> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Student student = new Student("name" + i, i);
            list.add(student);
        }
        list.stream().limit(20).skip(10).forEach(System.out::println);
        String a = "我";
        //System.out.println("我的hashcode: " + "abc".hashCode());
       // printHashCode("abc");
        //"17,85,54,50,49,49";
    }

    public static void printHashCode(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        char [] chars=s.toCharArray();
        int hashcode=0;
        for (int i = 0; i < chars.length; i++) {
            hashcode=hashcode*31+chars[i];
        }
        System.out.println("hashcode: "+hashcode);

    }
    public static void sortLimitUseJava8(){
        List<Student> students=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student=new Student("name"+i,i);
            students.add(student);
        }
        students.stream().limit(3).sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }
    public static void matchUseJava8(){
        List<Student> students=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student=new Student("name"+i,i);
            students.add(student);
        }
       boolean anyMatch= students.stream().anyMatch(p->p.getName().hashCode()>10000);
        System.out.println("anyMatch: "+anyMatch);
    }
    public static void identifyStream(){
        Random random=new Random();
        Supplier<Integer> supplier=random::nextInt;
        Stream.generate(supplier).limit(5).forEach(System.out::println);
    }
   static class StudentSupplier implements Supplier<Student>{
        private int index=0;
        Random random=new Random();
       @Override
       public Student get() {
           return new Student("name"+(++index),random.nextInt(50));
       }
   }
   public static void customSupplierUseJava8(){
        Stream.generate(new StudentSupplier()).limit(5)
                .forEach(System.out::println);
   }
}
