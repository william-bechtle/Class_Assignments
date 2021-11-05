package com.books_store;

public class OrderDaoFactory {
    private static OrderDao dao;

    private OrderDaoFactory() {
    }

    public  static OrderDao getOrderDao(){
        if(dao == null){
            dao = new OrderDaoImpl() {
            };
        }
        return dao;
    }
}