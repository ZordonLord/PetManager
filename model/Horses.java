package model;

import java.time.LocalDate;

public class Horses extends PackAnimals {
    private String color; // масть

    public Horses(String name, LocalDate birthDate, int age, String gender, double speed, double carryingCapacity,
                 String color) {
        super(name, birthDate, age, gender, speed, carryingCapacity);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Лошадь {кличка='%s', дата рождения='%s', возраст=%d, пол='%s', выученные команды=%s}",
                getName(), getBirthDate(), getAge(), getGender(), getLearnedCommands());
    }
} 