package window.view;

public enum Creator {
    TITLE(1, "Title: "),
    AUTHOR(2, "Author: "),
    PUBLISHER(3, "Publisher: "),
    RELEASE_DATE(4, "Release date: "),
    PAGES(5, "Pages: "),
    ISBN(6, "ISBN: ");
    private int value;
    private String details;

    Creator(int value, String details) {
        this.value = value;
        this.details = details;
    }

    public int getValue() {
        return value;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return value + ". " + details;
    }
}
