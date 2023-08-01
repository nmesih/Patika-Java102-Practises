package PatikaStore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PatikaStore patikaStore = new PatikaStore();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- PatikaStore Product Management ---");
            System.out.println("1. List Products by Category");
            System.out.println("2. Add New Product");
            System.out.println("3. Delete Product by ID");
            System.out.println("4. List Products by Brand");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the category (Cep Telefonu / Notebook): ");
                    scanner.nextLine(); // Consume the newline character after nextInt()
                    String category = scanner.nextLine();
                    patikaStore.listProductsByCategory(category);
                    break;
                case 2:
                    System.out.print("Enter the category (Cep Telefonu / Notebook): ");
                    scanner.nextLine();
                    category = scanner.nextLine();
                    System.out.print("Enter the price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter the discount rate (0.0 to 1.0): ");
                    double discountRate = scanner.nextDouble();
                    System.out.print("Enter the stock: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter the product name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.print("Enter the brand ID: ");
                    int brandId = scanner.nextInt();
                    patikaStore.addProduct(category, price, discountRate, stock, name, brandId);
                    break;
                case 3:
                    System.out.print("Enter the product ID to delete: ");
                    int productId = scanner.nextInt();
                    patikaStore.deleteProduct(productId);
                    break;
                case 4:
                    System.out.print("Enter the brand ID to list products: ");
                    int brandIdToFilter = scanner.nextInt();
                    patikaStore.listProductsByBrand(brandIdToFilter);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
