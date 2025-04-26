package model;

import java.time.LocalDate;

public class Camels extends PackAnimals {
    private int humps; // количество горбов

    public Camels(String name, LocalDate birthDate, int age, String gender, double speed, double carryingCapacity,
                 int humps) {
        super(name, birthDate, age, gender, speed, carryingCapacity);
        this.humps = humps;
    }

    public int getHumps() {
        return humps;
    }

    public void setHumps(int humps) {
        this.humps = humps;
    }

    @Override
    public String toString() {
        return String.format("Верблюд {кличка='%s', дата рождения='%s', возраст=%d, пол='%s', выученные команды=%s}",
                getName(), getBirthDate(), getAge(), getGender(), getLearnedCommands());
    }
} 