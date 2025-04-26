package org.example.dao;

import org.example.model.Recipient;
import java.util.List;

public interface RecipientDAO {
    void addRecipient(Recipient recipient);
    Recipient getRecipientById(int id);
    List<Recipient> getAllRecipients();
    void updateRecipient(Recipient recipient);
    void deleteRecipient(int id);
}
