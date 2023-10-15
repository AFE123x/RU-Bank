public class CollegeChecking extends Checking {
    // all constants
    private static final double INTEREST_RATE = 0.01;
    private static final double FEE = 0.0;
    
    private enum Campus {
        NEW_BRUNSWICK("0", "New Brunswick"),
        NEWARK("1", "Newark"),
        CAMDEN("2", "Camden");
        private final String value;
        private final String name;

        Campus(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }
    //0 – New Brunswick, 1 – Newark, 2 – Camden
    
    private Campus campus;

    public CollegeChecking(Profile holder, double balance, String campusCode) {
        super(holder, balance);
        switch(campusCode){
            case "0":
                this.campus = Campus.NEW_BRUNSWICK;
                break;
            case "1":
                this.campus = campus.NEWARK;
                break;
            case "2":
                this.campus = campus.CAMDEN;
                break;
            default:
                this.campus = null;
                break;
        }
    }
    public static CollegeChecking makeCollegeChecking(String [] input) throws NumberFormatException, IndexOutOfBoundsException{
            Profile profile = Profile.makeProfile(input);
            if(profile == null){
                return null;
            }
            if(!profile.getDob().checkCollegeCheckingValidity()){
            return null;
            }
            
            double tempbalance = !input[0].equals("C") ? Double.parseDouble(input[5]) : null;
            String tempcampusCode = input[0].equals("O") ? input[6] : null;
            if(tempbalance <= 0){throw new IllegalArgumentException("Initial deposit cannot be 0 or negative.");}
            return new CollegeChecking(profile, tempbalance, tempcampusCode);
    }

    @Override
    public double monthlyInterest() {
        return balance * (INTEREST_RATE/12);
    }

    @Override
    public double monthlyFee() {
        return FEE;
    }
    public String GetType(){
        return "CC";
    }
    //College Checking::Roy Brooks 10/31/1999::Balance $2,909.10::NEWARK
    //TO DO
    public String toString() {
        String temp =  "College Checking::" + holder + "::Balance $" + balance;
        return temp;
        }
    }
