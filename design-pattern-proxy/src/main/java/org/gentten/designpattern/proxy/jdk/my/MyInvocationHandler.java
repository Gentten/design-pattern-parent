package org.gentten.designpattern.proxy.jdk.my;

import java.lang.reflect.Method;

/**
 * 代理的执行器
 *
 * @author : duanzhiqiang
 * @date : 2019-07-28 19:38
 */
public interface MyInvocationHandler {
    /**
     * @param proxy  代理对象
     * @param method 方法
     * @param args   参数
     * @return 执行结果
     */
    Object invoke(Object proxy, Method method, Object[] args);
}
