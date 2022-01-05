import javax.swing.JOptionPane;

public class Payroll03 {
    public static void main(String[] args) {
        //  Constants
        final int    MINAGE   =  21;
        final int    MAXAGE   = 120;
        final double MINHOURS =   0.00;
        final double MAXHOURS =  84.0;
        final double MINRATE  =   0.00;
        final double MAXRATE  =  99.99;

        //  Variable declarations
        String  firstName;
        String  lastName;
        byte    age;
        boolean isUnion;
        double  hours;
        double  rate;
        double  gross;
        String  input;
        String  output;

        firstName = JOptionPane.showInputDialog("Enter first name");
        lastName  = JOptionPane.showInputDialog("Enter last name");
        input     = JOptionPane.showInputDialog("Enter age (21 - 120): ");
        age       = Byte.parseByte(input);
        input     = JOptionPane.showInputDialog(
                "Enter union status (true or false): ");
        isUnion   = Boolean.parseBoolean(input);
        input     = JOptionPane.showInputDialog(
                "Enter hours worked (0 - 84): ");
        hours     = Double.parseDouble(input);
        input     = JOptionPane.showInputDialog(
                "Enter hourly rate (0 - 99.99): ");
        rate      = Double.parseDouble(input);
        gross     = hours * rate;

        output = "First Name: " + firstName + "\n";
        output += "Last Name: " + lastName + "\n";
        output += "Age: "       + age + "\n";
        output += "Union: "     + isUnion + "\n";
        output += "Hours: "     + hours + "\n";
        output += "Rate: "      + rate + "\n";
        output += "Gross: "     + gross + "\n";
        JOptionPane.showMessageDialog(null, output);
    }
}
