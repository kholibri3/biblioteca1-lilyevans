package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookListTest {

    private BookList availableBookList;
    private BookList checkedOutBookList;
    private PrintStream printStream;
    private Book book;
    private String successMessage = "SUCCESS";
    private String failureMessage = "FAILURE";

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        availableBookList = new BookList(printStream, successMessage, failureMessage);
        checkedOutBookList = new BookList(printStream, successMessage, failureMessage);
        book = mock(Book.class);
    }

    @Test
    public void shouldNotBeAvailableWhenCheckedOut() throws Exception {
        availableBookList.removeBook("HP 1");
        assertFalse(availableBookList.containsBook("HP 1"));
    }

    @Test
    public void shouldContainBookWhenAddedToBookList() throws Exception {
        when(book.thisIsMyTitle("title")).thenReturn(true);
        checkedOutBookList.addBook(book);
        assertTrue(checkedOutBookList.containsBook("title"));
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedOutSuccessfully() throws Exception {
        availableBookList.addBook(book);
        when(book.thisIsMyTitle("HP 1")).thenReturn(true);
        availableBookList.moveBook("HP 1", checkedOutBookList);
        verify(printStream).println(successMessage);
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedOutUnsuccessfully() throws Exception {
        when(book.thisIsMyTitle("HP 1")).thenReturn(false);
        availableBookList.moveBook("HP 1", checkedOutBookList);
        verify(printStream).println(failureMessage);
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedInSuccessfully() throws Exception {
        checkedOutBookList.addBook(book);
        when(book.thisIsMyTitle("HP 1")).thenReturn(true);
        checkedOutBookList.moveBook("HP 1" ,availableBookList);
        verify(printStream).println(successMessage);
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedInUnsuccessfully() throws Exception {
        when(book.thisIsMyTitle("HP 1")).thenReturn(false);
        checkedOutBookList.moveBook("HP 1", availableBookList);
        verify(printStream).println(failureMessage);
    }
}