package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Interceptor implements InvocationHandler {
    private Object object;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before: invoke");
        Object result=method.invoke(object,args);
        System.out.println("after: invoke");
        return result;
    }

    public Interceptor(Object object) {
        this.object = object;
    }
}
