package model;

import java.time.LocalDate;

public class Animal {
    private String name; // кличка
    private LocalDate birthDate; // дата рождения
    private int age; // возраст 
    private String gender; // пол

    public Animal(String name, LocalDate birthDate, int age, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
} 