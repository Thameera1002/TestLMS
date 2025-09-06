package com.automation.training.librarymanagementsystem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        List<LibraryItems> libraryItems = LibraryIO.loadItemsFromFile("itemList.lms");
        for (LibraryItems libraryItem : libraryItems) {
            library.addItem(libraryItem);
        }

        LibraryItems book1 = new Book("Book3","BookAuthor3","B1003");
        LibraryItems book2 = new Book("Book4","BookAuthor4","B1004");
        LibraryItems magazine1 = new Magazine("Magazine2","MagAuthor2","M1002");

        User user1 = new User("Amal");
        User user2 = new User("Sunil");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);

        library.addUser(user1);
        library.addUser(user2);

        for (int i = 0; i < library.getLibraryItem().size(); i++) {
            System.out.println(library.getLibraryItem().get(i).getTitle());
            System.out.println(library.getLibraryItem().get(i).getAuthor());
            System.out.println(library.getLibraryItem().get(i).getSerialNumber());
            System.out.println();

        }
        for (int i = 0; i < library.getUserList().size(); i++) {
            System.out.println(library.getUserList().get(i).getName());
            System.out.println();
        }

        LibraryIO.saveItemsToFile(library.getLibraryItem(),"itemList.lms");
    }
}
