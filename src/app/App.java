package app;

import exception.BookCreateExecption;
import exception.ExportDataException;
import exception.ImportDataException;
import exception.UnknownOptionException;
import model.Book;
import model.Library;
import model.Publication;
import util.*;
import window.BookCreator;
import window.MainCreator;
import window.view.Creator;
import window.view.MainMenu;


import java.util.Arrays;
import java.util.InputMismatchException;

public class App {
    private final String appDetails;
    private final ScannerReader scanner;
    private final Output output;
    private final FileIO fileIO;

    private Library library;

    private MainCreator mainCreator;

    public App(String appDetails) {
        this.appDetails = appDetails;
        this.scanner = new ScannerReader();
        this.output = new SystemOutput();

        fileIO = new SerializableFileIO();
        try {
            this.library = fileIO.read();
        } catch (ImportDataException e) {
            output.println(e.getMessage());
            output.println("Created a new base...");
            this.library = new Library();
        }

        this.mainCreator = new MainCreator(appDetails, scanner, output);
    }

    public void loop() {
        MainMenu selectedOption;

        do {
            showMainMenu();
            selectedOption = getSelectedOption();

            switch (selectedOption) {
                case VIEW_BOOK_LIST:
                    viewBookMode();
                    break;
                case ADD_BOOK:
                    addBookMode();
                    break;
                case DELETE_BOOK:
                    break;
                case EXIT:
                    exitMode();
            }
        } while (selectedOption != MainMenu.EXIT);
    }

    private void showMainMenu() {
        mainCreator.showView();
    }

    private MainMenu getSelectedOption() {
        MainMenu selectedOption = null;
        boolean correctOption = false;

        do {
            try {
                output.print("Enter your choice: ");
                selectedOption = MainMenu.getFromInt(scanner.nextInt());
                correctOption = true;
            } catch (UnknownOptionException | InputMismatchException e) {
                output.clear();
                showMainMenu();
                output.println("Wrong entry! Please re-enter the correct option");
            }
        } while (!correctOption);

        return selectedOption;
    }

    private void viewBookMode() {
        final int columnSize = 20;
        final String tableFormat = ("%-" + columnSize + "." + columnSize + "s ").repeat(6);
        output.println(tableFormat.formatted(
                Arrays.stream(Creator.values()).map(Creator::getDetails).toArray()
        ));

        Publication[] publications = library.getPublications();
        for (Publication publication : publications) {
            if (publication instanceof Book book) {
                output.println(tableFormat.formatted(
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublisher(),
                        book.getReleaseDate(),
                        book.getPages(),
                        book.getISBN()
                ));
            }
        }
        if (publications.length == 0)
            output.println("Data not available");

        output.nextLine();
        output.println("Press any button to continue...");
        scanner.nextAnyButton();
    }

    private void addBookMode() {
        BookCreator bookCreator = new BookCreator(scanner, output);
        try {
            Book book = bookCreator.inputAndGet();
            library.addBook(book);
        } catch (BookCreateExecption e) {
            output.nextLine();
            output.println("The attempt to add a book has failed");
            output.println("Press any button to back...");
            scanner.nextAnyButton();
        }
    }

    private void exitMode() {
        scanner.close();
        output.println("Saving session...");
        try {
            fileIO.save(library);
            Thread.sleep(1000);
        } catch (ExportDataException e) {
            output.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        output.println("Closing application...");
    }
}
