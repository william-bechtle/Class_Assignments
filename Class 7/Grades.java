import java.util.Scanner;
import java.util.*;



//CLASS FOR ALL SHAPES
abstract class Marks {
    abstract void getPercentage();
}

class StudentA extends Marks{
    String name;
    double math;
    double gym;
    double art;

    StudentA(String name, double math, double gym, double art){
        this.name = name;
        this.art = art;
        this.gym = gym;
        this.math =math;
    }

    void getPercentage() {
        System.out.printf("%s:\nArt Grade: %.2f%% %nGym Grade: %.2f%% %nMath Grade: %.2f%% %n\n", name,art,gym,math);
    }
}

class StudentB extends Marks{
    String name;
    double math;
    double gym;
    double art;
    double health;

    StudentB(String name, double math, double gym, double art, double health){
        this.name = name;
        this.art = art;
        this.gym = gym;
        this.math =math;
        this.health = health;
    }

    void getPercentage() {
        System.out.printf("%s:\nArt Grade: %.2f%% %nGym Grade: %.2f%% %nMath Grade: %.2f%% %nHealth Grade: %.2f%% %n", name,art,gym,math,health);
    }
}

//COULD IMPLEMENT OTHER SHAPES HERE


//MAIN CLASS
public class Grades {
    public static void main(String[] args) {
        StudentA Lucy = new StudentA("Lucy",100,100,100);
        Lucy.getPercentage();
        StudentB Mark = new StudentB("Mark",98.6662,99.499999999999,78.4334223, 71.2323249);
        Mark.getPercentage();

    }
}
