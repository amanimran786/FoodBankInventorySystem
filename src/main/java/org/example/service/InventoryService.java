package org.example.service;

import org.example.dao.DonorDAO;
import org.example.dao.DonorDAOImpl;
import org.example.model.Donor; // FIXED

public class InventoryService {
    private DonorDAO donorDAO = new DonorDAOImpl();

    public void registerDonor(String name, String type, String email) {
        Donor donor = new Donor();
        donor.setName(name);
        donor.setType(type);
        donor.setEmail(email);
        donorDAO.addDonor(donor);
    }
}
