package src;

import src.model.Charakteren;
import src.model.Produkten;
import src.repository.Repository;

import java.time.chrono.ThaiBuddhistEra;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Controller class handles the business logic for managing customers and products.
 * It provides methods for CRUD operations and additional functionalities like filtering and sorting.
 */
public class Controller {
    private final Repository<Charakteren> charakterenRepository;
    private final Repository<Produkten> repoProduct;

    /**
     * Constructs a Controller instance with repositories for customers and products.
     *
     * @param inMemoryRepositoryKunde   Repository for managing customers.
     * @param inMemoryRepositoryProdukt Repository for managing products.
     */
    public Controller(Repository<Charakteren> inMemoryRepositoryKunde, Repository<Produkten> inMemoryRepositoryProdukt) {
        this.charakterenRepository = inMemoryRepositoryKunde;
        this.repoProduct = inMemoryRepositoryProdukt;
    }

    /**
     * Displays all charakteren.
     */
    public void viewCharakteren() {
        System.out.println("All Customers:");
        charakterenRepository.getAll().forEach(System.out::println);
    }

    /**
     * Displays all products.
     */
    public void viewProdukte() {
        System.out.println("All Products:");
        repoProduct.getAll().forEach(System.out::println);
    }

    /**
     * Deletes a customer based on user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void deleteCharacktereen(Scanner scanner) {
        System.out.println("Enter the charakter name to delete:");
        String name = scanner.nextLine();
        charakterenRepository.delete(name);
        System.out.println("Charakter deleted.");
    }

    /**
     * Deletes a product based on user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void deleteProduct(Scanner scanner) {
        System.out.println("Enter the product name to delete:");
        String name = scanner.nextLine();
        repoProduct.delete(name);
        System.out.println("Product deleted.");
    }

    /**
     * Creates a new customer with user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void createKunde(Scanner scanner) {
        System.out.println("Enter Customer ID:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Customer Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Customer Location:");
        String herkunfsort = scanner.nextLine();

        Charakteren charakteren = new Charakteren(id, name , herkunfsort);
        charakterenRepository.create(charakteren);
        System.out.println("Customer created: " + charakteren);
    }

    /**
     * Creates a new product with user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void createProduct(Scanner scanner) {
        System.out.println("Enter Product Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Product Price:");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter Product Origin:");
        String origin = scanner.nextLine();

        Produkten produkt = new Produkten( name, price, origin);
        repoProduct.create(produkt);
        System.out.println("Product created: " + produkt);
    }

    /**
     * Retrieves a customer based on user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void getKunde(Scanner scanner) {
        System.out.println("Enter Customer ID:");
        String name = scanner.nextLine();
        Charakteren kunde = charakterenRepository.get(name);
        System.out.println(kunde != null ? "Customer found: " + kunde : "Customer not found.");
    }

    /**
     * Retrieves a product based on user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void getProduct(Scanner scanner) {
        System.out.println("Enter Product ID:");
        String name = scanner.nextLine();
        Produkten produkt = repoProduct.get(name);
        System.out.println(produkt != null ? "Product found: " + produkt : "Product not found.");
    }

    /**
     * Updates customer information based on user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void updateKunde(Scanner scanner) {
        System.out.println("Enter Customer ID to update:");
        String name = scanner.nextLine();
        Charakteren kunde = charakterenRepository.get(name);
        if (kunde != null) {
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new location:");
            String newLocation = scanner.nextLine();

            kunde.setName(newName);
            kunde.setHerkunfsort(newLocation);
            charakterenRepository.update(kunde);
            System.out.println("Customer updated: " + kunde);
        } else {
            System.out.println("Customer not found.");
        }
    }

    /**
     * Updates product information based on user input.
     *
     * @param scanner Scanner to read user input.
     */
    public void updateProduct(Scanner scanner) {
        System.out.println("Enter Product ID to update:");
        String name = scanner.nextLine();
        Produkten produkt = repoProduct.get(name);
        if (produkt != null) {
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new price:");
            double newPrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter new origin:");
            String newOrigin = scanner.nextLine();

            produkt.setName(newName);
            produkt.setPrice(newPrice);
            produkt.setHerkunftsregion(newOrigin);
            repoProduct.update(produkt);
            System.out.println("Product updated: " + produkt);
        } else {
            System.out.println("Product not found.");
        }
    }
}

