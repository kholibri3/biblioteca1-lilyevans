package Biblioteca;

public class MediaItem {
    private String title;
    private MediaItemDetails details;

    public MediaItem(String title,MediaItemDetails details) {
        this.title = title;
        this.details = details;
    }

    public boolean hasTitle(String title){
        return title.equals(this.title);
    }

    public void printDetails(){
        System.out.println(title + " | " + details.formatDetails());
    }
}
