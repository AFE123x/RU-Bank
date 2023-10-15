public class Checking extends Account {
    private static final double INTEREST_RATE = 0.01;
    private static final double FEE = 12.0;

    public Checking(Profile holder, double balance) {
        super(holder, balance);
    }
    public static Checking makeChecking(String [] input) throws NumberFormatException, IndexOutOfBoundsException, NullPointerException{
            Profile profile = Profile.makeProfile(input);
            Boolean exists = !input[0].equals("C") ? true : false;
            double balance = exists ? Double.parseDouble(input[5]) : null;
            
            if(balance <= 0){System.out.println("Initial deposit cannot be 0 or negative.");}
            return (!exists || balance > 0 )? new Checking(profile,balance) : null;
    }
    public String GetType(){
        return "C";
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
