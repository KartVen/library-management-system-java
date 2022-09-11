package model;

import exception.UserAlreadyExistsException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<Integer, Publication> publications;
    private int publicationLastID;

    private final ClientsMap clients;

    public Library() {
        this.publications = new HashMap<>();
        this.publicationLastID = -1;
        this.clients = new ClientsMap();
    }

    public Map<Integer, Publication> getPublications() {
        return publications;
    }

    public ClientsMap getClients() {
        return clients;
    }

    public void addUser(Client client) {

    }

    public void addBook(Book book) {
        if (publications.isEmpty()) this.publicationLastID = 0;
        if (publicationLastID == -1 ) this.publicationLastID = Collections.max(publications.keySet());
        book.setPublicationID(++publicationLastID);
        publications.put(publicationLastID, book);
    }

    public boolean removeBook(Book book) {
        if (publications.containsValue(book) && book.getPublicationID() != 0) {
            publications.remove(book.getPublicationID());
            return true;
        } else {
            return false;
        }
    }
}
