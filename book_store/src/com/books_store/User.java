package com.books_store;

import java.sql.SQLException;
import java.util.*;

public class User {
    int id;
    String username;
    String password;
    int account_type;
    Scanner scan = new Scanner(System.in);
    BooksDao dao = BooksDaoFactory.getBooksDao();
    ArrayList<Books> orders = new ArrayList<>();


    User() {

    }

    User(User user){
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.account_type = user.account_type;
        this.scan = user.scan;
        this.dao = user.dao;
        this.orders = user.orders;
    }

    User(int id, String username, String password, int account_type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.account_type = account_type;
    }

    User(String username, String password, int account_type) {
        this.username = username;
        this.password = password;
        this.account_type = account_type;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername(){
        return username;
    }

    public int getAccount_type() {
        return account_type;
    }

    public ArrayList<Books> getOrders() {
        return orders;
    }

    public boolean handleUserOption(String option) throws SQLException {
        boolean stay = true;
        int cat_choice = 0;
        switch (option) {
            case "1":
                while(stay) {
                    ArrayList<String> cats = getCategories();
                    cat_choice = printCategories(cats);
                    stay = handleCategory(cat_choice, cats);
                }
                break;
            case "2":
                viewCart();
                break;
            case "3":
                viewOrders();
                break;
            case "4":
                clearCart();
                System.out.println("LOGGING OUT..........");
                return false;
            default:
                System.out.println("WRONG CHOICE TRY AGAIN......");
        }
        return true;
    }

    private ArrayList<String> getCategories() throws SQLException {
        ArrayList<String> cats = dao.getCategories();
        return cats;
    }

    private int printCategories(ArrayList<String> cats) {
        int i = 1;
        int a = 0;
        System.out.println("\n\n");
        System.out.println("-----------------------BOOK CATEGORIES--------------------------");
        if (cats.size() == 0) {
            System.out.println("NO BOOKS AVAILABLE RIGHT NOW... CONTACT OWNER TO GET SOME NEW BOOKS FOR THE STORE!");
            return cats.size() + 1;
        }
        System.out.println("CHOOSE CATEGORY: ");
        for (String cat : cats) {
            System.out.println(i + " - " + cat);
            i++;
        }
        System.out.println(i + " - QUIT");
        System.out.println("PLEASE ENTER OPTION: ");
        try {
            a = scan.nextInt();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return a;
    }

    private boolean handleCategory(int cat_choice, ArrayList<String> cats) throws SQLException {
        boolean stay = true;
        if ((cat_choice < 1) || (cat_choice > cats.size() + 1)) {
            System.out.println("ERROR, WRONG CHOICE.... TRY AGAIN");
        }
        else if (cat_choice == cats.size() + 1) {
            stay = false;
        }
        else {
            getBooks(cats.get(cat_choice-1));
        }
        return stay;
    }

    private void getBooks(String category) throws SQLException {
        boolean stay = true;
        int choice = 0;
        while (stay) {
            ArrayList<Books> books = new ArrayList<>();
            books = dao.getCategoryBooks(category);
            choice = printBooks(books, category);
            stay = handleBookChoice(choice,books);
        }
    }

    private int printBooks(ArrayList<Books> books, String category) {
        int i = 1;
        int a = 0;
        System.out.println("\n\n");
        System.out.println("----------------------------" + category.toUpperCase() + " BOOKS" + "------------------------------");
        if (books.size() == 0) {
            System.out.println("NO BOOKS AVAILABLE FOR THIS CATEGORY RIGHT NOW... CONTACT OWNER TO GET SOME NEW BOOKS FOR THE STORE!");
            return books.size() + 1;
        }
        System.out.println("CHOOSE BOOK TO VIEW AND PURCHASE: ");
        for (Books book : books) {
            System.out.println(i + " - " + book.toString2());
            i++;
        }
        System.out.println(i + " - QUIT");
        System.out.println("PLEASE ENTER OPTION: ");
        try {
            a = scan.nextInt();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return a;
    }

    private boolean handleBookChoice(int book_choice, ArrayList<Books> books) throws SQLException {
        boolean stay = true;
        if ((book_choice < 1) || (book_choice > books.size() + 1)) {
            System.out.println("ERROR, WRONG CHOICE.... TRY AGAIN");
        }
        else if (book_choice == books.size() + 1) {
            stay = false;
        }
        else {
            Books book = books.get(book_choice-1);
            System.out.println(book);
            System.out.println("Purchase? (Y or N): ");
            String purchase = scan.next();
            purchase = purchase.toLowerCase();
            switch (purchase) {
                case "y":
                    this.orders.add(book);
                    dao.deleteBook(book.id);
                    break;
                default:
                    break;
            }
        }
        return stay;
    }

    public void viewCart() throws SQLException {
        double total = 0;
        int i = 1;
        System.out.println("\n\n");
        System.out.println("-----------------------------CART-------------------------------");
        if (orders.size() == 0){
            System.out.println("NOTHING IN CART...");
            return;
        }
        for (Books order : orders){
            System.out.println(i + " - " + order.toString3());
            total = total + order.price;
            i++;
        }
        String prc = String.format("%.2f",total);
        System.out.println("TOTAL # OF BOOKS: " + i + ", TOTAL PRICE: $" + total + "\n");

        boolean opt = false;
        while (!opt) {
            System.out.println("OPTIONS: ");
            System.out.println("1 - Checkout");
            System.out.println("2 - Remove item");
            System.out.println("3 - Clear Cart");
            System.out.println("4 - Keep Shopping");
            String choice = scan.next();

            switch (choice) {
                case "1":
                    OrderDao dao1 = OrderDaoFactory.getOrderDao();
                    for (Books order : orders) {
                        Order record = new Order(this.id, order.id, order.price);
                        dao1.addOrder(record);
                    }
                    orders.clear();
                    break;
                case "2":
                    handleRemove();
                    if (orders.size() == 0){
                        opt = true;
                        System.out.println("YOU CLEARED ENTIRE CART.....");
                    }
                    break;
                case "3":
                    clearCart();
                    System.out.println("CART CLEARED");
                    opt = true;
                    break;
                case "4":
                    opt = true;
                    System.out.println("BACK TO SHOPPING.....");
                    break;
                default:
                    System.out.println("WRONG CHOICE.....");
            }
        }
    }

    public void clearCart() throws SQLException {
        for (Books order: orders){
            dao.addBook(order);
        }
        orders.clear();
    }

    public void viewOrders() throws SQLException {
        int i = 1;
        ArrayList<Order> order_list = new ArrayList<>();
        OrderDao dao1 = OrderDaoFactory.getOrderDao();
        order_list = dao1.getUserOrders(this.id);
        System.out.println("\n\n");
        System.out.println("-------------------------ORDERS-----------------------------");
        if (order_list.size() == 0){
            System.out.println("NO ORDERS...");
            return;
        }
        for (Order order : order_list) {
            System.out.println(i + " - " + order);
            i++;
        }
        System.out.println("ENTER ANYTHING TO CONTINUE: ");
        scan.next();
    }

    public void handleRemove() throws SQLException {
        int a = 0;
        System.out.println("ENTER ITEM # IN CART TO REMOVE: ");
        try {
            a = scan.nextInt();
        }
        catch (Exception e){
            System.out.println(e);
        }
        if (a > orders.size() || a < 1) {
            System.out.println("NOT AN ITEM IN THE CART");
        }
        else {
            dao.addBook(orders.get(a-1));
            orders.remove(a - 1);
            System.out.println("REMOVED FROM CART");
        }
    }
}

class Employee extends User {
    Employee(User user) {
        super(user);
    }

    public boolean handleMenu(String option) throws SQLException {
        switch (option){
            case "1":
                addBook();
                break;
            case "2":
                System.out.println("LOGGIN OUT..........");
                return false;
            default:
                System.out.println("WRONG CHOICE.....");
                break;
        }

        return true;
    }

    private void addBook() throws SQLException {
        boolean correct = false;
        double price = 0;
        System.out.println("ENTER BOOK Category: ");
        String cat = scan.nextLine();
        System.out.println("ENTER BOOK Title: ");
        String title = scan.nextLine();
        System.out.println("ENTER BOOK Author: ");
        String author = scan.nextLine();
        System.out.println("Enter BOOK Price: ");
        while(!correct) {
            try {
                price = scan.nextDouble();
                correct = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("ENTER BOOK Description: ");
        String descrip = scan.nextLine();
        if (Objects.equals(descrip, "")) {
            descrip = scan.nextLine();
        }
        Books book = new Books(cat,title,author,price,descrip);
        dao.addBook(book);
    }
}
