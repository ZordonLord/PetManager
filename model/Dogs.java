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
        return "Dogs{" +
                "name='" + getName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", isVaccinated=" + isVaccinated() +
                ", size='" + size + '\'' +
                ", learnedCommands=" + getLearnedCommands() +
                '}';
    }
} 