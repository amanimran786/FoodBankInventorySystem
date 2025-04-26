package org.example.dao;

import org.example.model.FoodBank;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodBankDAOImpl implements FoodBankDAO {

    @Override
    public void addFoodBank(FoodBank bank) {
        String sql = "INSERT INTO Food_Bank (Name, Address, Phone_Number, Email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bank.getName());
            stmt.setString(2, bank.getAddress());
            stmt.setString(3, bank.getPhoneNumber());
            stmt.setString(4, bank.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FoodBank getFoodBankById(int id) {
        String sql = "SELECT * FROM Food_Bank WHERE Bank_ID = ?";
        FoodBank bank = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                bank = new FoodBank();
                bank.setBankId(rs.getInt("Bank_ID"));
                bank.setName(rs.getString("Name"));
                bank.setAddress(rs.getString("Address"));
                bank.setPhoneNumber(rs.getString("Phone_Number"));
                bank.setEmail(rs.getString("Email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bank;
    }

    @Override
    public List<FoodBank> getAllFoodBanks() {
        List<FoodBank> banks = new ArrayList<>();
        String sql = "SELECT * FROM Food_Bank";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                FoodBank bank = new FoodBank();
                bank.setBankId(rs.getInt("Bank_ID"));
                bank.setName(rs.getString("Name"));
                bank.setAddress(rs.getString("Address"));
                bank.setPhoneNumber(rs.getString("Phone_Number"));
                bank.setEmail(rs.getString("Email"));
                banks.add(bank);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return banks;
    }

    @Override
    public void updateFoodBank(FoodBank bank) {
        String sql = "UPDATE Food_Bank SET Name = ?, Address = ?, Phone_Number = ?, Email = ? WHERE Bank_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, bank.getName());
            stmt.setString(2, bank.getAddress());
            stmt.setString(3, bank.getPhoneNumber());
            stmt.setString(4, bank.getEmail());
            stmt.setInt(5, bank.getBankId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFoodBank(int id) {
        String sql = "DELETE FROM Food_Bank WHERE Bank_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
