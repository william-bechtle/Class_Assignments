package com.books_store;

public class Books {
    int id;
    String category;
    String title;
    String author;
    double price;
    String description;

    Books(){

    }

    Books(int id, String category, String title, String author, double price, String description){
        this.id = id;
        this.category = category;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
    }

    Books(String category, String title, String author, double price, String description){
        this.category = category;
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        String prc = String.format("%.2f",price);
        return "-------------------BOOK----------------------\n" + "Book: " + title + "\nAuthor: " + author + "\nPrice: $" + prc + "\nDescription: " + description;
    }

    public String toString2() {
        String prc = String.format("%.2f",price);
        return "Book: " + title + ", Author: " + author;
    }

    public String toString3() {
        String prc = String.format("%.2f",price);
        return "Book: " + title + ", Author: " + author + ", Price: $" + prc;
    }

}
