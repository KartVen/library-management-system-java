package window.view;

import exception.UnknownOptionException;

public enum MainMenu {
    VIEW_BOOK_LIST(1, "View Book list"),
    ADD_BOOK(2, "Add book"),
    DELETE_BOOK(3, "Delete book - in progress"),
    SEARCH_BOOK(4, "Search book - in progress"),
    ISSUE_BOOK(5, "Issue book - in progress"),
    RETURN_BOOK(6, "Return book - in progress"),
    EXIT(7, "Close Application");

    private int value;
    private String details;

    MainMenu(int value, String details) {
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

    public static MainMenu getFromInt(int selectedOption) {
        try {
            return MainMenu.values()[selectedOption - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnknownOptionException("Unknown option");
        }
    }
}
