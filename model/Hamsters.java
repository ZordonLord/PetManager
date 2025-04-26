package model;

import java.time.LocalDate;

public class Hamsters extends Pets {
    private String color; // цвет
    private boolean isNocturnal; // ночной ли образ жизни

    public Hamsters(String name, LocalDate birthDate, int age, String gender, String breed, boolean isVaccinated, 
                    String color, boolean isNocturnal) {
        super(name, birthDate, age, gender, breed, isVaccinated);
        this.color = color;
        this.isNocturnal = isNocturnal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isNocturnal() {
        return isNocturnal;
    }

    public void setNocturnal(boolean nocturnal) {
        isNocturnal = nocturnal;
    }

    @Override
    public String toString() {
        return String.format("Хомяк {кличка='%s', дата рождения='%s', возраст=%d, пол='%s', выученные команды=%s}",
                getName(), getBirthDate(), getAge(), getGender(), getLearnedCommands());
    }
} 