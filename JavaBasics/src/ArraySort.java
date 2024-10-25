import java.util.Scanner;
import java.util.Arrays;
//this vs static?  
public class ArraySort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int array[], size;
        System.out.println("Size of array?");
        size = sc.nextInt();
        
        array = new int[size];
        int sum = 0;
        double avg = 0;
        System.out.println("Input array's element: ");
        
        for (int i = 0; i < size; i++){
            array[i] = sc.nextInt();
            sum += array[i];
        }
        String org = Arrays.toString(array);

        Arrays.sort(array);
        String out = Arrays.toString(array);
        System.out.println(    "Original array:\t" + org 
                            +"\nAfter sorting:\t" + out 
                            +"\nSum: " + sum 
                            +"\nAverage: " + sum/size);

    }
}