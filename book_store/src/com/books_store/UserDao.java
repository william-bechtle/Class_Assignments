package com.books_store;

import java.sql.SQLException;

public interface UserDao {
    public User checkLogin(String username, String password) throws SQLException;
    public void addUser(User employee) throws SQLException;
    public User checkUser(String username) throws SQLException;
}