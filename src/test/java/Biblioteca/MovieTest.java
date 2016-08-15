package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieTest {

    private String name;
    private String director;
    private String year;
    private String rating;
    private PrintStream printStream;

    @Before
    public void setUp() {
        this.name = "Finding Dory";
        this.director = "Christine";
        this.year = "2016";
        this.rating = "6";
        this.printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintDetailsCorrectly() throws Exception {
        Movie movie = new Movie(name, director, year, rating, printStream);
        movie.printDetails();
        verify(printStream).println(name + " | " + year + " | " + director + " | " + rating);
    }


}