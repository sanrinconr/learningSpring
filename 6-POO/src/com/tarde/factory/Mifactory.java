package com.tarde.factory;

import com.tarde.sort.ISorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Mifactory {
    public static ISorter getInstance() {
        Properties p = new Properties();
        try{
            p.load(new FileReader("Mifactory.properties"));
        }catch (Exception e){
            e.printStackTrace();
            p.setProperty("sorter","com.tarde.sort.QuickSortImp");
        }
        try{
            return (ISorter) Class.forName(p.getProperty("sorter")).getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
