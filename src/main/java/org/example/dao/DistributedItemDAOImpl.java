package org.example.dao;

import org.example.model.DistributedItem;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistributedItemDAOImpl implements DistributedItemDAO {

    @Override
    public void addDistributedItem(DistributedItem item) {
        String sql = "INSERT INTO Distributed_Item (Distribution_ID, Item_ID, Quantity_Given) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, item.getDistributionId());
            stmt.setInt(2, item.getItemId());
            stmt.setInt(3, item.getQuantityGiven());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DistributedItem> getItemsByDistributionId(int distributionId) {
        List<DistributedItem> items = new ArrayList<>();
        String sql = "SELECT * FROM Distributed_Item WHERE Distribution_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, distributionId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DistributedItem item = new DistributedItem();
                item.setDistributionId(rs.getInt("Distribution_ID"));
                item.setItemId(rs.getInt("Item_ID"));
                item.setQuantityGiven(rs.getInt("Quantity_Given"));
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public void deleteDistributedItem(int distributionId, int itemId) {
        String sql = "DELETE FROM Distributed_Item WHERE Distribution_ID = ? AND Item_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, distributionId);
            stmt.setInt(2, itemId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
