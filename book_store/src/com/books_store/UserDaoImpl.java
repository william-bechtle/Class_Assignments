package com.books_store;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    Connection connection;

    public UserDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public User checkLogin(String username, String password) throws SQLException {
        Statement stm = connection.createStatement();
        User account;
        String sql = String.format("CALL booksLogin('%s','%s');",username,password);
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            int id = rst.getInt("id");
            String userName = rst.getString("username");
            String password1 = rst.getString("password");
            int type = rst.getInt("account_type");
            account = new User(id,userName,password1,type);
        }
        else {
            account = new User();
        }
        return account;
    }


    @Override
    public void addUser(User employee) throws SQLException {
        String sql = "insert into book_users (username, password, account_type) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getUsername());
        preparedStatement.setString(2, employee.getPassword());
        preparedStatement.setInt(3, employee.getAccount_type());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Signed up!");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public User checkUser(String username) throws SQLException {
        Statement stm = connection.createStatement();
        User account;
        String sql = String.format("CALL getUsername('%s');",username);
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()){
            int id = rst.getInt("id");
            String userName = rst.getString("username");
            String password1 = rst.getString("password");
            int type = rst.getInt("account_type");
            account = new User(id,userName,password1,type);
        }
        else {
            account = new User();
        }
        return account;
    }

}
