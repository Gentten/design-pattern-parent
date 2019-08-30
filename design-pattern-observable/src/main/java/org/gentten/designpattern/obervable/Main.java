package org.gentten.designpattern.obervable;

import lombok.extern.slf4j.Slf4j;
import org.gentten.designpattern.obervable.jdk.before9.MyObservable;

/**
 * @author : duanzhiqiang
 * @date : 2019-08-14 21:50
 */
public class Main {
    public static void main(String[] args) {
        MyObservable myObservable = new MyObservable();
        //添加观察者
        myObservable.addObserver((observable, value) -> {
            System.out.println(value);
        });
        //设置改变
        myObservable.setChanged();
        //通知观察者
        myObservable.notifyObservers("value");

        //通知之后状态设置为未改变，即再次通知不会打印
        myObservable.notifyObservers("value");
    }
}
