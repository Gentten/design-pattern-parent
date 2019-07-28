package org.gentten.designpattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK代理人
 *
 * @author : duanzhiqiang
 * @date : 2019-07-28 16:49
 */
public class JDKProxy {
    /**
     * 代理对象，需要调用被代理人的方法
     */
    private AbstractProxiedSubject target;

    /**
     * 获取租房子的代理
     * 实现原理
     * 1、拿到被代理对象的引用，然后得到类加载器和接口
     * 2、JDK重新生成一个类，同时实现我们的接口
     * 3、重新动态生成一个class字节码文件
     *
     * @param target 需要代理的对象
     * @return 代理
     */
    public AbstractProxiedSubject getRentHouseProxy(AbstractProxiedSubject target) {
        this.target = target;
        Class targetClass = target.getClass();
        //类加载器、接口、 代理人是怎么去执行 即需要实现InvocationHandler 中的invoke方法
        return (AbstractProxiedSubject) Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this::rentHouseProxy);
    }

    /**
     * 代理人是怎么做的，即怎么代理租房子
     * 参考{@link InvocationHandler}中 invoke 方法
     *
     * @param c      代理人对象   注意该对象是代理对象 不是被代理对象，如果要调用被代理对象需要声明缓存target
     * @param method 执行的方法
     * @param args   参数
     * @return 代理执行的结果
     * @throws Throwable 异常
     */
    public Object rentHouseProxy(Object c, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理，我来代替他执行租房子");
        System.out.println("在网上进行海选");
        System.out.println("----------------------");
        //调用被代理人的方法
        Object res = method.invoke(target, args);
        System.out.println("----------------------");
        System.out.println("是否满意");
        return res;
    }
}
