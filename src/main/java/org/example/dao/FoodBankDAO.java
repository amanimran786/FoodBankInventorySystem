package org.example.dao;

import org.example.model.FoodBank;
import java.util.List;

public interface FoodBankDAO {
    void addFoodBank(FoodBank bank);
    FoodBank getFoodBankById(int id);
    List<FoodBank> getAllFoodBanks();
    void updateFoodBank(FoodBank bank);
    void deleteFoodBank(int id);
}
