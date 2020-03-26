package dynamicinvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : huikang.lv
 */
public class Proxy implements InvocationHandler {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object result = method.invoke(target, args);
        System.out.println("调用后");
        return result;
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        Animal dog = (Animal) proxy.getInstance(new Dog());
        dog.eat();
    }
}
