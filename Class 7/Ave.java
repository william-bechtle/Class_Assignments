import java.util.Scanner;
import java.util.*;


//CLASS FOR ALL SHAPES
class Average {
    double a;
    double b;
    double c;

    Average(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double average(){
        return (a+b+c)/3;
    }
}

//COULD IMPLEMENT OTHER SHAPES HERE


//MAIN CLASS
public class Ave {
    public static void main(String[] args) {
        int i = 0;
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();
        System.out.println("Enter 3 Numbers To Average: ");
        while(i < 3){
            numbers.add(scan.nextDouble());
            i++;
        }

        Average ave = new Average(numbers.get(0),numbers.get(1),numbers.get(2));
        System.out.println("Average: " + ave.average());


    }
}
