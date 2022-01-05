public class Payroll01 {
    public static void main(String[] args) {
        //  Variable declarations
        String firstName    = "Jeff";
        String lastName     = "Scott";
        byte age            = 65;
        boolean isUnion     = true;
        double hours        = 40.0;
        double rate         = 25.0;
        double gross        = hours * rate;
        String output       = "";

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
