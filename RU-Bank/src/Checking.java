public class Checking extends Account {
    private static final double INTEREST_RATE = 0.01;
    private static final double FEE = 12.0;

    public Checking(Profile holder, double balance) {
        super(holder, balance);
    }
    public static Checking makeChecking(String [] input){
        try {
            Profile profile = Profile.makeProfile(input);
            double balance = !input[0].equals("C") ? Double.parseDouble(input[4]) : null;
            return new Checking(profile,balance);
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public double monthlyInterest() { 
        return balance * (INTEREST_RATE/12.0);
    }


    @Override
    public double monthlyFee() {
        if(balance <= 1000){
            return 0;
        }
        return FEE;
    }
    
    @Override
    public String toString() {
        return "Checking::" + holder + "::Balance $" + balance;
        }
    }
