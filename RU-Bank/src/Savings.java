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


    public static Savings makeSavings(String [] input){
        //toDo
        return null;
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
        return "Savings { holder: " + holder + ", balance: " + balance + ", isLoyal: " + isLoyal + " }";
    }


    @Override
    public String gettype() {
       return "S";
    }
    
}
