package com.imood;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/18
 * @version: 1.0
 */
class Animal{
    public void move(){
        System.out.println("the animal is moving");
    }
}

class Dog extends Animal{
    public void move(){
        System.out.println("the dog can run");
    }
    public void bark(){
        System.out.println("the dog can bark");
    }
}



