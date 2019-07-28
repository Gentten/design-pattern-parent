package org.gentten.designpattern.proxy;

import org.gentten.designpattern.proxy.jdk.AbstractProxiedSubject;
import org.gentten.designpattern.proxy.jdk.JDKProxy;
import org.gentten.designpattern.proxy.jdk.ProxiedSubject;

/**
 * @author : duanzhiqiang
 * @date : 2019-07-28 16:18
 */
public class Main {
    public static void main(String[] args) {
        //设置系统属性打印生成class 文件 没有作用
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //被代理人
        AbstractProxiedSubject proxiedSubject = new ProxiedSubject("张三");
        //获取代理
        AbstractProxiedSubject personProxy = new JDKProxy().getRentHouseProxy(proxiedSubject);
        //代理去执行
        personProxy.doSomeThings();
    }


}
