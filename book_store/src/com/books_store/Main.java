package com.books_store;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        boolean logged_in = false;
        boolean quit = false;
        UserDao dao = UserDaoFactory.getUserDao();
        MenuDisplay menu = new MenuDisplay();
        String option;
        String option2;

        while(!quit) {
            User user = new User();
            System.out.println("\n\n");
            System.out.println("---------------BOOK STORE WEB PORTAL------------------");
            option = menu.mainMenu();
            switch (option) {
                case "1":
                    user = menu.login();
                    logged_in = menu.checkAccount(user);
                    if (!logged_in) {
                        System.out.println("INVALID CREDENTIALS");
                    }
                    break;
                case "2":
                    menu.signUp();
                    break;
                case "3":
                    System.out.println("QUITTING......");
                    quit = true;
                    break;
                default:
                    System.out.println("INVALID CHOICE. TRY AGAIN");
            }

            while(logged_in){
                System.out.println("\n\n");
                System.out.println("-----------------------" + user.username +"--------------------------");
                switch (user.account_type) {
                    case 0:
                        option2 = menu.userMenu();
                        logged_in = user.handleUserOption(option2);
                        break;
                    case 1:
                        Employee employee = new Employee(user);
                        option2 = menu.employeeMenu();
                        logged_in = employee.handleMenu(option2);
                        break;
                    default:
                        System.out.println("ERROR IN ACCOUNT TYPE");
                        break;
                }
            }
        }


    }
}