package model;

import java.time.LocalDate;

public class Cats extends Pets {
    private boolean isIndoor; // домашний или гуляющий
    private String furType; // тип шерсти

    public Cats(String name, LocalDate birthDate, int age, String gender, String breed, boolean isVaccinated, 
                boolean isIndoor, String furType) {
        super(name, birthDate, age, gender, breed, isVaccinated);
        this.isIndoor = isIndoor;
        this.furType = furType;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    public String getFurType() {
        return furType;
    }

    public void setFurType(String furType) {
        this.furType = furType;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "name='" + getName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", isVaccinated=" + isVaccinated() +
                ", isIndoor=" + isIndoor +
                ", furType='" + furType + '\'' +
                '}';
    }
} 