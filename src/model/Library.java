package model;

import java.io.Serializable;

public class Library implements Serializable {
    private static final int MAX_PUBLICATIONS = 1000;
    private final Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int publicationsCounter;

    public Publication[] getPublications() {
        Publication[] publications = new Publication[publicationsCounter];
        System.arraycopy(this.publications, 0, publications, 0, publicationsCounter);
        return publications;
    }

    public int getPublicationsCounter() {
        return publicationsCounter;
    }

    public void addBook(Book book) {
        if (publicationsCounter >= MAX_PUBLICATIONS) {
            throw new ArrayIndexOutOfBoundsException("Max publications exceeded " + MAX_PUBLICATIONS);
        }
        publications[publicationsCounter] = book;
        publicationsCounter++;
    }
}
