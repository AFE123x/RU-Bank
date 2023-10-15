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
     * A factory method to create and return an Account instance based on the provided input.
     * This method should be overridden by concrete subclasses of Account.
     * 
     * @param input The data or parameters required to create an Account.
     * @return An instance of Account or its subclass, or null if the account cannot be created.
     */
    public static Account makeAccount(String[] input) {
        return null;  // By default, return null. Subclasses should override this method.
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
