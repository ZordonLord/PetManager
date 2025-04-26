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
    private Counter animalCounter;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
        this.scanner = new Scanner(System.in, "cp866");
        this.animalCounter = new Counter();
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
        try (Counter counter = new Counter()) {
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
            counter.add();
            animalCounter.add();
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

    public void printAnimalsByBirthDate() {
        if (animals.isEmpty()) {
            System.out.println("В реестре нет животных.");
            return;
        }
        
        // Создаем копию списка для сортировки
        List<Animal> sortedAnimals = new ArrayList<>(animals);
        // Сортируем по дате рождения
        sortedAnimals.sort((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()));
        
        System.out.println("\nСписок животных, отсортированный по дате рождения:");
        for (int i = 0; i < sortedAnimals.size(); i++) {
            Animal animal = sortedAnimals.get(i);
            System.out.println((i + 1) + ". " + animal.toString() + 
                             " (Дата рождения: " + animal.getBirthDate().format(DATE_FORMATTER) + ")");
        }
    }

    public void printAnimalStatistics() {
        System.out.println("\nСтатистика по животным:");
        System.out.println("Общее количество животных: " + animalCounter.getCount());
        
        int domesticCount = 0;
        int packCount = 0;
        int dogsCount = 0;
        int catsCount = 0;
        int hamstersCount = 0;
        int horsesCount = 0;
        int camelsCount = 0;
        int donkeysCount = 0;
        
        for (Animal animal : animals) {
            if (animal instanceof Dogs) {
                dogsCount++;
                domesticCount++;
            } else if (animal instanceof Cats) {
                catsCount++;
                domesticCount++;
            } else if (animal instanceof Hamsters) {
                hamstersCount++;
                domesticCount++;
            } else if (animal instanceof Horses) {
                horsesCount++;
                packCount++;
            } else if (animal instanceof Camels) {
                camelsCount++;
                packCount++;
            } else if (animal instanceof Donkeys) {
                donkeysCount++;
                packCount++;
            }
        }
        
        System.out.println("\nВыберите тип статистики:");
        System.out.println("1. Общая статистика");
        System.out.println("2. Домашние животные");
        System.out.println("3. Вьючные животные");
        System.out.println("4. Собаки");
        System.out.println("5. Кошки");
        System.out.println("6. Хомяки");
        System.out.println("7. Лошади");
        System.out.println("8. Верблюды");
        System.out.println("9. Ослы");
        
        int choice = getIntInput("Введите номер типа статистики:");
        
        switch (choice) {
            case 1:
                System.out.println("\nОбщая статистика:");
                System.out.println("Общее количество животных: " + animalCounter.getCount());
                System.out.println("Домашние животные: " + domesticCount);
                System.out.println("Вьючные животные: " + packCount);
                break;
            case 2:
                System.out.println("\nСтатистика по домашним животным:");
                System.out.println("Собаки: " + dogsCount);
                System.out.println("Кошки: " + catsCount);
                System.out.println("Хомяки: " + hamstersCount);
                System.out.println("Всего домашних животных: " + domesticCount);
                break;
            case 3:
                System.out.println("\nСтатистика по вьючным животным:");
                System.out.println("Лошади: " + horsesCount);
                System.out.println("Верблюды: " + camelsCount);
                System.out.println("Ослы: " + donkeysCount);
                System.out.println("Всего вьючных животных: " + packCount);
                break;
            case 4:
                System.out.println("\nСтатистика по собакам:");
                System.out.println("Количество собак: " + dogsCount);
                break;
            case 5:
                System.out.println("\nСтатистика по кошкам:");
                System.out.println("Количество кошек: " + catsCount);
                break;
            case 6:
                System.out.println("\nСтатистика по хомякам:");
                System.out.println("Количество хомяков: " + hamstersCount);
                break;
            case 7:
                System.out.println("\nСтатистика по лошадям:");
                System.out.println("Количество лошадей: " + horsesCount);
                break;
            case 8:
                System.out.println("\nСтатистика по верблюдам:");
                System.out.println("Количество верблюдов: " + camelsCount);
                break;
            case 9:
                System.out.println("\nСтатистика по ослам:");
                System.out.println("Количество ослов: " + donkeysCount);
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }
} 