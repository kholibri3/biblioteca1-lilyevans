package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookDetailsTest {

    private String author;
    private String yearPublished;
    private BookDetails bookDetails;

    @Before
    public void setup() {
        author = "Author";
        yearPublished = "2016";
        bookDetails = new BookDetails(author, yearPublished);
    }

    @Test
    public void shouldPrintBookDetails(){
        assertEquals(author+" | "+ yearPublished, bookDetails.formatDetails());
    }


}