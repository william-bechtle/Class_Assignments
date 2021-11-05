package com.books_store;

public class BooksDaoFactory {
    private static BooksDao dao;

    private BooksDaoFactory() {
    }

    public  static BooksDao getBooksDao(){
        if(dao == null){
            dao = new BooksDaoImpl() {
            };
        }
        return dao;
    }
}