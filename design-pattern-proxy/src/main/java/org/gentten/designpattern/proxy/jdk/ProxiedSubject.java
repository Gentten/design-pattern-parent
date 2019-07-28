package org.gentten.designpattern.proxy.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 被代理人
 *
 * @author : duanzhiqiang
 * @date : 2019-07-28 16:46
 */

@AllArgsConstructor
@Data
public class ProxiedSubject implements AbstractProxiedSubject {
    private String name;

    @Override
    public void doSomeThings() {
        System.out.println("我是：" + name + ",我要租房子");
    }
}
