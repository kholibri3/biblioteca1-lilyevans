package Biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String [] args) throws IOException{
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MediaItemList checkedOutBooks = new MediaItemList(printStream, "Thank you! Enjoy the book.", "That book is not available.");
        MediaItemList availableBooks = initializeAvailableBookList(printStream);

        MediaItemList checkedOutMovies = new MediaItemList(printStream, "Thank you! Enjoy the movie.", "That movie is not available.");
        MediaItemList availableMovies = initializeAvailableMovieList(printStream);

        Biblioteca biblioteca = new Biblioteca(availableBooks, checkedOutBooks, availableMovies, checkedOutMovies);

        Menu menu = new Menu(printStream, reader, biblioteca);
        menu.run();
    }

    private static MediaItemList initializeAvailableBookList(PrintStream printStream) {
        BookDetails hp1 = new BookDetails("JK Row", "1997");
        BookDetails hp2 = new BookDetails("JK Row", "1997");
        BookDetails hp3 = new BookDetails("JK Row", "1997");
        MediaItem hp1Book = new MediaItem("HP 1", hp1);
        MediaItem hp2Book = new MediaItem("HP 2", hp2);
        MediaItem hp3Book = new MediaItem("HP 3", hp3);

        MediaItemList availableBooks = new MediaItemList(printStream, "Thank you for returning the book.", "That is not a valid book to return.");

        availableBooks.addItem(hp1Book);
        availableBooks.addItem(hp2Book);
        availableBooks.addItem(hp3Book);
        return availableBooks;
    }

    private static MediaItemList initializeAvailableMovieList(PrintStream printStream) {
        BookDetails hp1 = new BookDetails("JK Row", "1997");
        BookDetails hp2 = new BookDetails("JK Row", "1997");
        BookDetails hp3 = new BookDetails("JK Row", "1997");
        MediaItem hp1Book = new MediaItem("HP 1", hp1);
        MediaItem hp2Book = new MediaItem("HP 2", hp2);
        MediaItem hp3Book = new MediaItem("HP 3", hp3);

        MediaItemList availableBooks = new MediaItemList(printStream, "Thank you for returning the movie.", "That is not a valid movie to return.");

        availableBooks.addItem(hp1Book);
        availableBooks.addItem(hp2Book);
        availableBooks.addItem(hp3Book);
        return availableBooks;
    }

}
