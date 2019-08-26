package proxy;

import java.lang.reflect.Proxy;

public class ProxyClass {

    public static void main(String[] args) {
        TaskInterface taskInterface=new TaskProxy(new TaskImpl());
        //taskInterface.dealTask("进行任务");
        TaskInterface proxy= (TaskInterface) Proxy.newProxyInstance(taskInterface.getClass().getClassLoader(),
                taskInterface.getClass().getInterfaces(), new Interceptor(taskInterface));
        proxy.dealTask("进行任务");
    }
}
