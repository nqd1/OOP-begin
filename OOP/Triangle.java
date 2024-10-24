import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input height:");
        int n = keyboard.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println(" ".repeat(n - i - 1) + "*".repeat(2*i + 1) + '\n');
        }
    }
}