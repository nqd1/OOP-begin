import javax.swing.JOptionPane;

public class SystemOf1stDegEqs_2var {

    public static void main(String[] args) {
        //input
        String str_a11 = JOptionPane.showInputDialog(null, "Input x's first coefficient: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        String str_a12 = JOptionPane.showInputDialog(null, "Input y's first coefficient: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        String str_b1 = JOptionPane.showInputDialog(null, "Input the first result: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        String str_a21 = JOptionPane.showInputDialog(null, "Input x's second coefficient: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        String str_a22 = JOptionPane.showInputDialog(null, "Input y's second coefficient: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        String str_b2 = JOptionPane.showInputDialog(null, "Input the second coefficient: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        //string to num
        double a11 = Double.parseDouble(str_a11);
        double a12 = Double.parseDouble(str_a12);
        double b1 = Double.parseDouble(str_b1);
        double a21 = Double.parseDouble(str_a21);
        double a22 = Double.parseDouble(str_a22);
        double b2 = Double.parseDouble(str_b2);
        String resulString;
        //calculating
        double D = a11*a22 - a21*a12;
        double Dx = b1*a22 - b2*a12;
        double Dy = a11*b2 - a21*b1;
        double x, y;
        if (D == 0){
            if (Dx == Dy && Dx == 0){
                resulString = "Infinite solutions";
            }
            else resulString = "No solutions";
        }
        else {
            x = Dx / D;
            y = Dy / D;
            resulString = "(x, y) = (" + x + ", " + y + ") is the solution of the system of two 1st deg equation: \n"  
                                    + a11 + "x + " + a12 + "y = " + b1 + "\n"
                                    + a21 + "x + " + a22 + "y = " + b2;
        }
            JOptionPane.showMessageDialog(null, resulString, "Solution", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        
    }
}