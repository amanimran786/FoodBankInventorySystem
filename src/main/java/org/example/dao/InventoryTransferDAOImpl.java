package org.example.dao;

import org.example.model.InventoryTransfer;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryTransferDAOImpl implements InventoryTransferDAO {

    @Override
    public void addTransfer(InventoryTransfer transfer) {
        String sql = "INSERT INTO Inventory_Transfer (Item_ID, Quantity, Source_Bank_ID, Destination_Bank_ID, Transfer_Date) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, transfer.getItemId());
            stmt.setInt(2, transfer.getQuantity());
            stmt.setInt(3, transfer.getSourceBankId());
            stmt.setInt(4, transfer.getDestinationBankId());
            stmt.setDate(5, new java.sql.Date(transfer.getTransferDate().getTime()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InventoryTransfer> getAllTransfers() {
        List<InventoryTransfer> transfers = new ArrayList<>();
        String sql = "SELECT * FROM Inventory_Transfer";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                InventoryTransfer transfer = new InventoryTransfer();
                transfer.setTransferId(rs.getInt("Transfer_ID"));
                transfer.setItemId(rs.getInt("Item_ID"));
                transfer.setQuantity(rs.getInt("Quantity"));
                transfer.setSourceBankId(rs.getInt("Source_Bank_ID"));
                transfer.setDestinationBankId(rs.getInt("Destination_Bank_ID"));
                transfer.setTransferDate(rs.getDate("Transfer_Date"));
                transfers.add(transfer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transfers;
    }
}
