package model;

import java.time.LocalDate;

public class PackAnimals extends Animal {
    private double speed;
    private double carryingCapacity;

    public PackAnimals(String name, LocalDate birthDate, int age, String gender, double speed, double carryingCapacity) {
        super(name, birthDate, age, gender);
        this.speed = speed;
        this.carryingCapacity = carryingCapacity;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    @Override
    public String toString() {
        return "PackAnimals{" +
                "name='" + getName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", speed='" + speed + '\'' +
                ", carryingCapacity=" + carryingCapacity +
                '}';
    }
} 