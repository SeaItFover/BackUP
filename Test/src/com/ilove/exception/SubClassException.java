package com.ilove.exception;

import jdk.nashorn.internal.runtime.ECMAException;

/**
 * 测试子类异常小于等于父类异常
 *
 * 遇到的问题:
 * 如果父类没有无参构造器，子类会报错
 */
public class SubClassException extends Person{
    public SubClassException(){

    }

    @Override
    public boolean select(int i)  throws InterruptedException{
        return false;
    }
}

class Person {
    int age;

    public Person(){

    }

    public Person(int age){
        this.age = age;
    }

    public boolean select(int i) throws InterruptedException {
        return age/i == 0 ? true :false;
    }
}
