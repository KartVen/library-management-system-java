package window.view;

public enum BookView {
    ID("ID: "),
    TITLE("Title: "),
    AUTHOR("Author: "),
    PUBLISHER("Publisher: "),
    RELEASE_DATE("Release date: "),
    PAGES("Pages: "),
    ISBN("ISBN: ");
    private String details;

    BookView(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return (ordinal() + 1) + ". " + details;
    }
}
