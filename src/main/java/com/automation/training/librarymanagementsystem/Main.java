package com.automation.training.librarymanagementsystem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        List<LibraryItems> libraryItems = LibraryIO.loadItemsFromFile("itemList.lms");
        for (LibraryItems libraryItem : libraryItems) {
            library.addItem(libraryItem);
        }

        List<User> users = LibraryIO.loadUsersFromFile("userList.lms");
        for (User user : users) {
            library.addUser(user);
        }

        Map<String,String> borrowedItems = LibraryIO.loadBorrowedItemsFromFile("borrowedItemList.lms");
        for (Map.Entry<String ,String> item : borrowedItems.entrySet()) {
            library.getBorrowedItems().put(item.getKey(), item.getValue());
        }

        System.out.println("Here, find the list of all library items");
        library.getLibraryItem().forEach(item -> System.out.println(item.getTitle()+"\t"+item.getAuthor()+"\t"+item.getSerialNumber()));
        System.out.println("-----------------------------------------");

        System.out.println("Here, find the list of all users");
        library.getUserList().forEach(user -> System.out.println(user.getName()));
        System.out.println("-----------------------------------------");

        System.out.println("Here, find the list of all borrowed items");
        library.getBorrowedItems().forEach((item,user)-> System.out.println(item+"   "+user));
        System.out.println("-----------------------------------------");



        LibraryIO.saveItemsToFile(library.getLibraryItem(),"itemList.lms");
        LibraryIO.saveUsersToFile(library.getUserList(),"userList.lms");
        LibraryIO.saveBorrowedItemsToFile(library.getBorrowedItems(),"borrowedItemList.lms");
    }
}
