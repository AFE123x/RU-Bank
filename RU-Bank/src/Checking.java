public class Checking extends Account {
    private static final double INTEREST_RATE = 0.01;
    private static final double FEE = 10.0;

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
        // TODO: 
        return 0; 
    }


    @Override
    public double monthlyFee() {
        // TODO:
        return 0; 
    }
}
