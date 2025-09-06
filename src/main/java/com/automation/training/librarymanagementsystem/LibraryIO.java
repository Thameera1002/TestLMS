package com.automation.training.librarymanagementsystem;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
}
