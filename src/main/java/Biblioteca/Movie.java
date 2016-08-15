package Biblioteca;

import java.io.PrintStream;

public class Movie {
    private String name;
    private String director;
    private String yearReleased;
    private String rating;
    private PrintStream printStream;

    public Movie(String name, String director, String yearReleased, String rating, PrintStream printStream) {
        this.name = name;
        this.director = director;
        this.yearReleased = yearReleased;
        this.rating = rating;
        this.printStream = printStream;
    }

    public void printDetails() {
        printStream.println(name + " | " + yearReleased + " | " + director + " | " + rating);
    }

    public boolean thisIsMyTitle(String title) {
        return title.equals(name);
    }

}
