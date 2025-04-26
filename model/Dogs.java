package model;

import java.time.LocalDate;


public class Dogs extends Pets {
    private String size; // размер

    public Dogs(String name, LocalDate birthDate, int age, String gender, String breed, boolean isVaccinated, 
                String size) {
        super(name, birthDate, age, gender, breed, isVaccinated);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Собака {кличка='%s', дата рождения='%s', возраст=%d, пол='%s', выученные команды=%s}",
                getName(), getBirthDate(), getAge(), getGender(), getLearnedCommands());
    }
} 