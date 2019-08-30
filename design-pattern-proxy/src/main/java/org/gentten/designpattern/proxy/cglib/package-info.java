/**
 * cglib 不需要保存被代理对象的
 * <p>
 * 原理：cglib是asm生成字节码，继承被代理类生成其子类(所以final类无法使用cglib代理)
 *
 * @author : duanzhiqiang
 * @date : 2019-08-27 21:26
 */
package org.gentten.designpattern.proxy.cglib;
