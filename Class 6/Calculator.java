import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

class DivideByZero extends Exception{
    DivideByZero(String error){
        super(error);
    }
}

class Calc{
    double a;
    double b;
    Calc(double a, double b){
        this.a = a;
        this.b = b;
    }
    double Add(){
        return a+b;
    }
    double Subtract() {
        return a-b;
    }
    double Multiply() {
        return a*b;
    }
    double Divide() throws DivideByZero {
        if(b == 0) {
            throw new DivideByZero("ERROR: " + a + "/" + b + " is not allowed. (DIV BY 0)");
        }
        else {
            return a / b;
        }
    }
    void Change(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER FIRST NUMBER:");
        this.a = scanner.nextInt();
        System.out.println("ENTER SECOND NUMBER:");
        this.b = scanner.nextInt();
    }

}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        int option2 = 0;
        System.out.println("ENTER FIRST NUMBER:");
        double a = scanner.nextInt();
        System.out.println("ENTER SECOND NUMBER:");
        double b = scanner.nextInt();
        Calc calc = new Calc(a, b);
        ArrayList<String> names = new ArrayList<>(Arrays.asList("ADDING","SUBTRACTING", "MULTIPLYING", "DIVIDING", "CHANGING NUMBERS", "QUITTING"));

        while(option != 6) {
            do {
                System.out.println("ENTER OPTION: 1-ADD, 2-SUBTRACT, 3-MULTIPLY, 4-DIVIDE, 5-CHANGE NUMBERS, 6-QUIT");
                option = scanner.nextInt();

                System.out.println(names.get(option-1) + "......");

                switch (option) {
                    case 1: System.out.println("Result: " + calc.Add()); break;
                    case 2: System.out.println("Result: " + calc.Subtract()); break;
                    case 3: System.out.println("Result: " + calc.Multiply()); break;

                    case 4:
                        try {System.out.println("Result: " + calc.Divide());}
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5: calc.Change(); break;
                    case 6: System.out.println("Goodbye!"); break;

                    default: {
                        System.out.println("Invalid Option, read menu and reenter.");
                        option2 = 1;
                        break;
                    }
                }
            }while(option2 == 1);
        }
    }
}