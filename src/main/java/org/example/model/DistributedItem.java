package org.example.model;

public class DistributedItem {
    private int distributionId;
    private int itemId;
    private int quantityGiven;

    public int getDistributionId() {
        return distributionId;
    }

    public void setDistributionId(int distributionId) {
        this.distributionId = distributionId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantityGiven() {
        return quantityGiven;
    }

    public void setQuantityGiven(int quantityGiven) {
        this.quantityGiven = quantityGiven;
    }
}
