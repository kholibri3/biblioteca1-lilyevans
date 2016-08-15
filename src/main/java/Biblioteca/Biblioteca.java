package Biblioteca;

public class Biblioteca {

    private MediaItemList availableBookList;
    private MediaItemList checkedOutBookList;
    private MediaItemList availableMovieList;
    private MediaItemList checkedOutMovieList;

    public Biblioteca(MediaItemList availableBookList, MediaItemList checkedOutBookList, MediaItemList availableMovieList, MediaItemList checkedOutMovieList){
        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
        this.availableMovieList = availableMovieList;
        this.checkedOutMovieList = checkedOutMovieList;
    }

    public void printAvailableBooks() {
        availableBookList.printItemList();
    }

    public void printAvailableMovies() {
        availableMovieList.printItemList();
    }

    public void checkOutBook(String title) {
        availableBookList.moveItem(title, checkedOutBookList);
    }
    public void checkInBook(String title) {
        checkedOutBookList.moveItem(title, availableBookList);
    }

    public void checkOutMovie(String title) {
        availableMovieList.moveItem(title, checkedOutMovieList);
    }
    public void checkInMovie(String title) {
        checkedOutMovieList.moveItem(title, availableMovieList);
    }

}
