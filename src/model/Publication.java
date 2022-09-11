package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable<Publication> {
    private int publicationID;
    private String title;
    private String publisher;
    private int releaseDate;

    public Publication(String title, String publisher, int releaseDate) {
        this.publicationID = 0;
        this.title = title;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public int getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return releaseDate == that.releaseDate &&
                Objects.equals(title, that.title) &&
                Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publisher, releaseDate);
    }

    @Override
    public int compareTo(Publication p) {
        return title.compareToIgnoreCase(p.title);
    }
}
