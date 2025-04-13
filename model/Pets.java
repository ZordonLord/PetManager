package model;

import java.time.LocalDate;

public class Pets extends Animal {
    private String breed;
    private boolean isVaccinated;

    public Pets(String name, LocalDate birthDate, int age, String gender, String breed, boolean isVaccinated) {
        super(name, birthDate, age, gender);
        this.breed = breed;
        this.isVaccinated = isVaccinated;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "name='" + getName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", breed='" + breed + '\'' +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
} 