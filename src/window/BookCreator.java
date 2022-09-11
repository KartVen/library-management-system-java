package window;

import exception.BookCreateExecption;
import model.Book;
import util.Output;
import util.ScannerReader;
import window.view.BookView;
import window.view.ViewBox;

public class BookCreator implements ViewBox {
    private final ScannerReader scanner;
    private final Output output;

    public BookCreator(ScannerReader scanner, Output outputInfo) {
        this.scanner = scanner;
        this.output = outputInfo;
    }

    public Book inputAndGet() {
        try {
            output.print(BookView.TITLE.getDetails());
            String title = scanner.nextLine();

            output.print(BookView.AUTHOR.getDetails());
            String author = scanner.nextLine();

            output.print(BookView.PUBLISHER.getDetails());
            String publisher = scanner.nextLine();

            output.print(BookView.RELEASE_DATE.getDetails());
            int releaseDate = scanner.nextInt();

            output.print(BookView.PAGES.getDetails());
            int pages = scanner.nextInt();

            output.print(BookView.ISBN.getDetails());
            String isbn = scanner.nextLine();

            return new Book(title, author, publisher, releaseDate, pages, isbn);
        } catch (Exception e){
            throw new BookCreateExecption("Book creating error");
        }
    }
}
