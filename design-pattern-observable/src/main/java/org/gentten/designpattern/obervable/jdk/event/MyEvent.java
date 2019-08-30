package org.gentten.designpattern.obervable.jdk.event;


import java.util.EventObject;

/**
 * jdk9之后 EventObject 和接口EventListener
 *
 * @author : duanzhiqiang
 * @date : 2019-08-14 21:56
 */
public class MyEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public MyEvent(Object source) {
        super(source);
    }
}
