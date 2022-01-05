import java.util.Scanner;

public class Payroll02 {
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
        String  output;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        firstName = keyboard.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = keyboard.nextLine();

        System.out.print("Enter Age: ");
        age = keyboard.nextByte();
        while ((age < MINAGE) || (age > MAXAGE)) {
            System.out.print("Enter Age: ");
            age = keyboard.nextByte();
        }

        System.out.print("Enter Union Status (true or false)");
        isUnion = keyboard.nextBoolean();
        while ((isUnion != true) && (isUnion != false)) {
            System.out.print("Enter Union Status (true or false)");
            isUnion = keyboard.nextBoolean();
        }

        System.out.print("Enter hours (" + MINHOURS +
                                    "- " + MAXHOURS + ": ");
        hours = keyboard.nextDouble();
        while((hours < MINHOURS) || (hours > MAXHOURS)) {
            System.out.print("Enter hours (" + MINHOURS +
                    "- " + MAXHOURS + "): ");
            hours = keyboard.nextDouble();
        }

        System.out.print("Enter rate (" + MINRATE +
                "- " + MAXRATE + "): ");
        rate = keyboard.nextDouble();
        while((rate < MINRATE) || (rate > MAXRATE)) {
            System.out.print("Enter rate (" + MINRATE +
                    "- " + MAXRATE + ": ");
            rate = keyboard.nextDouble();
        }

        gross = hours * rate;

        output = "First Name: " + firstName + "\n";
        output += "Last Name: " + lastName + "\n";
        output += "Age: "       + age + "\n";
        output += "Union: "     + isUnion + "\n";
        output += "Hours: "     + hours + "\n";
        output += "Rate: "      + rate + "\n";
        output += "Gross: "     + gross + "\n";
        System.out.println(output);
    }
}
