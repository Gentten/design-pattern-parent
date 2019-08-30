package org.gentten.designpattern.obervable.jdk.before9;

import java.util.Observable;

/**
 * 被观察者
 * 废弃原因
 * Observer和Observable有几个原因：
 * <p>
 * 1、不能序列化
 * <p>
 * Observable没有实现Serializable接口，它的内部成员变量都是私有的，子类不能通过继承它来对Observable的成员变量处理。所以子类也不能序列化。
 * <p>
 * 参考：Why is java.util.Observable class not serializable.
 * <p>
 * 2、不是线程安全
 * <p>
 * 在 java.util.Observable文档里没有强制要求Observable是线程安全的，它允许子类覆盖重写Observable的方法，事件通知无序以及事件通知发生在不同的线程里，这些都是会影响线程安全的问题。
 * <p>
 * 参考：Documentation of java.util.Observable
 * <p>
 * 3、支持事件模型的功能简单
 * <p>
 * 支持事件模型的功能很简单，例如，只是支持事情发生变化的概念，但是不能提供更多哪些内容发生了改变。
 * <p>
 * 不推荐使用并且1.9Observable已经启用
 *
 * @author : duanzhiqiang
 * @date : 2019-08-14 21:53
 */
public class MyObservable extends Observable {
    /**
     * 当设置为改变时才能触发， protect
     */
    @Override
    public void setChanged() {
        super.setChanged();
    }
}
