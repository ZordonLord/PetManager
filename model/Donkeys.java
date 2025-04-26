package model;

import java.time.LocalDate;

public class Donkeys extends PackAnimals {
    private boolean isStubborn; // упрямый ли

    public Donkeys(String name, LocalDate birthDate, int age, String gender, double speed, double carryingCapacity,
                  boolean isStubborn) {
        super(name, birthDate, age, gender, speed, carryingCapacity);
        this.isStubborn = isStubborn;
    }

    public boolean isStubborn() {
        return isStubborn;
    }

    public void setStubborn(boolean stubborn) {
        isStubborn = stubborn;
    }

    @Override
    public String toString() {
        return String.format("Осёл {кличка='%s', дата рождения='%s', возраст=%d, пол='%s', выученные команды=%s}",
                getName(), getBirthDate(), getAge(), getGender(), getLearnedCommands());
    }
} 