package org.example.dao;

import org.example.model.Recipient;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipientDAOImpl implements RecipientDAO {

    @Override
    public void addRecipient(Recipient recipient) {
        String sql = "INSERT INTO Recipient (Name) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recipient.getName());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Recipient getRecipientById(int id) {
        String sql = "SELECT * FROM Recipient WHERE Recipient_ID = ?";
        Recipient recipient = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                recipient = new Recipient();
                recipient.setRecipientId(rs.getInt("Recipient_ID"));
                recipient.setName(rs.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipient;
    }

    @Override
    public List<Recipient> getAllRecipients() {
        List<Recipient> recipients = new ArrayList<>();
        String sql = "SELECT * FROM Recipient";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Recipient recipient = new Recipient();
                recipient.setRecipientId(rs.getInt("Recipient_ID"));
                recipient.setName(rs.getString("Name"));
                recipients.add(recipient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipients;
    }

    @Override
    public void updateRecipient(Recipient recipient) {
        String sql = "UPDATE Recipient SET Name = ? WHERE Recipient_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recipient.getName());
            stmt.setInt(2, recipient.getRecipientId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRecipient(int id) {
        String sql = "DELETE FROM Recipient WHERE Recipient_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
