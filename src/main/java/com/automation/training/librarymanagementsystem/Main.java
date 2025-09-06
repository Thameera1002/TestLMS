package com.automation.training.librarymanagementsystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        LibraryItems book1 = new Book("Book1","BookAuthor1","B1001");
        LibraryItems book2 = new Book("Book2","BookAuthor2","B1002");
        LibraryItems magazine1 = new Magazine("Magazine1","MagAuthor1","M1001");

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
    }
}
