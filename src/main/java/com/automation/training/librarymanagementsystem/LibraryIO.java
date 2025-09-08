package com.automation.training.librarymanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryIO {
    public static void saveItemsToFile(List<LibraryItems> libraryItemList,String fileName){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(libraryItemList);
            System.out.println("Library Items Saved to the file "+fileName+" successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<LibraryItems> loadItemsFromFile(String fileName){
        File file = new File(fileName);
        if (!file.exists()){
           return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<LibraryItems>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveUsersToFile(List<User> userList,String fileName){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(userList);
            System.out.println("Users Saved to the file "+fileName+" successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<User> loadUsersFromFile(String fileName){
        File file = new File(fileName);
        if (!file.exists()){
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveBorrowedItemsToFile(Map<String,String > borrowedItemList,String fileName){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(borrowedItemList);
            System.out.println("Borrowed Items Saved to the file "+fileName+" successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<String,String> loadBorrowedItemsFromFile(String fileName){
        File file = new File(fileName);
        if (!file.exists()){
            return new HashMap<String,String>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (Map<String, String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
