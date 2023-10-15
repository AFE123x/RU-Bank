/**
 * Represents an abstract account with basic functionalities.
 * This class provides a foundation for different types of bank accounts.
 * Subclasses should provide implementations for monthly interest and monthly fee calculations.
 */
public abstract class Account implements Comparable<Account> {
    
    /** The profile associated with this account. */
    protected Profile holder;
    
    /** The current balance of this account. */
    protected double balance;

    /**
     * Constructs a new account with the specified profile and balance.
     * 
     * @param holder The profile associated with this account.
     * @param balance The initial balance of the account.
     */
    public Account(Profile holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }

    /**
     * Calculates the monthly interest for this account.
     * 
     * @return The monthly interest amount.
     */
    public abstract double monthlyInterest();

    /**
     * Calculates the monthly fee for this account.
     * 
     * @return The monthly fee amount.
     */
    public abstract double monthlyFee();

    /**
    * Creates an Account object based on the given input data.
    *
    * @param input An array of strings containing the information needed to create an account.
    *              The first element in the array determines the account type.
    * @return An instance of the appropriate Account subclass based on the account type.
    * @throws IllegalArgumentException if the account type provided in the input is not recognized.
    */
    public static Account makeAccount(String[] input) {

       // Check if the account type is 'C' for Checking.
       if (input[0].equals("C")) {
           // Create and return a Checking account using the provided data.
           return Checking.makeAccount(input);

       // Check if the account type is 'CC' for College Checking.
       } else if (input[0].equals("CC")) {
           // Create and return a College Checking account using the provided data.
           return CollegeChecking.makeAccount(input);

       // Check if the account type is 'S' for Savings.
       } else if (input[0].equals("S")) {
           // Create and return a Savings account using the provided data.
           return Savings.makeAccount(input);

       // Check if the account type is 'MM' for Money Market.
       } else if (input[0].equals("MM")) {
           // Create and return a Money Market account using the provided data.
           return MoneyMarket.makeAccount(input);

       } else {
           // If the account type provided does not match any of the known types, throw an exception.
           throw new IllegalArgumentException("Invalid account type");
       }
    } 

    /**
     * Deposits the specified amount to this account.
     * 
     * @param amount The amount to deposit.
     */
    public void deposit(double amount){
        balance += amount;
    }

    /**
     * Retrieves the current balance of this account.
     * 
     * @return The current balance.
     */
    public double getbalance(){
        return balance;
    }

    /**
     * Compares this account to another account. 
     * This method should be implemented to define the ordering among accounts, e.g., based on holder's name or balance.
     * 
     * @param otherAccount The other account to compare with.
     * @return A negative integer, zero, or a positive integer as this account is less than, equal to, or greater than the specified account.
     */
    @Override
    public int compareTo(Account otherAccount) {
        int lnameComparison = this.holder.getLname().compareTo(otherAccount.holder.getLname());
    
        if(lnameComparison != 0) {
            return lnameComparison;
        }

        int fnameComparison = this.holder.getFname().compareTo(otherAccount.holder.getFname());
    
        if(fnameComparison != 0) {
            return fnameComparison;
        }

        return this.holder.getDob().compareTo(otherAccount.holder.getDob());
    }

    /**
     * Checks whether this account is equal to another object.
     * 
     * @param obj The object to check equality with.
     * @return true if the objects are the same or represent the same account, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Account){
            Account temp = (Account)obj;
            return this.compareTo(temp) == 0;
        }
        return false;
    }
}
