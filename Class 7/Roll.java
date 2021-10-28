import java.util.Scanner;

//CLASS FOR ALL SHAPES
class RollCall {
    String name;
    int roll_id;
    String interest;

    RollCall(String name, int roll_id, String interest){
        this.name = name;
        this.roll_id = roll_id;
        this.interest = interest;
    }

    @Override
    public String toString(){
        return "Hey, my name is " + name + " and my roll number is " + roll_id + ". My field of interest are " + interest + ".";
    }
}

//COULD IMPLEMENT OTHER SHAPES HERE


//MAIN CLASS
public class Roll {
    public static void main(String[] args) {
        int id;
        Scanner params = new Scanner(System.in);

        System.out.println("Enter Name: ");
        String name = params.next();

        System.out.println("Enter Roll Call ID: ");
        try {
            id = params.nextInt();
        }
        catch (Exception e){
            System.out.println(e);
            return;
        }


        System.out.println("Enter Interest: ");
        String interest = params.next();

        RollCall judy = new RollCall(name,id,interest);
        System.out.println(judy);;


    }
}
