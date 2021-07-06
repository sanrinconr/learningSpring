package com.library;

public class Book {
    private String name;
    private String ISBN;
    private String Author;
    private char status;

    public void prestar(){
        this.status = 'P';
    }
    public void devolver(){
        this.status = 'D';
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
