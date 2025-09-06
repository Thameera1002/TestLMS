package com.automation.training.librarymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<LibraryItems> libraryItem;
    private List<User> userList;
    private Map<String,String> borrowedItem;

    public Library() {
        libraryItem = new ArrayList<>();
        userList = new ArrayList<>();
        borrowedItem = new HashMap<>();
    }

    public void addItem(LibraryItems item) {
        libraryItem.add(item);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<LibraryItems> getLibraryItem() {
        return libraryItem;
    }
    public List<User> getUserList() {
        return userList;
    }

    public void borrowItem(String serialNumber,User user) {
        for (LibraryItems item : libraryItem) {
            if(item.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                if(borrowedItem.containsKey(item.getSerialNumber())) {
                    System.out.println("Item "+item.getTitle()+" is already borrowed." );
                    return;
                }
                borrowedItem.put(item.getTitle(), user.getName());
                item.isBorrowed = true;
                System.out.println("Item "+item.getTitle()+" is now borrowed by "+ user.getName());
                return;
            }
        }
        System.out.println("Item with serial number "+serialNumber+" is not valid.");
    }

    public void returnBorrowedItem(String serialNumber) {
        for (LibraryItems item : libraryItem) {
            if(item.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                borrowedItem.remove(item.getSerialNumber());
                item.isBorrowed = false;
                return;
            }
        }
        System.out.println("Item with serial number "+serialNumber+" is not valid.");
    }

    public Map<String,String> getBorrowedItems() {
        return borrowedItem;
    }



}
