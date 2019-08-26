package reflection;

import entity.Student;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionClass {

    public static void main(String[] args)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        ReflectionClass reflectionClass = new ReflectionClass();
        reflectionClass.reflectionTest(reflectionClass);
       // reflectionClass.genericTest();
    }

    public Class<?> getClassUseReflection() throws ClassNotFoundException {
        //说明任何一个类都隐含一个静态的成员变量class
        Class<?> c1 = Student.class;
        Student student = new Student();
        //通过类对象的getclass方法获得
        Class<?> c2 = student.getClass();
        //调用类的全量限定名获得
        Class<?> c3 = Class.forName("entity.Student");
        return c3;
    }
    public void reflectionTest(ReflectionClass reflectionClass)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c = reflectionClass.getClassUseReflection();
        Object o = c.newInstance();
        Method methodSetter = c.getMethod("setName", String.class);
        //获取当前类的所有方法，不包括父类的方法
        Method[] declaredMethods = c.getDeclaredMethods();
        //获取当前类的所有public方法包括父类的方法
        Method[] methods = c.getMethods();
        Arrays.stream(declaredMethods).forEach(t -> System.out.println(
                "declaredMethodName: " + t.getName() + " returnType: " + t.getReturnType()
                        + " paramsCount: " + t.getParameterCount()));
        Arrays.stream(methods).forEach(t -> System.out.println(
                "allMethodName: " + t.getName() + " returnType: " + t.getReturnType()
                        + " paramsCount: " + t.getParameterCount()));
        //获取当前类声明的所有成员变量，不包括父类的
        Field[] declaredFields = c.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(t -> System.out
                .println("declaredFieldsName " + t.getName() + " type: " + t.getType()));
        Arrays.stream(declaredFields).forEach(t -> t.setAccessible(true));
        //获取当前类所有的public成员变量,包括父类的
        Field[] fields = c.getFields();
        Arrays.stream(fields).forEach(
                t -> System.out.println("FieldsName " + t.getName() + " type: " + t.getType()));
        methodSetter.invoke(o, "zhangsan");
        Method method = c.getMethod("toString");
        method.invoke(o);
        Field field = c.getDeclaredField("name");
        field.setAccessible(true);
        field.set(o, "黎明");
        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(o, 20);
        System.out.println("name.value: " + field.get(o) + " age.value: " + ageField.get(o));
        //获取当前类声明的所有构造方法，不包括父类
        Constructor[] declaredConstructors = c.getDeclaredConstructors();
        //获取当前类声明的所有public构造方法，包括父类
        Constructor[] constructors = c.getConstructors();
        Arrays.stream(declaredConstructors).forEach(t -> System.out.println(
                "declaredConstructor" + t.getName() + " paramsCount: " + t.getParameterCount()));
        Arrays.stream(constructors).forEach(t -> System.out
                .println("constructor" + t.getName() + " paramsCount: " + t.getParameterCount()));
        Constructor constructor = c.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Student student = (Student) constructor.newInstance(20);
        System.out.println("constructor: " + constructor.getName() + " count: " + constructor
                .getParameterCount() + " age：" + student.getAge());
        Constructor[] superConstructor=c.getSuperclass().getConstructors();
        Arrays.stream(superConstructor).forEach(t -> System.out
                .println("superConstructor" + t.getName() + " paramsCount: " + t.getParameterCount()));
    }
    public void genericTest()
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<String> list=new ArrayList<>();
        list.add("string1");
        Class c=list.getClass();
        Method addMethod=c.getMethod("add", Object.class);
        addMethod.invoke(list,20);
        Method sizeMethod=c.getMethod("size");
        int size= (int) sizeMethod.invoke(list);
        System.out.println("generic.size: "+size);
        Method getElement=c.getMethod("get", int.class);
        for (int i = 0; i < size; i++) {
            System.out.println("element: "+getElement.invoke(list,i));
        }

    }

}
