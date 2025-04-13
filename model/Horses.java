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
        return "Horses{" +
                "name='" + getName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", speed=" + getSpeed() +
                ", carryingCapacity=" + getCarryingCapacity() +
                ", color='" + color + '\'' +
                '}';
    }
} 