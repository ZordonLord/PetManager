package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dogs extends Pets {
    private String size; // размер
    private boolean isTrained; // обучен ли
    private List<String> learnedCommands; // список выученных команд

    public Dogs(String name, LocalDate birthDate, int age, String gender, String breed, boolean isVaccinated, 
                String size, boolean isTrained) {
        super(name, birthDate, age, gender, breed, isVaccinated);
        this.size = size;
        this.isTrained = isTrained;
        this.learnedCommands = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public List<String> getLearnedCommands() {
        return learnedCommands;
    }

    public void addCommand(String command) {
        if (!learnedCommands.contains(command)) {
            learnedCommands.add(command);
        }
    }

    public void removeCommand(String command) {
        learnedCommands.remove(command);
    }

    public boolean knowsCommand(String command) {
        return learnedCommands.contains(command);
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
                ", isTrained=" + isTrained +
                ", learnedCommands=" + learnedCommands +
                '}';
    }
} 