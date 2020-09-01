package com.ilove.exception;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class TestHashCode {

    public static void main(String[] args) {
        User user = new User(12, "xx");
        System.out.println(user.hashCode());
        user.setAge(23);
        user.setName("sdfa");
        System.out.println(user);
        System.out.println(user.hashCode());
    }
}


class User {
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String age) {
        this.name = age;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
