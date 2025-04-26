package org.example.dao;

import org.example.model.Distribution;
import java.util.List;

public interface DistributionDAO {
    void addDistribution(Distribution distribution);
    Distribution getDistributionById(int id);
    List<Distribution> getAllDistributions();
    void updateDistribution(Distribution distribution);
    void deleteDistribution(int id);
}
