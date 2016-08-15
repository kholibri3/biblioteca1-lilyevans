package Biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private BufferedReader reader;
    private PrintStream printStream;
    private Biblioteca biblioteca;

    public Menu(PrintStream printStream, BufferedReader input, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = input;
    }

    public void run() throws IOException {
        printWelcome();
        printOptionsList();
        executeMenuOption();
        printGoodbye();
    }

    public void printWelcome() {
        printStream.println("Welcome to the Biblioteca!");
    }

    public void printOptionsList() {
        printStream.println("Please choose one of the following options: ");
        printStream.println("0. Quit");
        printStream.println("1. List library books");
        printStream.println("2. Check out a book");
        printStream.println("3. Check in a book");

    }

    public void executeMenuOption() throws IOException {
        String choice = getUserInput();

        while(!choice.equals("0")) {
            processUserInput(choice);
            printStream.println();
            printOptionsList();
            choice = getUserInput();
        }
    }

    private void processUserInput(String choice) throws IOException {
        if (choice.equals("1")) {
            biblioteca.printAvailableBooks();
        } else if (choice.equals("2")){
            biblioteca.checkOutBook(readUserInput());
        } else if (choice.equals("3")){
            biblioteca.checkInBook(readUserInput());
        } else if (choice.equals("4")){
            // list available movies
        } else {
            printStream.println("Select a valid option!");
        }
    }

    private String readUserInput() throws IOException {
        printStream.println("Please enter a book title.");
        return reader.readLine();
    }

    private String getUserInput() {
        String choice = null;
        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }

    public void printGoodbye() {
        printStream.println("Goodbye!");
    }
}
