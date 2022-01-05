import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Payroll04 {
    //  Global Constants
    static final int    MINAGE   =  21;
    static final int    MAXAGE   = 120;
    static final double MINHOURS =   0.00;
    static final double MAXHOURS =  84.0;
    static final double MINRATE  =   0.00;
    static final double MAXRATE  =  99.99;
    static final double MAXNONOT =  40.00;
    static final double OTRATE   =   1.5;
    static final int    TOTEMPS  =   3;

    //  Global Variables
    static double totGrossPay    = 0.0;
    static DecimalFormat pattern1 = new DecimalFormat("$###,###,##0.00");
    static DecimalFormat pattern2 = new DecimalFormat("###,###,##0.00");

    public static void main(String[] args) {
        //  Variable declarations
        String  firstName;
        String  lastName;
        byte    age;
        boolean isUnion;
        double  hours;
        double  rate;
        double  gross;

        for (int lcv = 0; lcv < TOTEMPS; ++lcv) {
            firstName = inputFirstName();
            lastName  = inputLastName();
            age       = inputAge();
            isUnion   = inputIsUnion();
            hours     = inputHours();
            rate      = inputRate();
            gross     = calculateGross(hours, rate);
            displayAll(firstName, lastName, age, isUnion,
                       hours, rate, gross);
        }

        displayTotalGross();
    }

    public static String inputFirstName() {
        String fn = "";
        do {
            fn = JOptionPane.showInputDialog("Input First Name:");
            fn = fn.trim();
        }  while (fn.equals(""));

        return fn;
    }

    public static String inputLastName() {
        String ln = "";
        do {
            ln = JOptionPane.showInputDialog("Input Last Name:");
            ln = ln.trim();
        }  while (ln.equals(""));

        return ln;
    }

    public static byte inputAge() {
        String input  = JOptionPane.showInputDialog(
                "Enter age (21 - 120): ");
        byte a = Byte.parseByte(input);

        while ((a < MINAGE) || (a > MAXAGE)) {
            input  = JOptionPane.showInputDialog(
                    "Enter age (21 - 120): ");
            a = Byte.parseByte(input);
        }

        return a;
    }

    public static boolean inputIsUnion() {
        String input  = JOptionPane.showInputDialog(
                "Enter union status (true or false): ");
        boolean iu = Boolean.parseBoolean(input);

        while ((iu != true) && (iu != false)) {
            input  = JOptionPane.showInputDialog(
                    "Enter union status (true or false): ");
            iu = Boolean.parseBoolean(input);
        }

        return iu;
    }

    public static double inputHours() {
        String input  = JOptionPane.showInputDialog(
                "Enter hours worked (0 - 84): ");
        double hw = Double.parseDouble(input);

        while ((hw < MINHOURS) || (hw > MAXHOURS)) {
            input  = JOptionPane.showInputDialog(
                    "Enter hours worked (0 - 84): ");
            hw = Double.parseDouble(input);
        }

        return hw;
    }

    public static double inputRate() {
        String input  = JOptionPane.showInputDialog(
                "Enter hourly rate (0 - 99.99): ");
        double hr = Double.parseDouble(input);

        while ((hr < MINRATE) || (hr > MAXRATE)) {
            input  = JOptionPane.showInputDialog(
                    "Enter hourly rate (0 - 99.99): ");
            hr = Double.parseDouble(input);
        }

        return hr;
    }

    public static double calculateGross(double h, double r) {
        double gp = 0.0;

        if (h < MAXNONOT) { //  No Overtime
            gp = h * r;
        }
        else {
            gp = ((MAXNONOT * r) +
                    ((h - MAXNONOT) * r * OTRATE));
        }

        totGrossPay += gp;

        return gp;
    }

    public static void displayAll(String first, String last,
                                  byte a, boolean iu,
                                  double hw, double hr,
                                  double g) {
        String output = "First Name: " + first + "\n";
               output += "Last Name: " + last  + "\n";
               output += "Age: "       + a     + "\n";
               output += "Union: "     + iu    + "\n";
               output += "Hours: "     + pattern2.format(hw)    + "\n";
               output += "Rate: "      + pattern1.format(hr)    + "\n";
               output += "Gross: "     + pattern1.format(g)     + "\n";
        JOptionPane.showMessageDialog(null, output);
    }

    public static void displayTotalGross() {
        JOptionPane.showMessageDialog(null,
                                      "Total Gross Pay: " +
                                              pattern1.format(totGrossPay));
    }
}
