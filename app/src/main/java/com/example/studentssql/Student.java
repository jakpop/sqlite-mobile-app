package com.example.studentssql;

public class Student {

    private String name;
    private String surname;
    private int age;
    private String pesel;
    private String gender;

    public Student(String name, String surname, int age, String pesel, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.pesel = pesel;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
