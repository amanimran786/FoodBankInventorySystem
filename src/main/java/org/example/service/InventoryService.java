package org.example.service;

import org.example.dao.*;
import org.example.model.*;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.Date;
import java.util.List;

import static org.example.util.ConsoleUtils.*;

public class InventoryService {

    private final DonorDAO donorDAO = new DonorDAOImpl();
    private final FoodItemDAO foodItemDAO = new FoodItemDAOImpl();
    private final InventoryTransferDAO inventoryTransferDAO = new InventoryTransferDAOImpl();

    // --- Donor Operations ---
    public void registerDonor(String name, String type, String email) {
        Donor donor = new Donor();
        donor.setName(name);
        donor.setType(type);
        donor.setEmail(email);
        donorDAO.addDonor(donor);
    }

    public void displayAllDonors() {
        List<Donor> donors = donorDAO.getAllDonors();
        if (donors.isEmpty()) {
            System.out.println("No donors found.");
        } else {
            for (Donor donor : donors) {
                System.out.println("ID: " + donor.getDonorId() +
                        ", Name: " + donor.getName() +
                        ", Type: " + donor.getType() +
                        ", Email: " + donor.getEmail());
            }
        }
    }

    // --- Food Item Operations ---
    public void registerFoodItem(String name, String category, int shelfLifeDays) {
        FoodItem item = new FoodItem();
        item.setItemName(name);
        item.setCategory(category);
        item.setShelfLifeDays(shelfLifeDays);
        foodItemDAO.addFoodItem(item);
    }

    public void displayAllFoodItems() {
        List<FoodItem> items = foodItemDAO.getAllFoodItems();
        if (items.isEmpty()) {
            System.out.println("No food items found.");
        } else {
            for (FoodItem item : items) {
                System.out.println("ID: " + item.getItemId() +
                        ", Name: " + item.getItemName() +
                        ", Category: " + item.getCategory() +
                        ", Shelf Life (days): " + item.getShelfLifeDays());
            }
        }
    }

    // --- Inventory Transfer Operations (REAL STOCK MOVEMENT) ---
    public void transferInventory(int itemId, int sourceBankId, int destinationBankId, int quantity) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // Start Transaction

            // 1. Decrease quantity from source
            String decreaseSql = "UPDATE Inventory_Entry SET Quantity = Quantity - ? WHERE Item_ID = ? AND Bank_ID = ? AND Quantity >= ?";
            try (PreparedStatement decreaseStmt = conn.prepareStatement(decreaseSql)) {
                decreaseStmt.setInt(1, quantity);
                decreaseStmt.setInt(2, itemId);
                decreaseStmt.setInt(3, sourceBankId);
                decreaseStmt.setInt(4, quantity);

                int updated = decreaseStmt.executeUpdate();
                if (updated == 0) {
                    conn.rollback();
                    System.out.println(RED + "Not enough inventory to transfer from source bank!" + RESET);
                    return;
                }
            }

            // 2. Increase quantity at destination
            String selectSql = "SELECT Inventory_ID FROM Inventory_Entry WHERE Item_ID = ? AND Bank_ID = ?";
            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                selectStmt.setInt(1, itemId);
                selectStmt.setInt(2, destinationBankId);

                ResultSet rs = selectStmt.executeQuery();
                if (rs.next()) {
                    // Inventory exists at destination — update quantity
                    int inventoryId = rs.getInt("Inventory_ID");
                    String increaseSql = "UPDATE Inventory_Entry SET Quantity = Quantity + ? WHERE Inventory_ID = ?";
                    try (PreparedStatement increaseStmt = conn.prepareStatement(increaseSql)) {
                        increaseStmt.setInt(1, quantity);
                        increaseStmt.setInt(2, inventoryId);
                        increaseStmt.executeUpdate();
                    }
                } else {
                    // Inventory doesn't exist at destination — create new entry
                    String insertSql = "INSERT INTO Inventory_Entry (Item_ID, Donor_ID, Quantity, Date_Received, Expiration_Date, Bank_ID) VALUES (?, NULL, ?, CURDATE(), NULL, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                        insertStmt.setInt(1, itemId);
                        insertStmt.setInt(2, quantity);
                        insertStmt.setInt(3, destinationBankId);
                        insertStmt.executeUpdate();
                    }
                }
            }

            // 3. Record transfer
            InventoryTransfer transfer = new InventoryTransfer();
            transfer.setItemId(itemId);
            transfer.setQuantity(quantity);
            transfer.setSourceBankId(sourceBankId);
            transfer.setDestinationBankId(destinationBankId);
            transfer.setTransferDate(new Date());

            inventoryTransferDAO.addTransfer(transfer);

            conn.commit(); // Confirm all changes
            System.out.println(GREEN + "Inventory transfer completed successfully!" + RESET);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(RED + "Error during transfer. Rolling back transaction." + RESET);
        }
    }
}
