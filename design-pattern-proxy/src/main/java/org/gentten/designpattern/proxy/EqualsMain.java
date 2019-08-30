package org.gentten.designpattern.proxy;

import org.gentten.designpattern.proxy.cglib.CglibProxy;
import org.gentten.designpattern.proxy.jdk.AbstractProxiedSubject;
import org.gentten.designpattern.proxy.jdk.JDKProxy;
import org.gentten.designpattern.proxy.jdk.ProxiedSubject;

/**
 * 性能比较 在jdk8 下创建jdk动态代理的效率比cglib高，在高调用次数下cglib消费时间少一点
 *
 *
 *
 * @author : duanzhiqiang
 * @date : 2019-08-27 22:34
 */
public class EqualsMain {
    public static void main(String[] args) {
        //被代理人
        ProxiedSubject proxiedSubject = new ProxiedSubject("张三");
        //获取两种代理
        AbstractProxiedSubject personJdkProxy = null;
        AbstractProxiedSubject personCglibProxy = null;
        int count = 100000;
        long begin = 0, end = 0;
        System.out.println("创建代理对象测试，次数：" + count);
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            personCglibProxy = CglibProxy.getAddProxy(proxiedSubject);
        }
        end = System.currentTimeMillis();
        System.out.println("Cglib:" + (end - begin) + "ms");
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            personJdkProxy = new JDKProxy().getAddProxy(proxiedSubject);
        }
        end = System.currentTimeMillis();
        System.out.println("jdk:" + (end - begin) + "ms");

        System.out.println("------------------------------------");
        count = 200000000;
        System.out.println("代理对象执行代理方法测试，次数：" + count);
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            personCglibProxy.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Cglib:" + (end - begin) + "ms");
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            personJdkProxy.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("jdk:" + (end - begin) + "ms");


    }

}
