package com.books_store;

import java.sql.*;
import java.util.ArrayList;

public class BooksDaoImpl implements BooksDao {

    Connection connection;

    public BooksDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public ArrayList<String> getCategories() throws SQLException {
        Statement stm = connection.createStatement();
        ArrayList<String> books = new ArrayList<>();
        String sql = String.format("CALL getCat();");
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            String cat = rst.getString("category");
            books.add(cat);
        }
        return books;
    }

    @Override
    public void addBook(Books book) throws SQLException {
        String sql = String.format("call insertBook('%s', '%s', '%s', %s, '%s');",book.category,book.title,book.author,book.price,book.description);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Book put in store");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public ArrayList<Books> getCategoryBooks(String cat) throws SQLException {
        Statement stm = connection.createStatement();
        ArrayList<Books> books = new ArrayList<>();
        String sql = String.format("CALL getByCat('%s');",cat);
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            int id = rst.getInt("id");
            String cats = rst.getString("category");
            String title = rst.getString("title");
            String author = rst.getString("author");
            double price = rst.getDouble("price");
            String description = rst.getString("description");
            Books book = new Books(id,cats,title,author,price,description);
            books.add(book);
        }
        return books;
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        String sql = String.format("delete from books where id = %s",id);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Book added to cart");
        else
            System.out.println("Oops! something went wrong");
    }

}