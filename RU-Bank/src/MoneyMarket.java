/**
 * Represents a Money Market account.
 */
public class MoneyMarket extends Savings {
    /** Tracks the number of withdrawals made */
    private int withdrawal;
    
    /** Constant interest rate for the money market account */
    private static final double INTEREST_RATE_MONEY_MARKET = 0.045; // 4.5%
    
    /** Minimum balance required for money market account */
    private static final double MIN_BALANCE = 2000.0;
    
    /** Maximum number of withdrawals allowed without incurring a fee */
    private static final int MAX_WITHDRAWALS = 3;
    
    /** Fee charged for excessive withdrawals */
    private static final double WITHDRAWAL_FEE = 10.0;

    /**
     * Creates a new Money Market account with the specified holder, balance, and number of withdrawals.
     * Money market accounts has a default loyalty status as True. 
     * @param holder The profile of the account holder.
     * @param balance The initial balance of the account.
     * @param withdrawal The initial number of withdrawals made.
     */
    public MoneyMarket(Profile holder, double balance, int withdrawal) {
        super(holder, balance, true); 
        this.withdrawal = withdrawal;
    }

    /**
     * Calculates the monthly interest for the Money Market account.
     * @return The monthly interest.
     */
    @Override
    public double monthlyInterest() {
        return balance * (INTEREST_RATE_MONEY_MARKET + (isLoyal ? LOYALTY_BONUS : 0));
    }

    /**
     * Calculates the monthly fee for the Money Market account.
     * @return The monthly fee.
     */
    @Override
    public double monthlyFee() {
        if (balance < MIN_BALANCE) {
            isLoyal = false;
            return WITHDRAWAL_FEE;
        } else if (withdrawal > MAX_WITHDRAWALS) {
            return WITHDRAWAL_FEE;
        }
        isLoyal = true;
        return 0;
    }

    /**
     * Withdraws the specified amount from the Money Market account.
     * @param amount The amount to be withdrawn.
     */
    public void withdraw(double amount) {
        balance -= amount;
        withdrawal++;
    }

    /**
     * Returns a string representation of the Money Market account.
     * @return A string representing the Money Market account.
     */
    @Override
    public String toString() {
        return "MoneyMarket { holder: " + holder + ", balance: " + balance + ", withdrawals: " + withdrawal + ", isLoyal: " + isLoyal + " }";
    }
}