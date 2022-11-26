package com.github.zipcodewilmington.sample;

public class Person implements PersonInterface {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person() {
        this.firstName ="";
        this.lastName = "";
        this.age = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return null;
    }
}