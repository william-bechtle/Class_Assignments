package com.books_store;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuDisplay {

    Scanner scan = new Scanner(System.in);
    UserDao dao = UserDaoFactory.getUserDao();

    MenuDisplay() {

    }

    public String mainMenu() {
        System.out.println("PICK OPTION:");
        System.out.println("1 - LOGIN");
        System.out.println("2 - REGISTER");
        System.out.println("3 - QUIT");
        System.out.println("PLEASE ENTER OPTION: ");
        return scan.next();
    }

    public User login() throws SQLException {
        System.out.println("ENTER USERNAME: ");
        String user_name = scan.next();
        System.out.println("ENTER PASSWORD: ");
        String pass_word = scan.next();
        return dao.checkLogin(user_name,pass_word);
    }

    public void signUp() throws SQLException {
        System.out.println("ENTER DESIRED USERNAME: ");
        String user_name = scan.next();
        System.out.println("ENTER DESIRED PASSWORD: ");
        String pass_word = scan.next();
        User check = dao.checkUser(user_name);
        boolean exists = checkAccount(check);
        if (exists) {
            System.out.println("USERNAME ALREADY EXISTS");
        }
        else {
            User user = new User(user_name,pass_word,0);
            dao.addUser(user);
        }
    }

    public String userMenu() {
        System.out.println("User Options: ");
        System.out.println("1 - Shop For Books");
        System.out.println("2 - Checkout");
        System.out.println("3 - View orders");
        System.out.println("4 - Quit");
        System.out.println("ENTER OPTION: ");
        String a = scan.next();
        return a;
    }

    public String employeeMenu() {
        System.out.println("User Options: ");
        System.out.println("1 - Add Books");
        System.out.println("2 - Quit");
        System.out.println("ENTER OPTION: ");
        String a = scan.next();
        return a;
    }


    public boolean checkAccount(User user){
        return user.getUsername() != null;
    }
}