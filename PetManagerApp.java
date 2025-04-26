import java.util.Scanner;

public class PetManagerApp {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);
        
        try {
            while (true) {
                System.out.println("\nМеню:");
                System.out.println("1. Добавить новое животное");
                System.out.println("2. Показать всех животных");
                System.out.println("3. Выход");
                
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

