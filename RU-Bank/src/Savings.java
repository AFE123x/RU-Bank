/**
 * Represents a Savings account type which extends the base Account class.
 * The Savings account has properties that determine if the account holder 
 * is loyal, the interest rates for the savings account, a bonus interest rate 
 * for loyal customers, a monthly fee for balances less than the minimum 
 * balance, and the minimum balance required to avoid a monthly fee.
 *
 * @author Digvijay Singh, Arun Felix
 */
public class Savings extends Account{

    /** Represents if the account holder has loyal customer status */
    protected boolean isLoyal;

    /** Constant interest rate for the savings account */
    private static final double INTEREST_RATE = 0.04;

    /** Bonus interest rate for loyal customers */
    protected static final double LOYALTY_BONUS = 0.0025;

    /** Monthly fee if the required balance is less than $500*/
    private static final double FEE = 25;

    /** Minimum balance required to avoid monthly fee */
    private static final double MIN_BALANCE_REQUIRED = 500.0;


    /**
     * Creates a new Savings account with the specified holder, balance and loyalty status.
     * @param holder The profile of the account holder.
     * @param balance The initial balance of the account.
     * @param isLoyal The loyalty status of the account holder.
     */
    public Savings(Profile holder, double balance, boolean isLoyal) {
        super(holder, balance);
        this.isLoyal = isLoyal;
    }

 
    public static Savings makeSavings(String [] input) throws NumberFormatException, IndexOutOfBoundsException{
        
        Profile profile = Profile.makeProfile(input);
        if(profile == null){throw new IllegalArgumentException();}
        Boolean isLoyal;
            Boolean exists = input[0].equals("C") ? false : true;
            // System.out.println(exists);
            double balance = exists? Double.parseDouble(input[5]) : 0.0;
            // System.out.println(exists);
            if(exists == true && balance <= 0){System.out.println("Initial deposit cannot be 0 or negative."); return null;};
            isLoyal = input[0].equals("O") ? Integer.parseInt(input[6]) == 1 : null;
            return new Savings(profile, balance, isLoyal);

    }

     /**
     * Calculates the monthly interest for the Savings account.
     * @return The monthly interest.
     */
    @Override
    public double monthlyInterest() {
        return balance * (INTEREST_RATE + (isLoyal ? LOYALTY_BONUS : 0));
    }

    /**
     * Calculates the monthly fee for the Savings account.
     * @return The monthly fee.
     */
    @Override
    public double monthlyFee() {
        return balance >= MIN_BALANCE_REQUIRED ? 0 : FEE;     
    }

    
    public String GetType(){
        return "S";
    }

    
    /**
    * Retrieves the loyalty bonus associated with the Savings account.
    * 
    * @return the loyal customer bonus as a percentage
    */
    protected double getLoyaltyBonus() {
        return LOYALTY_BONUS;
    }

    /**
     * Returns a string representation of the Savings account.
     * @return A string representing the Savings account.
     */
    @Override
    public String toString() {
        //Savings::Jane Doe 10/1/1995::Balance $1,000.00
        if(!isLoyal){
            return "Savings::" + holder + "::Balance $" + balance;
        }
        else{
            return "Savings::" + holder + "::Balance $" + balance + "::is loyal";
        }
        
    }
    
}
