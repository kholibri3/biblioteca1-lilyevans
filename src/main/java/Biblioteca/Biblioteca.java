package Biblioteca;

import java.io.PrintStream;

public class Biblioteca {

    private BookList availableBookList;
    private BookList checkedOutBookList;


    public Biblioteca(BookList availableBookList, BookList checkedOutBookList){
        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
    }

    public void printAvailableBooks() {
        availableBookList.printBookList();
    }

    public void checkOutBook(String title) {
        availableBookList.moveBook(title, checkedOutBookList);
    }

    public void checkInBook(String title) {
        checkedOutBookList.moveBook(title, availableBookList);
    }

}
