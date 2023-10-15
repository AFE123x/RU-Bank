public class Checking extends Account {
    private static final double INTEREST_RATE = 0.01;
    private static final double FEE = 10.0;

    public Checking(Profile holder, double balance) {
        super(holder, balance);
    }
    public static Checking makeChecking(String [] input){
        try {
            Profile profile = Profile.makeProfile(input);
            if(profile == null){throw new ArrayIndexOutOfBoundsException();}
            double balance = !input[0].equals("C") ? Double.parseDouble(input[5]) : null;
            if (balance <= 0){
                System.out.println("Initial deposit cannot be 0 or negative.");
                return null;
            }
            return new Checking(profile,balance);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Missing data for opening an account.");
            return null;
        } catch(NumberFormatException e){
            System.out.println("Not a valid amount.");
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
    @Override
    public String gettype() {
        return "C";
    }
}
