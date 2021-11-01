package com.luxoft.reflection;

public class Person {
    public String name;
    private int age;
    private String birthday;

    public Person() {
    }

    public Person(String name, int age, String birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    private String getBirthday(){
        return name + "'s birthday is on " + birthday;
    }

    public final String eat(String food){
        return name + " is eating" + food + " now";
    }

    public String sleep(){
        return name + " is sleeping now";
    }

    @Override
    public String toString() {
        return "Person:" +
                " name=" + name +
                ", age=" + age +
                ", birthday=" + birthday;
    }
}
