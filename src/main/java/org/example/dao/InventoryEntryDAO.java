package org.example.dao;

import org.example.model.InventoryEntry;
import java.util.List;

public interface InventoryEntryDAO {
    void addInventoryEntry(InventoryEntry entry);
    InventoryEntry getInventoryEntryById(int id);
    List<InventoryEntry> getAllInventoryEntries();
    void updateInventoryEntry(InventoryEntry entry);
    void deleteInventoryEntry(int id);
}
