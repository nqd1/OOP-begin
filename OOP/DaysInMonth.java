import javax.swing.JOptionPane;

public class DaysInMonth {

    public static void main(String[] args) {
        String input_year = JOptionPane.showInputDialog(null, "Year?", "Input", JOptionPane.INFORMATION_MESSAGE);
        int year = Integer.parseInt(input_year);
        String febday = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? "29" : "28";
        String[][] months = {
            {"January", "Jan", "Jan.", "1", "31"},
            {"February", "Feb", "Feb.", "2", febday},
            {"March", "Mar", "Mar.", "3", "31"},
            {"April", "Apr", "Apr.", "4", "30"},
            {"May", "May", "May.", "5", "31"},
            {"June", "Jun", "Jun.", "6", "30"},
            {"July", "Jul", "Jul.", "7", "31"},
            {"August", "Aug", "Aug.", "8", "31"},
            {"September", "Sep", "Sep.", "9", "30"},
            {"October", "Oct", "Oct.", "10", "31"},
            {"November", "Nov", "Nov.", "11", "30"},
            {"December", "Dec", "Dec.", "12", "31"}
        };

        boolean validInput = false;
        while (!validInput) {
            String input_month = JOptionPane.showInputDialog(null, "Month?", "Input", JOptionPane.INFORMATION_MESSAGE);
            boolean found = false;
            for (int i = 0; i < months.length; i++) {
                if (input_month.equalsIgnoreCase(months[i][0]) || input_month.equalsIgnoreCase(months[i][1]) || 
                    input_month.equalsIgnoreCase(months[i][2]) || input_month.equals(months[i][3])) {
                    JOptionPane.showMessageDialog(null, months[i][0] + " has " + months[i][4] + " days.");
                    found = true;
                    validInput = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "Invalid input, please re-enter!");
            }
        }
    }
}
