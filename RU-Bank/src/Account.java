public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;
    public abstract double monthlyInterest();
    public abstract double monthlyFee();

    public Account(Profile holder, double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    public void deposit(double amount){
        balance += amount;
    }
    public double getbalance(){
        return balance;
    }

    @Override
    public int compareTo(Account otherAccount) {
        // TODO: 
        return 0;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Account){
            Account temp = (Account)obj;
            return this.compareTo(temp) == 0;
        }
        
            return false;
        
     }

}
