import java.text.DecimalFormat;

public class Payroll05 {
    //  Global Constants
    private static final int    MINAGE   =  21;
    private static final int    MAXAGE   = 120;
    private static final double MINHOURS =   0.00;
    private static final double MAXHOURS =  84.0;
    private static final double MINRATE  =   0.00;
    private static final double MAXRATE  =  99.99;
    private static final double MAXNONOT =  40.00;
    private static final double OTRATE   =   1.5;
    private static final int    TOTEMPS  =   3;

    //  Class Variables
    private static DecimalFormat pattern1 = new DecimalFormat("$###,###,##0.00");
    private static DecimalFormat pattern2 = new DecimalFormat("###,###,##0.00");     //  Variable declarations
    private String  firstName;
    private String  lastName;
    private double  hours;
    private double  rate;
    private double  gross;

    //  No-Arg Constructor
    public Payroll05() {
        this.firstName = "FNU";
        this.lastName  = "LNU";
        this.hours     = 0.0;
        this.rate      = 0.0;
    }

    //  Full-Arg Constructor
    public Payroll05(String fn, String ln, double h, double r) {
        //this.firstName = fn;
        //this.lastName  = ln;
        //this.hours     = h;
        //this.rate      = r;

        //this.firstName = (!fn.equals("")) ? fn : "FNU";
        //this.lastName  = (!ln.equals("")) ? ln : "LNU";
        //this.hours     = ((h >= MINHOURS) && (h <= MAXHOURS)) ? h : 0.0;
        //this.rate      = ((r >= MINRATE)  && (r <= MAXRATE))  ? r : 0.0;
        setFirstName(fn);
        setLastName(ln);
        setHours(h);
        setRate(r);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (!firstName.equals("")) ? firstName : "FNU";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (!lastName.equals("")) ? lastName : "LNU";
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = ((hours >= MINHOURS) && (hours <= MAXHOURS)) ? hours : 0.0;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = ((rate >= MINRATE)  && (rate <= MAXRATE))  ? rate : 0.0;
    }

    public double getGrossPay() {
        if (getHours() <= MAXNONOT) {   //  No Overtime
            gross = getHours() * getRate();
        } else {                          //  Worked Overtime
            gross = ((getRate() * MAXNONOT) +
                    ((getHours() - MAXNONOT) * getRate() * OTRATE));
        }

        return gross;
    }

    @Override
    public String toString() {
        return "Payroll05 {" +
                "firstName ='"  + getFirstName() + '\'' +
                ", lastName ='" + getLastName() + '\'' +
                ", hours ="     + pattern2.format(getHours()) +
                ", rate ="      + pattern1.format(getRate()) +
                ", gross ="     + pattern1.format(getGrossPay()) +
                '}';
    }
}
