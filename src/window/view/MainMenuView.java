package window.view;

import exception.UnknownOptionException;

public enum MainMenuView {
    VIEW_BOOK_LIST("View book list"),
    VIEW_ISSUE_BOOK_LIST("View issue book - suspended"),
    ISSUE_BOOK("Issue book - not ready"),
    RETURN_BOOK("Return book - not ready"),
    ADD_BOOK("Add book"),
    DELETE_BOOK("Delete book - not ready"),
    SEARCH_BOOK("Search book - not ready"),
    VIEW_USER_LIST("View user list - not ready"),
    ADD_USER("Add user - in progress"),
    DELETE_USER("Delete user - not ready"),
    SEARCH_USER("Search user - not ready"),
    EXIT("Close Application");
    private String details;

    MainMenuView(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return (ordinal() + 1) + ". " + details;
    }

    public static MainMenuView getFromInt(int selectedOption) {
        try {
            return MainMenuView.values()[selectedOption - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UnknownOptionException("Unknown option");
        }
    }
}
