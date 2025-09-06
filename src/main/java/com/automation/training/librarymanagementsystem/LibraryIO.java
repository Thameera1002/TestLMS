package com.automation.training.librarymanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
}
