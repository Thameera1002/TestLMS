package com.automation.training.librarymanagementsystem;

public class Book extends LibraryItems {

    public Book(String title, String author, String serialNumber) {
        super(title, author, serialNumber);
    }

    @Override
    public void borrowItem(User user) {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(user.getName() + " borrowed " + getTitle() + " successfully !");
        } else {
            System.out.println("Book" + getTitle() + " is already borrowed !");
        }
    }
}
