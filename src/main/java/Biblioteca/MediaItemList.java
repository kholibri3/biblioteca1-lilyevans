package Biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class MediaItemList {

    private Collection<MediaItem> items;

    private PrintStream printStream;
    private String successMessage;
    private String failureMessage;

    public MediaItemList(PrintStream printStream, String successMessage, String failureMessage) {
        this.printStream = printStream;
        this.successMessage = successMessage;
        this.failureMessage = failureMessage;
        this.items = new ArrayList<MediaItem>();
    }

    public boolean containsItem(String title) {
        for (MediaItem item : items){
            if(item.hasTitle(title))
                return true;
        }
        return false;
    }


    public void printItemList() {
        if (items.isEmpty()) {
            printStream.println("There are no items.");
        }

        for (MediaItem item : items) {
            item.printDetails();
        }
    }

    public void addItem(MediaItem item){
        items.add(item);
    }


    public MediaItem removeItem(String title) {
        for (MediaItem item : items){
            if (item.hasTitle(title)){
                items.remove(item);

                return item;
            }
        }

        return null;
    }

    public void printSuccessMessage() {
        printStream.println(successMessage);
    }

    public void printFailureMessage() {
        printStream.println(failureMessage);
    }

    public void moveItem(String title, MediaItemList toMediaItemList) {
        if(this.containsItem(title)) {
            MediaItem itemToCheckIn = removeItem(title);
            toMediaItemList.addItem(itemToCheckIn);
            toMediaItemList.printSuccessMessage();
        } else
            toMediaItemList.printFailureMessage();
    }
}
