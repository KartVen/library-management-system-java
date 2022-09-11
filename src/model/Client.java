package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client extends User {
    private List<Publication> borrowedPublicationsHistory = new ArrayList<>();
    private List<Publication> borrowedPublications = new ArrayList<>();

    public Client(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }

    public void borrowPublication(Publication pub) {
        borrowedPublications.add(pub);
    }

    public boolean returnPublication(Publication pub) {
        boolean removeOk = false;
        if (borrowedPublications.remove(pub)) {
            borrowedPublicationsHistory.add(pub);
            removeOk = true;
        }
        return removeOk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(borrowedPublicationsHistory, client.borrowedPublicationsHistory) && Objects.equals(borrowedPublications, client.borrowedPublications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), borrowedPublicationsHistory, borrowedPublications);
    }
}
