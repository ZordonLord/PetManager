package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name; // кличка
    private LocalDate birthDate; // дата рождения
    private int age; // возраст 
    private String gender; // пол
    private List<String> learnedCommands; // список выученных команд

    public Animal(String name, LocalDate birthDate, int age, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = age;
        this.gender = gender;
        this.learnedCommands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return String.format("Животное {кличка='%s', дата рождения='%s', возраст=%d, пол='%s', выученные команды=%s}",
                name, birthDate, age, gender, learnedCommands);
    }
} 