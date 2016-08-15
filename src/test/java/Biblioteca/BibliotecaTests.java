package Biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTests {
    private Biblioteca biblioteca;
    private MediaItemList availableBookList;
    private MediaItemList checkedOutBookList;
    private MediaItemList availableMovieList;
    private MediaItemList checkedOutMovieList;


    @Before
    public void setup() {
        availableBookList = mock(MediaItemList.class);
        checkedOutBookList = mock(MediaItemList.class);
        availableMovieList = mock(MediaItemList.class);
        checkedOutMovieList = mock(MediaItemList.class);
        biblioteca = new Biblioteca(availableBookList, checkedOutBookList, availableMovieList, checkedOutMovieList);
    }

    @Test
    public void shouldMoveBookToCheckedOutList() throws Exception {
        biblioteca.checkOutBook("HP 1");
        verify(availableBookList).moveItem("HP 1", checkedOutBookList);
    }

    @Test
    public void shouldMoveBookToAvailableBookList() throws Exception {
        biblioteca.checkInBook("HP 1");
        verify(checkedOutBookList).moveItem("HP 1", availableBookList);
    }

    @Test
    public void shouldMoveMovieToCheckedOutList() throws Exception {
        biblioteca.checkOutMovie("HP 1");
        verify(availableMovieList).moveItem("HP 1", checkedOutMovieList);
    }

    @Test
    public void shouldMoveMovieToAvailableBookList() throws Exception {
        biblioteca.checkInMovie("HP 1");
        verify(checkedOutMovieList).moveItem("HP 1", availableMovieList);
    }

}
