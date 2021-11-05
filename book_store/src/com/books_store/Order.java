package com.books_store;

public class Order {
    int id;
    int user_id;
    int book_id;
    int completed;
    double price;

    Order(){

    }

    Order(int id, int user_id, int book_id, int completed, double price) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.completed = completed;
        this.price = price;
    }

    Order(int user_id, int book_id, double price) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.completed = 0;
        this.price = price;
    }

    @Override
    public String toString() {
        String comp = "placed";
        if (completed == 1){
            comp = "completed";
        }
        String prc = String.format("%.2f", price);
        return "id: " + id + ", book_id: " + book_id + ", status: " + comp + ", price: $" + prc;
    }
}