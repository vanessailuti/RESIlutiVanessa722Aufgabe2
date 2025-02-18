package src;

import src.model.Charakteren;
import src.model.Produkten;
import src.repository.InMemoryRepository;
import src.repository.Repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 * The ConsoleApp class represents the user interface for managing the Game of Thrones trading network.
 * It allows users to perform CRUD operations on customers and products through a console-based menu.
 */
public class ConsoleApp {
    private final Controller controller;

    /**
     * Constructs a ConsoleApp instance with the specified controller.
     *
     * @param controller The controller responsible for handling business logic.
     */
    public ConsoleApp(Controller controller) {
        this.controller = controller;
    }

    /**
     * Starts the console application, displaying a menu and handling user input.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("""
                    Select an option:
                    1. Get all charakteren
                    2. Get all products
                    3. Delete charakteren
                    4. Delete product
                    5. Add charaketeren
                    6. Add product
                    7. Update charakteren
                    8. Update product
                    9. Get charakteren
                    10. Get product
                    11. Filter by location
                    12. Filter by product origin
                    13. Sort products by price
                    0. Exit
                    """);
            String option = scanner.nextLine();

            switch (option) {
                case "0" -> continueLoop = false;
                case "1" -> controller.viewCharakteren();
                case "2" -> controller.viewProdukte();
                case "3" -> controller.deleteCharakteren(scanner);
                case "4" -> controller.deleteProduct(scanner);
                case "5" -> controller.createKunde(scanner);
                case "6" -> controller.createProduct(scanner);
                case "7" -> controller.updateKunde(scanner);
                case "8" -> controller.updateProduct(scanner);
                case "9" -> controller.getKunde(scanner);
                case "10" -> controller.getProduct(scanner);
                /*case "11" -> controller.filterCustomer(scanner);
                case "12" -> controller.filterCustomerByProduct(scanner);
                case "13" -> controller.sortByUser(scanner);
                default -> System.out.println("Invalid option, please try again."); */
            }
        }
    }

    /**
     * Main entry point of the application.
     * Initializes in-memory repositories, creates a controller, and starts the console application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Repository<Charakteren> charakterenRepository = createInMemoryKundenRepository();
        Repository<Produkten> produktRepo = createInMemoryProduktRepository();

        Controller controller = new Controller(charakterenRepository, produktRepo);
        ConsoleApp consoleApp = new ConsoleApp(controller);
        consoleApp.start();

    }


    private static Repository<Charakteren> createInMemoryKundenRepository() {
        Repository<Charakteren> charakterenRepository = new InMemoryRepository<>();

        charakterenRepository.create(new Charakteren( 1,
                "Naruto Uzumaki"
                ,
                "Konoha"));
        charakterenRepository.create(new Charakteren(2,
                "Naruto Uzumaki"
                ,
                "Konoha"));
        charakterenRepository.create(new Charakteren(3,
                "Kisame Hoshigaki"
                ,
                "Kirigakure"))
        ;

        return charakterenRepository;
    }

    /**
     * Creates an in-memory repository for products and populates it with initial data.
     *
     * @return A repository containing predefined products.
     */
    private static Repository<Produkten> createInMemoryProduktRepository() {
        Repository<Produkten> produktRepo = new InMemoryRepository<>();
        produktRepo.create(new Produkten("Kunai"
                , 50.0,
                "Konoha"));
        produktRepo.create(new Produkten("Shuriken"
                , 30.0,
                "Konoha"));
        produktRepo.create(new Produkten("Schwert"
                , 200.0,
                "Kirigakure"));
        return produktRepo;
    }
}
