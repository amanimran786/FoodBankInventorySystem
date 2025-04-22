package org.example.dao;

import org.example.model.Donor; // FIXED

import java.util.List;

public interface DonorDAO {
    void addDonor(Donor donor);
    Donor getDonorById(int id);
    List<Donor> getAllDonors();
    void updateDonor(Donor donor);
    void deleteDonor(int id);
}
