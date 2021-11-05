package com.books_store;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BooksDao {
    public ArrayList<String> getCategories() throws SQLException;
    public void addBook(Books book) throws SQLException;
    public ArrayList<Books> getCategoryBooks(String cat) throws SQLException;
    public void deleteBook(int id) throws SQLException;
}