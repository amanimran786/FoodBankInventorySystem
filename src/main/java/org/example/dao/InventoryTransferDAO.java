package org.example.dao;

import org.example.model.InventoryTransfer;
import java.util.List;

public interface InventoryTransferDAO {
    void addTransfer(InventoryTransfer transfer);
    List<InventoryTransfer> getAllTransfers();
}
