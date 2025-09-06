package com.automation.training.librarymanagementsystem;

public class Magazine extends LibraryItems{
    public Magazine(String title, String author, String serialNumber) {
        super(title, author, serialNumber);
    }

    @Override
    public void borrowItem(User user) {
        if (!isBorrowed){
            isBorrowed = true;
            System.out.println(user.getName() + " borrowed " + getTitle()+" magazine !");
        }else  {
            System.out.println("Magazine" + getTitle() + " is already borrowed !");
        }
    }
}
