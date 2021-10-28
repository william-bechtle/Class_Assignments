import java.util.Scanner;

//CLASS FOR ALL SHAPES
abstract class Shape {
    public abstract int area();
}

//CLASS FOR RECTANGLES
class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public int area(){
        int area;
        area = (int)(width*height);
        return area;
    }
}

//COULD IMPLEMENT OTHER SHAPES HERE


//MAIN CLASS
public class Area {
    public static void main(String[] args) {
        Scanner params = new Scanner(System.in);

        System.out.println("Enter Rectangle Width: ");
        double width = params.nextDouble();

        System.out.println("Enter Rectangle Height: ");
        double height = params.nextDouble();

        Rectangle rect = new Rectangle(width,height);
        System.out.println("Area: " + rect.area());
    }
}
