package org.example;

import org.example.service.InventoryService;
import java.util.Scanner;
import static org.example.util.ConsoleUtils.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryService inventoryService = new InventoryService();
        boolean exit = false;

        clearScreen(); // Clear console at start
        printBanner(GREEN + "Welcome to the Food Bank Inventory Management System!" + RESET, 50);

        while (!exit) {
            clearScreen(); // Clear console before showing menu
            displayMenu();  // Pretty Boxed Menu

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            clearScreen(); // Clear after input

            switch (choice) {
                case 1:
                    System.out.println(PURPLE + "--- Register Donor ---" + RESET);
                    System.out.print("Enter Donor Name: ");
                    String donorName = scanner.nextLine();
                    System.out.print("Enter Donor Type (Individual/Organization): ");
                    String donorType = scanner.nextLine();
                    System.out.print("Enter Donor Email: ");
                    String donorEmail = scanner.nextLine();
                    inventoryService.registerDonor(donorName, donorType, donorEmail);
                    showLoadingSpinner("Saving donor", 1500);
                    System.out.println(GREEN + "Donor registered successfully!" + RESET);
                    break;

                case 2:
                    System.out.println(PURPLE + "--- Register Food Item ---" + RESET);
                    System.out.print("Enter Food Item Name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Shelf Life (in days): ");
                    int shelfLife = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    inventoryService.registerFoodItem(itemName, category, shelfLife);
                    showLoadingSpinner("Saving food item", 1500);
                    System.out.println(GREEN + "Food Item registered successfully!" + RESET);
                    break;

                case 3:
                    System.out.println(CYAN + "--- All Donors ---" + RESET);
                    inventoryService.displayAllDonors();
                    break;

                case 4:
                    System.out.println(CYAN + "--- All Food Items ---" + RESET);
                    inventoryService.displayAllFoodItems();
                    break;

                case 5:
                    System.out.println(PURPLE + "--- Transfer Inventory Between Food Banks ---" + RESET);
                    System.out.print("Enter Item ID to transfer: ");
                    int transferItemId = scanner.nextInt();
                    System.out.print("Enter Source Bank ID: ");
                    int sourceBankId = scanner.nextInt();
                    System.out.print("Enter Destination Bank ID: ");
                    int destinationBankId = scanner.nextInt();
                    System.out.print("Enter Quantity to transfer: ");
                    int transferQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    inventoryService.transferInventory(transferItemId, sourceBankId, destinationBankId, transferQuantity);
                    showLoadingSpinner("Processing transfer", 2000);
                    System.out.println(GREEN + "Inventory transferred successfully!" + RESET);
                    break;

                case 6:
                    System.out.println(RED + "Exiting... Thank you!" + RESET);
                    exit = true;
                    break;

                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
            if (!exit) {
                System.out.println(YELLOW + "\nPress Enter to continue..." + RESET);
                scanner.nextLine(); // Pause before refreshing
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println(CYAN + "+-----------------------------------------------+" + RESET);
        System.out.println(CYAN + "|         Food Bank Inventory System            |" + RESET);
        System.out.println(CYAN + "+-----------------------------------------------+" + RESET);
        System.out.println(BLUE + "| 1 | Register a New Donor                      |" + RESET);
        System.out.println(BLUE + "| 2 | Register a New Food Item                  |" + RESET);
        System.out.println(BLUE + "| 3 | View All Donors                           |" + RESET);
        System.out.println(BLUE + "| 4 | View All Food Items                       |" + RESET);
        System.out.println(BLUE + "| 5 | Transfer Inventory Between Food Banks     |" + RESET);
        System.out.println(BLUE + "| 6 | Exit                                      |" + RESET);
        System.out.println(CYAN + "+-----------------------------------------------+" + RESET);
        System.out.print(YELLOW + "Choose an option: " + RESET);
    }
}
