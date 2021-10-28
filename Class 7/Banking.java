import java.util.Scanner;
import java.util.*;



abstract class Bank{
    abstract void Deposit(double amount);
    abstract double getBalance();
}

class Account extends Bank{
    double amount;
    String name;

    Account(String name){
        amount = 0;
        this.name = name;
    }

    void Deposit(double amount) {
        this.amount = this.amount + amount;
        System.out.printf("Deposited $" + "%.2f" +" into "+ name + "'s account.\n",amount);
        System.out.printf("New Balance: " + "$%.2f" + "\n\n", this.amount);
    }

    double getBalance(){
        return amount;
    }
}

//DIDN'T SEE THE NEED TO EXTEND TO 3 CLASSES, MAYBE IF BANKS HAD DIFFERENT DEPOSIT FEES, ETC

//MAIN CLASS
public class Banking {
    public static void main(String[] args) {
        Account bank1 = new Account("Lucy");
        bank1.Deposit(100.00);
        Account bank2 = new Account("Mark");
        bank2.Deposit(150.00);
        Account bank3 = new Account("Jeff");
        bank3.Deposit(200.00);



    }
}
