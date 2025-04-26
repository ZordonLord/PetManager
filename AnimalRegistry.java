import model.Animal;
import model.Dogs;
import model.Cats;
import model.Hamsters;
import model.Horses;
import model.Camels;
import model.Donkeys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class AnimalRegistry {
    private List<Animal> animals;
    private Scanner scanner;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
        this.scanner = new Scanner(System.in, "cp866");
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите целое число!");
                scanner.nextLine();
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите число!");
                scanner.nextLine();
            }
        }
    }

    private LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String dateStr = scanner.nextLine();
                return LocalDate.parse(dateStr, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка: Введите дату в формате ДД.ММ.ГГГГ!");
            }
        }
    }

    public void addNewAnimal() {
        try {
            System.out.println("Выберите тип животного:");
            System.out.println("1. Собака");
            System.out.println("2. Кошка");
            System.out.println("3. Хомяк");
            System.out.println("4. Лошадь");
            System.out.println("5. Верблюд");
            System.out.println("6. Осел");

            int choice = getIntInput("Введите номер типа животного:");

            System.out.println("Введите имя животного:");
            String name = scanner.nextLine();

            LocalDate birthDate = getDateInput("Введите дату рождения животного (ДД.ММ.ГГГГ):");
            int age = getIntInput("Введите возраст животного:");

            System.out.println("Введите пол животного (м/ж):");
            String gender = scanner.nextLine();

            Animal animal = null;
            switch (choice) {
                case 1: // Собака
                    System.out.println("Введите породу собаки:");
                    String breed = scanner.nextLine();
                    System.out.println("Собака вакцинирована? (да/нет):");
                    boolean isVaccinated = scanner.nextLine().equalsIgnoreCase("да");
                    System.out.println("Введите размер собаки (маленький/средний/большой):");
                    String size = scanner.nextLine();
                    animal = new Dogs(name, birthDate, age, gender, breed, isVaccinated, size);
                    break;
                case 2: // Кошка
                    System.out.println("Введите породу кошки:");
                    breed = scanner.nextLine();
                    System.out.println("Кошка вакцинирована? (да/нет):");
                    isVaccinated = scanner.nextLine().equalsIgnoreCase("да");
                    System.out.println("Кошка домашняя? (да/нет):");
                    boolean isIndoor = scanner.nextLine().equalsIgnoreCase("да");
                    System.out.println("Введите тип шерсти кошки:");
                    String furType = scanner.nextLine();
                    animal = new Cats(name, birthDate, age, gender, breed, isVaccinated, isIndoor, furType);
                    break;
                case 3: // Хомяк
                    System.out.println("Введите породу хомяка:");
                    breed = scanner.nextLine();
                    System.out.println("Хомяк вакцинирован? (да/нет):");
                    isVaccinated = scanner.nextLine().equalsIgnoreCase("да");
                    System.out.println("Введите цвет хомяка:");
                    String color = scanner.nextLine();
                    System.out.println("Хомяк ведет ночной образ жизни? (да/нет):");
                    boolean isNocturnal = scanner.nextLine().equalsIgnoreCase("да");
                    animal = new Hamsters(name, birthDate, age, gender, breed, isVaccinated, color, isNocturnal);
                    break;
                case 4: // Лошадь
                    double speed = getDoubleInput("Введите скорость лошади (км/ч):");
                    double carryingCapacity = getDoubleInput("Введите грузоподъемность лошади (кг):");
                    System.out.println("Введите масть лошади:");
                    String horseColor = scanner.nextLine();
                    animal = new Horses(name, birthDate, age, gender, speed, carryingCapacity, horseColor);
                    break;
                case 5: // Верблюд
                    speed = getDoubleInput("Введите скорость верблюда (км/ч):");
                    carryingCapacity = getDoubleInput("Введите грузоподъемность верблюда (кг):");
                    int humps = getIntInput("Введите количество горбов верблюда:");
                    animal = new Camels(name, birthDate, age, gender, speed, carryingCapacity, humps);
                    break;
                case 6: // Осел
                    speed = getDoubleInput("Введите скорость осла (км/ч):");
                    carryingCapacity = getDoubleInput("Введите грузоподъемность осла (кг):");
                    System.out.println("Осел упрямый? (да/нет):");
                    boolean isStubborn = scanner.nextLine().equalsIgnoreCase("да");
                    animal = new Donkeys(name, birthDate, age, gender, speed, carryingCapacity, isStubborn);
                    break;
                default:
                    System.out.println("Неверный выбор!");
                    return;
            }

            animals.add(animal);
            System.out.println("Животное успешно добавлено в реестр!");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при добавлении животного: " + e.getMessage());
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void printAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("В реестре нет животных.");
            return;
        }
        
        System.out.println("\nСписок всех животных в реестре:");
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            System.out.println((i + 1) + ". " + animal.toString());
        }
    }

    public void showAnimalCommands() {
        if (animals.isEmpty()) {
            System.out.println("В реестре нет животных.");
            return;
        }

        printAllAnimals();
        int animalIndex = getIntInput("Введите номер животного, чьи команды хотите посмотреть:") - 1;

        if (animalIndex < 0 || animalIndex >= animals.size()) {
            System.out.println("Неверный номер животного!");
            return;
        }

        Animal animal = animals.get(animalIndex);
        List<String> commands = animal.getLearnedCommands();

        if (commands.isEmpty()) {
            System.out.println("У этого животного нет выученных команд.");
        } else {
            System.out.println("\nСписок выученных команд животного " + animal.getName() + ":");
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i));
            }
        }
    }

    public void teachNewCommand() {
        if (animals.isEmpty()) {
            System.out.println("В реестре нет животных.");
            return;
        }

        printAllAnimals();
        int animalIndex = getIntInput("Введите номер животного, которого хотите обучить:") - 1;

        if (animalIndex < 0 || animalIndex >= animals.size()) {
            System.out.println("Неверный номер животного!");
            return;
        }

        Animal animal = animals.get(animalIndex);
        System.out.println("Введите новую команду для животного " + animal.getName() + ":");
        String newCommand = scanner.nextLine();

        if (animal.knowsCommand(newCommand)) {
            System.out.println("Животное уже знает эту команду!");
        } else {
            animal.addCommand(newCommand);
            System.out.println("Команда успешно добавлена!");
        }
    }
} 