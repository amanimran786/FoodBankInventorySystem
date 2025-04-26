package org.example.dao;

import org.example.model.FoodItem;
import java.util.List;

public interface FoodItemDAO {
    void addFoodItem(FoodItem item);
    FoodItem getFoodItemById(int id);
    List<FoodItem> getAllFoodItems();
    void updateFoodItem(FoodItem item);
    void deleteFoodItem(int id);
}
