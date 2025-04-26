import java.util.Scanner;

public class PetManagerApp {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in, "cp866");
        
        try {
            while (true) {
                System.out.println("\nМеню:");
                System.out.println("1. Добавить новое животное");
                System.out.println("2. Показать всех животных");
                System.out.println("3. Показать команды животного");
                System.out.println("4. Обучить животное новой команде");
                System.out.println("5. Показать животных по дате рождения");
                System.out.println("6. Показать статистику животных");
                System.out.println("7. Выход");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1:
                        registry.addNewAnimal();
                        break;
                    case 2:
                        registry.printAllAnimals();
                        break;
                    case 3:
                        registry.showAnimalCommands();
                        break;
                    case 4:
                        registry.teachNewCommand();
                        break;
                    case 5:
                        registry.printAnimalsByBirthDate();
                        break;
                    case 6:
                        registry.printAnimalStatistics();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Неверный выбор!");
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}

