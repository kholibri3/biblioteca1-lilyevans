package Biblioteca;

/**
 * Created by katieho on 8/15/16.
 */
public class MovieDetails implements MediaItemDetails {
    //year, director and movie rating
    private String year;
    private String director;
    private String rating;

    public MovieDetails(String year, String director, String rating) {
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String formatDetails() {
        return String.format("%s | %s | %s", year, director, rating);
    }
}
