package com.abuob.person.domain;

public class Person {

    private String name;
    private int age;
    private int height;
    private boolean likesIceCream;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public boolean isLikesIceCream() {
        return likesIceCream;
    }
    public void setLikesIceCream(boolean likesIceCream) {
        this.likesIceCream = likesIceCream;
    }

}
