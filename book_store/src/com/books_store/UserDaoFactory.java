package com.books_store;

public class UserDaoFactory {
    private static UserDao dao;

    private UserDaoFactory() {
    }

    public  static UserDao getUserDao(){
        if(dao == null){
            dao = new UserDaoImpl() {
            };
        }
        return dao;
    }
}