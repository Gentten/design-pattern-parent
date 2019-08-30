package org.gentten.designpattern.proxy.jdk;

/**
 * 抽象被代理对象，jdk 代理必须要实现接口
 *
 * @author : duanzhiqiang
 * @date : 2019-07-28 16:37
 */
public interface AbstractProxiedSubject {
    /**
     * 被代理者需要做的时
     */
    default void doSomeThings() {
        System.out.println("被代理对象：doSomeThings");
    }

    /**
     * 测试性能
     *
     * @param i
     * @return
     */
    default int add(int i) {
        return i + 1;
    }

}
