package com.practice.errors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManipulator {
    public static void writeFile(String name){
        String words = " Hi how are you? :)";
        final String route = name;
        try{
            File file = new File(route);
            file.createNewFile();

            FileWriter writer = new FileWriter(route);
            writer.write(words);
            writer.close();
        }catch (IOException exception){
            System.out.println("File cant be writed");
            exception.printStackTrace();
        }catch (Exception ex){
            System.out.println("Unrecognized error"+ex.getMessage());
            ex.printStackTrace();
        }
    }
}
