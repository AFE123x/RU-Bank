public class Checking extends Account {
    private static final double INTEREST_RATE = 0.01;
    private static final double FEE = 10.0;

    public Checking(Profile holder, double balance) {
        super(holder, balance);
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
