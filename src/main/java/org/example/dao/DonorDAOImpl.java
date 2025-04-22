package org.example.dao;

import org.example.model.Donor;
import org.example.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonorDAOImpl implements DonorDAO {

    @Override
    public void addDonor(Donor donor) {
        String sql = "INSERT INTO Donor (Name, Type, email) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, donor.getName());
            stmt.setString(2, donor.getType());
            stmt.setString(3, donor.getEmail());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Donor getDonorById(int id) {
        String sql = "SELECT * FROM Donor WHERE DonorID = ?";
        Donor donor = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                donor = new Donor();
                donor.setDonorId(rs.getInt("DonorID"));
                donor.setName(rs.getString("Name"));
                donor.setType(rs.getString("Type"));
                donor.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donor;
    }

    @Override
    public List<Donor> getAllDonors() {
        List<Donor> donors = new ArrayList<>();
        String sql = "SELECT * FROM Donor";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Donor donor = new Donor();
                donor.setDonorId(rs.getInt("DonorID"));
                donor.setName(rs.getString("Name"));
                donor.setType(rs.getString("Type"));
                donor.setEmail(rs.getString("email"));
                donors.add(donor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return donors;
    }

    @Override
    public void updateDonor(Donor donor) {
        String sql = "UPDATE Donor SET Name = ?, Type = ?, email = ? WHERE DonorID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, donor.getName());
            stmt.setString(2, donor.getType());
            stmt.setString(3, donor.getEmail());
            stmt.setInt(4, donor.getDonorId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDonor(int id) {
        String sql = "DELETE FROM Donor WHERE DonorID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
