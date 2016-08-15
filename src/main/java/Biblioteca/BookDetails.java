package Biblioteca;

public class BookDetails implements MediaItemDetails {

    private String author;
    private String yearPublished;

    public BookDetails(String author, String yearPublished) {
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String formatDetails() {
        return String.format("%s | %s", author, yearPublished);
    }
}
