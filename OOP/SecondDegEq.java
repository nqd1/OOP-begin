import javax.swing.JOptionPane;
import java.lang.Math;
public class SecondDegEq{
    public static void main(String[] args) {
        String strA = JOptionPane.showInputDialog(null, "Input x^2 's coefficent", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strB = JOptionPane.showInputDialog(null, "Input x's coefficent", "Input", JOptionPane.INFORMATION_MESSAGE);
        String strC = JOptionPane.showInputDialog(null, "Input the free coefficent", "Input", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strA);
        double b = Double.parseDouble(strB);
        double c = Double.parseDouble(strC);

        double delta = b*b - 4*a*c;
        double x1, x2;
        String resulString = "The quadratic equation " + a + "x^2 +" + b + "x + " + c + "= 0";
        if (delta < 0) resulString = "Nah fam u'r on ur own";
        else {
            x1 =  (-b + Math.sqrt(delta)) / (2*a);
            x2 =  (-b - Math.sqrt(delta)) / (2*a);
            
            if(delta == 0) resulString += " takes x = " + x1 + " as its double root.";
            else resulString += "has two real solutions x1 = " + x1 + " and x2 = " + x2; 
        } 

        JOptionPane.showMessageDialog(null, resulString, "Solution", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}