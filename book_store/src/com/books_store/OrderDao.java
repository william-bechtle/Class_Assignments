package com.books_store;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDao {
    public ArrayList<Order> getUserOrders(int id) throws SQLException;
    public void addOrder(Order order) throws SQLException;
}