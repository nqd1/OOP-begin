import java.util.Scanner;

public class InputFromKeyboard {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int intAge = keyboard.nextInt();
        System.out.println("How tall are you (in meters)?");
        double dbHeight = keyboard.nextDouble();
        System.out.println("Gender (M/F/Other)?");
        keyboard.nextLine();
        String strGender = keyboard.nextLine();
        if (strGender.equals("M")) strGender = "Mr. ";
        else if (strGender.equals("F")) strGender = "Mrs/Ms. ";
        else strGender = "Mx. ";
        System.out.println("Hello " + strGender + strName + ", " + "you are " + intAge + " years old, your height is " + dbHeight + "m.");
    }
}