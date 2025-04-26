package org.example.dao;

import org.example.model.Distribution;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistributionDAOImpl implements DistributionDAO {

    @Override
    public void addDistribution(Distribution distribution) {
        String sql = "INSERT INTO Distribution (Recipient_ID, Bank_ID, Distribution_Date) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, distribution.getRecipientId());
            stmt.setInt(2, distribution.getBankId());
            stmt.setDate(3, new java.sql.Date(distribution.getDistributionDate().getTime()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Distribution getDistributionById(int id) {
        String sql = "SELECT * FROM Distribution WHERE Distribution_ID = ?";
        Distribution distribution = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                distribution = new Distribution();
                distribution.setDistributionId(rs.getInt("Distribution_ID"));
                distribution.setRecipientId(rs.getInt("Recipient_ID"));
                distribution.setBankId(rs.getInt("Bank_ID"));
                distribution.setDistributionDate(rs.getDate("Distribution_Date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return distribution;
    }

    @Override
    public List<Distribution> getAllDistributions() {
        List<Distribution> distributions = new ArrayList<>();
        String sql = "SELECT * FROM Distribution";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Distribution distribution = new Distribution();
                distribution.setDistributionId(rs.getInt("Distribution_ID"));
                distribution.setRecipientId(rs.getInt("Recipient_ID"));
                distribution.setBankId(rs.getInt("Bank_ID"));
                distribution.setDistributionDate(rs.getDate("Distribution_Date"));
                distributions.add(distribution);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return distributions;
    }

    @Override
    public void updateDistribution(Distribution distribution) {
        String sql = "UPDATE Distribution SET Recipient_ID = ?, Bank_ID = ?, Distribution_Date = ? WHERE Distribution_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, distribution.getRecipientId());
            stmt.setInt(2, distribution.getBankId());
            stmt.setDate(3, new java.sql.Date(distribution.getDistributionDate().getTime()));
            stmt.setInt(4, distribution.getDistributionId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDistribution(int id) {
        String sql = "DELETE FROM Distribution WHERE Distribution_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
