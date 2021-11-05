package com.books_store;

import java.sql.*;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {

    Connection connection;

    public OrderDaoImpl(){
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public ArrayList<Order> getUserOrders(int id) throws SQLException {
        Statement stm = connection.createStatement();
        ArrayList<Order> orders = new ArrayList<>();
        String sql = String.format("select * from orders where user_id = %s",id);
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            int ids = rst.getInt("id");
            int book = rst.getInt("book_id");
            int user = rst.getInt("user_id");
            int complete = rst.getInt("completed");
            double price = rst.getDouble("price");
            Order order = new Order(ids,user,book,complete,price);
            orders.add(order);
        }
        return orders;
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        String sql = String.format("call insertOrder(%s, %s, %s, %s);",order.book_id,order.user_id,order.completed,order.price);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Order placed");
        else
            System.out.println("Oops! something went wrong");
    }
}