package model;

import java.util.Objects;

public class Book extends Publication {
    private String author;
    private int pages;
    private String ISBN;

    public Book(String title, String author, String publisher, int releaseDate, int pages, String ISBN) {
        super(title, publisher, releaseDate);
        this.author = author;
        this.pages = pages;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", releaseDate=" + getReleaseDate() +
                ", pages=" + pages +
                ", isbn='" + ISBN + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, ISBN);
    }
}
