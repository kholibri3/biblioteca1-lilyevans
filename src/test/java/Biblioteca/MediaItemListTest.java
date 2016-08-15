package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MediaItemListTest {

    
    private MediaItemList availableMediaItemList;
    private MediaItemList checkedOutMediaItemList;
    private MediaItem mediaItem;
    private PrintStream printStream;
    private String successMessage = "SUCCESS";
    private String failureMessage = "FAILURE";

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        availableMediaItemList = new MediaItemList(printStream, successMessage, failureMessage);
        checkedOutMediaItemList = new MediaItemList(printStream, successMessage, failureMessage);
        mediaItem = mock(MediaItem.class);
    }

    @Test
    public void shouldNotBeAvailableWhenCheckedOut() throws Exception {
        availableMediaItemList.removeItem("HP 1");
        assertFalse(availableMediaItemList.containsItem("HP 1"));
    }

    @Test
    public void shouldContainBookWhenAddedToBookList() throws Exception {
        when(mediaItem.hasTitle("title")).thenReturn(true);
        checkedOutMediaItemList.addItem(mediaItem);
        assertTrue(checkedOutMediaItemList.containsItem("title"));
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedOutSuccessfully() throws Exception {
        availableMediaItemList.addItem(mediaItem);
        when(mediaItem.hasTitle("HP 1")).thenReturn(true);
        availableMediaItemList.moveItem("HP 1", checkedOutMediaItemList);
        verify(printStream).println(successMessage);
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedOutUnsuccessfully() throws Exception {
        when(mediaItem.hasTitle("HP 1")).thenReturn(false);
        availableMediaItemList.moveItem("HP 1", checkedOutMediaItemList);
        verify(printStream).println(failureMessage);
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedInSuccessfully() throws Exception {
        checkedOutMediaItemList.addItem(mediaItem);
        when(mediaItem.hasTitle("HP 1")).thenReturn(true);
        checkedOutMediaItemList.moveItem("HP 1" , availableMediaItemList);
        verify(printStream).println(successMessage);
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedInUnsuccessfully() throws Exception {
        when(mediaItem.hasTitle("HP 1")).thenReturn(false);
        checkedOutMediaItemList.moveItem("HP 1", availableMediaItemList);
        verify(printStream).println(failureMessage);
    }
}