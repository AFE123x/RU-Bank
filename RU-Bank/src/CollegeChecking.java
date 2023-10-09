public class CollegeChecking extends Checking {
    // all constants
    private static final double INTEREST_RATE = 0.02;
    private static final double FEE = 8.0;
    
    private enum Campus {
        //campus codes
        CAMPUS_A, CAMPUS_B;
    }
    
    private Campus campus;

    public CollegeChecking(Profile holder, double balance, String campusCode) {
        super(holder, balance);
        this.campus = Campus.valueOf(campusCode);
    }

    @Override
    public double monthlyInterest() {
        // TODO: 
        return 0; 
    }

    @Override
    public double monthlyFee() {
        // TODO:
        return 0.0;
    }

    }
