package org.gentten.designpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.gentten.designpattern.proxy.jdk.ProxiedSubject;

import java.lang.reflect.Method;


/**
 * cglib代理
 *
 * @author : duanzhiqiang
 * @date : 2019-08-27 20:51
 */
public class CglibProxy {


    /**
     * 获取租房子的代理
     * 实现原理
     * 1、拿到被代理对象的引用，然后得到类加载器和接口
     * 2、JDK重新生成一个类，同时实现我们的接口
     * 3、重新动态生成一个class字节码文件
     *
     * @param target 需要代理类类型
     * @return 代理
     */
    public static ProxiedSubject getRentHouseProxy(ProxiedSubject target) {
        //增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        //回调
        enhancer.setCallback(new RentHouseMethodInterceptor());
        ProxiedSubject proxy = (ProxiedSubject) enhancer.create();
        //setName 也被拦截了 所以会有两次打印
        //proxy.setName(target.getName());
        return proxy;
    }

    public static ProxiedSubject getAddProxy(ProxiedSubject target) {
        //增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        //回调
        enhancer.setCallback(new AddMethodInterceptor());
        ProxiedSubject proxy = (ProxiedSubject) enhancer.create();

        return proxy;
    }

}

/**
 * MethodInterceptor 会拦截所有自己声明方法  getDeclaredFields
 */
class RentHouseMethodInterceptor implements MethodInterceptor {
    /**
     * 会拦截所有的方法
     *
     * @param obj    代理对象，被代理对象的子类
     * @param method 调用的方法
     * @param args   参数
     * @param proxy  方法代理
     * @return 返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("我是Cglib代理，我来代替他执行租房子");
        System.out.println("在网上进行海选");
        System.out.println("----------------------");
        //调用被代理人的方法 因为是 obj 是代理对象时被代理的对象的子类，所以此处是调用父类的method
        Object res = proxy.invokeSuper(obj, args);
        System.out.println(method.getName());
        System.out.println("----------------------");
        System.out.println("是否满意");
        return null;
    }
}

/**
 * MethodInterceptor 会拦截所有自己声明方法  getDeclaredFields
 */
class AddMethodInterceptor implements MethodInterceptor {
    /**
     * 会拦截所有的方法
     *
     * @param obj    代理对象，被代理对象的子类
     * @param method 调用的方法
     * @param args   参数
     * @param proxy  方法代理
     * @return 返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object res = proxy.invokeSuper(obj, args);
        return res;
    }
}