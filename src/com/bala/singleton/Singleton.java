package com.bala.singleton;

public class Singleton {
    private static Singleton singleton = null;
    private Singleton() {
        System.out.println("123");
    }
    public static Singleton getInstance() {
        singleton = new Singleton();
        return singleton;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
