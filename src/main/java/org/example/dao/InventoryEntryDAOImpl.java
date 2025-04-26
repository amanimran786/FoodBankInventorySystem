package org.example.dao;

import org.example.model.InventoryEntry;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryEntryDAOImpl implements InventoryEntryDAO {

    @Override
    public void addInventoryEntry(InventoryEntry entry) {
        String sql = "INSERT INTO Inventory_Entry (Item_ID, Donor_ID, Quantity, Date_Received, Expiration_Date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, entry.getItemId());
            stmt.setInt(2, entry.getDonorId());
            stmt.setInt(3, entry.getQuantity());
            stmt.setDate(4, new java.sql.Date(entry.getDateReceived().getTime()));
            stmt.setDate(5, new java.sql.Date(entry.getExpirationDate().getTime()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InventoryEntry getInventoryEntryById(int id) {
        String sql = "SELECT * FROM Inventory_Entry WHERE Inventory_ID = ?";
        InventoryEntry entry = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                entry = new InventoryEntry();
                entry.setInventoryId(rs.getInt("Inventory_ID"));
                entry.setItemId(rs.getInt("Item_ID"));
                entry.setDonorId(rs.getInt("Donor_ID"));
                entry.setQuantity(rs.getInt("Quantity"));
                entry.setDateReceived(rs.getDate("Date_Received"));
                entry.setExpirationDate(rs.getDate("Expiration_Date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entry;
    }

    @Override
    public List<InventoryEntry> getAllInventoryEntries() {
        List<InventoryEntry> entries = new ArrayList<>();
        String sql = "SELECT * FROM Inventory_Entry";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                InventoryEntry entry = new InventoryEntry();
                entry.setInventoryId(rs.getInt("Inventory_ID"));
                entry.setItemId(rs.getInt("Item_ID"));
                entry.setDonorId(rs.getInt("Donor_ID"));
                entry.setQuantity(rs.getInt("Quantity"));
                entry.setDateReceived(rs.getDate("Date_Received"));
                entry.setExpirationDate(rs.getDate("Expiration_Date"));
                entries.add(entry);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entries;
    }

    @Override
    public void updateInventoryEntry(InventoryEntry entry) {
        String sql = "UPDATE Inventory_Entry SET Item_ID = ?, Donor_ID = ?, Quantity = ?, Date_Received = ?, Expiration_Date = ? WHERE Inventory_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, entry.getItemId());
            stmt.setInt(2, entry.getDonorId());
            stmt.setInt(3, entry.getQuantity());
            stmt.setDate(4, new java.sql.Date(entry.getDateReceived().getTime()));
            stmt.setDate(5, new java.sql.Date(entry.getExpirationDate().getTime()));
            stmt.setInt(6, entry.getInventoryId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventoryEntry(int id) {
        String sql = "DELETE FROM Inventory_Entry WHERE Inventory_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
