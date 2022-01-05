public class Payroll05Driver {
    public static void main(String[] args) {
        Payroll05 jeff = new Payroll05();
        System.out.println(jeff);

        Payroll05 gabriel = new Payroll05(
                "Gabriel", "Breeding", 50, 50);
        System.out.println(gabriel);

        jeff.setFirstName("Jeff");
        jeff.setLastName("Scott");
        jeff.setHours(35);
        jeff.setRate(77);
        System.out.println(jeff);
    }
}
