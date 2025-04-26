package org.example.model;

import java.util.Date;

public class InventoryTransfer {
    private int transferId;
    private int itemId;
    private int quantity;
    private int sourceBankId;
    private int destinationBankId;
    private Date transferDate;

    // Getters and setters
    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSourceBankId() {
        return sourceBankId;
    }

    public void setSourceBankId(int sourceBankId) {
        this.sourceBankId = sourceBankId;
    }

    public int getDestinationBankId() {
        return destinationBankId;
    }

    public void setDestinationBankId(int destinationBankId) {
        this.destinationBankId = destinationBankId;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
}
