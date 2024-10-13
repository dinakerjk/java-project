package product;

import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
       inventory inventory = new inventory();
      shop cs = new shop();
        user user = new user();
        int choice;

        while (true) {

            System.out.println("Welcome to Coffee Shop Inventory");

            System.out.print("ADMIN: ");
            user.setName(scanner.nextLine());

            System.out.print("PASSWORD: ");
            user.setPass(scanner.nextLine());

            if (user.getName().equals("dinaker") && user.getPass().equals("dinaker05")) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        System.out.println("1. Add");
        System.out.println("2. Update");
        System.out.println("3. Remove");
        System.out.println("4. Search by Brand");
        System.out.println("5. Show All");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Id: ");
                cs.setId(scanner.nextInt());
                scanner.nextLine();

                System.out.println("Enter brand: ");
                cs.setBrand(scanner.nextLine());

                System.out.print("Enter coffee name: ");
                cs.setCoffeeName(scanner.nextLine());

                System.out.print("Enter price: ");
                cs.setPrice(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Enter Reviews: ");
                cs.setReviews(scanner.nextLine());

                inventory.addProduct(cs);
                break;

            case 2:
                System.out.println("Enter ID to Update the coffee:");
                int coffeeIdUpdate = scanner.nextInt();
                cs.setId(coffeeIdUpdate);

                System.out.println("Enter the records to update");
                scanner.nextLine();

                System.out.print("Enter coffee name: ");
                cs.setCoffeeName(scanner.nextLine());

                System.out.print("Enter price: ");
                cs.setPrice(scanner.nextInt());
                scanner.nextLine();

                inventory.updateProduct(cs);
                break;

            case 3:
                System.out.println("Enter ID to delete the coffee:");
                int coffeeIdDelete = scanner.nextInt();
                inventory.removeProduct(coffeeIdDelete);
                break;

            case 4:
                System.out.print("Enter coffee brand to search: ");
                String searchBrand = scanner.nextLine();
              shop foundProduct = inventory.findBrand(searchBrand);
                if (foundProduct != null) {
                    System.out.println("Coffee found:");
                    System.out.println(foundProduct);
                } else {
                    System.out.println("Coffee not found.");
                }
                break;

            case 5:
                System.out.println("All coffees in inventory:");
                inventory.showAllProducts();
                break;

            case 6:
                System.out.println("Exiting program...");
                break;

            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
        }

        while (choice != 6);
        scanner.close();
    }
}
