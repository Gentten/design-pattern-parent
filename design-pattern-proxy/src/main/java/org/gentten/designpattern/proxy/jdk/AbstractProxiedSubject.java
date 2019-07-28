package org.gentten.designpattern.proxy.jdk;

/**
 * 抽象被代理对象，jdk 代理必须要继承接口
 *
 * @author : duanzhiqiang
 * @date : 2019-07-28 16:37
 */
public interface AbstractProxiedSubject {
    /**
     * 被代理者需要做的时
     */
    default void doSomeThings() {
        System.out.println("doSomeThings");
    }


}
