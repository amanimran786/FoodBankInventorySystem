package org.example.dao;

import org.example.model.DistributedItem;
import java.util.List;

public interface DistributedItemDAO {
    void addDistributedItem(DistributedItem item);
    List<DistributedItem> getItemsByDistributionId(int distributionId);
    void deleteDistributedItem(int distributionId, int itemId);
}
