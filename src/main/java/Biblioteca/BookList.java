package Biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class BookList {

    private Collection<Book> books;
    private PrintStream printStream;
    private String successMessage;
    private String failureMessage;

    public BookList(PrintStream printStream, String successMessage, String failureMessage) {
        this.printStream = printStream;
        this.successMessage = successMessage;
        this.failureMessage = failureMessage;
        this.books = new ArrayList<Book>();
    }

    public boolean containsBook(String title) {
        for (Book bookChoice : books){
            if(bookChoice.thisIsMyTitle(title))
                return true;
        }
        return false;
    }


    public void printBookList() {
        if (books.isEmpty()) {
            printStream.println("There are no books.");
        }

        for (Book book : books) {
            book.printBookDetails();
        }
    }

    public void addBook(Book book){
        books.add(book);
    }


    public Book removeBook(String title) {
        for (Book bookChoice : books){
            if (bookChoice.thisIsMyTitle(title)){
                books.remove(bookChoice);

                return bookChoice;
            }
        }

        return null;
    }

    public void printSuccessMessage() {
        printStream.println(successMessage);
    }

    public void printFailureMessage() {
        printStream.println(failureMessage);
    }

    public void moveBook(String title, BookList toBookList) {
        if(this.containsBook(title)) {
            Book bookToCheckIn = removeBook(title);
            toBookList.addBook(bookToCheckIn);
            toBookList.printSuccessMessage();
        } else
            toBookList.printFailureMessage();
    }
}
