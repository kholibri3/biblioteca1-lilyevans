package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieDetailsTest {

    private String year;
    private String director;
    private String rating;
    private MovieDetails movieDetails;

    @Before
    public void setup() {
        year = "2016";
        director = "Katie Ho";
        rating = "10+";
        movieDetails = new MovieDetails(year, director, rating);
    }
    @Test
    public void shouldPrintBookDetails(){
        assertEquals(year+" | "+ director + " | "+rating, movieDetails.formatDetails());
    }



}