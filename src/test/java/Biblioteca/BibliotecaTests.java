package Biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

public class BibliotecaTests {
    private PrintStream printStream;
    private Book book1;
    private Book book2;
    private Biblioteca biblioteca;
    private BookList availableBookList;
    private BookList checkedOutBookList;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        availableBookList = mock(BookList.class);
        checkedOutBookList = mock(BookList.class);
        biblioteca = new Biblioteca(availableBookList, checkedOutBookList);
    }

    @Test
    public void shouldMoveBookToCheckedOutList() throws Exception {
        biblioteca.checkOutBook("HP 1");
        verify(availableBookList).moveBook("HP 1", checkedOutBookList);
    }

    @Test
    public void shouldMoveBookToAvailableBookList() throws Exception {
        biblioteca.checkInBook("HP 1");
        verify(checkedOutBookList).moveBook("HP 1", availableBookList);
    }

}
