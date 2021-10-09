package com.example.todolistproject;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {

    public static final String FILE_NAME = "listItems.dat";

    public static void writeData(ArrayList<String> arrayList, Context context) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME,Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readData(Context context) {
        ArrayList<String> itemList = null;
        try {
            FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            itemList = (ArrayList<String>)objectInputStream.readObject();
        }catch (FileNotFoundException e) {
            itemList = new ArrayList<>();
            e.printStackTrace();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
