package org.example.dao;

import org.example.model.FoodItem;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodItemDAOImpl implements FoodItemDAO {

    @Override
    public void addFoodItem(FoodItem item) {
        String sql = "INSERT INTO Food_Item (Item_Name, Category, Shelf_Life_Days) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getCategory());
            stmt.setInt(3, item.getShelfLifeDays());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FoodItem getFoodItemById(int id) {
        String sql = "SELECT * FROM Food_Item WHERE Item_ID = ?";
        FoodItem item = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                item = new FoodItem();
                item.setItemId(rs.getInt("Item_ID"));
                item.setItemName(rs.getString("Item_Name"));
                item.setCategory(rs.getString("Category"));
                item.setShelfLifeDays(rs.getInt("Shelf_Life_Days"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> items = new ArrayList<>();
        String sql = "SELECT * FROM Food_Item";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                FoodItem item = new FoodItem();
                item.setItemId(rs.getInt("Item_ID"));
                item.setItemName(rs.getString("Item_Name"));
                item.setCategory(rs.getString("Category"));
                item.setShelfLifeDays(rs.getInt("Shelf_Life_Days"));
                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public void updateFoodItem(FoodItem item) {
        String sql = "UPDATE Food_Item SET Item_Name = ?, Category = ?, Shelf_Life_Days = ? WHERE Item_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getCategory());
            stmt.setInt(3, item.getShelfLifeDays());
            stmt.setInt(4, item.getItemId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFoodItem(int id) {
        String sql = "DELETE FROM Food_Item WHERE Item_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
