public class AccountDatabase {
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    public AccountDatabase(){
        this.accounts = new Account[4];
        this.numAcct = 0;
    }

    /**
     * Finds the index number of an account.
     * @param account
     * @return
     */
    private int find(Account account) {
        for(int i = 0; i < numAcct; i++){
            if(accounts[i].equals(account)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Will make a new array of size accounts + 4, copy data from old array,
     * the point the old array to the new array.
     */
    private void grow() {
        Account [] temp = new Account[accounts.length + 4];
        for(int i = 0; i < accounts.length; i++){
            temp[i] = accounts[i];
        }
        accounts = temp;

    }

    /**
     * Checks if database contains given account.
     * @param account
     * @return True if account was found, False otherwise.
     */
    public boolean contains(Account account){
        return find(account) != -1;
    }
    private int find(Profile profile){
        for(int i = 0; i < numAcct; i++){
            if(accounts[i].getProfile().equals(profile)){
                return i;
            }
        }
        return -1;
    }
    private boolean contains(Profile profile){
        return find(profile) != -1;
    }

    /**
     * Given a valid account, the account will be added to database.
     * @param account
     * @return true if the account was added successfully, false otherwise.
     */
    public boolean open(Account account){
        if(account == null){
            return false;
        }
        else if(contains(account.getProfile())){
            if(typecheck(account, accounts[find(account.getProfile())])){
            System.out.printf("%s(%s) is already in the database.\n",account.getProfile().toString(),account.GetType());   
            return false;
        }
        }
        accounts[numAcct++] = account;
        if(numAcct >= accounts.length){
            grow();
        }
        System.out.printf("%s(%s) opened.\n",account.getProfile().toString(),account.GetType());
        return true;
    } //add a new account
    private Boolean typecheck(Account A, Account B){
        System.out.println("A:" + A.GetType() + ", B:" + B.GetType());
        boolean condition1 = A.GetType().equals("C") && B.GetType().equals("CC");
        boolean condition2 = A.GetType().equals("CC") && B.GetType().equals("C");
        boolean condition3 = A.GetType().equals(B.GetType());
        return condition1 || condition2 || condition3;
    }
    /**
     * Will close the account, delete account from the database.
     * @param account
     * @return
     */
    public boolean close(Account account){
        if(account != null){
            for(int i = 0; i < numAcct; i++){
            if(account.equals(accounts[i])){
                accounts[i] = null;
                numAcct--;
                shiftLeft(i);
                return true;
            }
        }
        }
        return false;
        
    } //remove the given account

    /**
     * Shifts contents of the array to the left.
     * @param index
     */
    private void shiftLeft(int index) {
        if (index >= 0 && index < numAcct) {
            for (int i = index; i < numAcct - 1; i++) {
                accounts[i] = accounts[i + 1];
            }
            accounts[numAcct - 1] = null;
        }
    }
    public boolean withdraw(Account account){
        if(account != null){
            for(int i = 0; i < numAcct; i++){
                if(account.equals(accounts[i])){
                    if(accounts[i].getbalance() > 0){

                    }
                }
            }
        }
        return false;
    } //false if insufficient fund

    /**
     * Deposits the specified amount into the given account.
     * @param account the account to which the deposit is made.
     */
    public void deposit(Account account){
        for(int i = 0; i < numAcct; i++){
            if(account.equals(accounts[i])){
                accounts[i].deposit(account.getbalance());
            }
        }
    }
    
    /**
     * Prints the list of accounts sorted by account type and profile.
     */
    public void printSorted(){
        if(numAcct < 1){
            System.out.println("Account Database is empty!");
            return;
        }
        quicksort(0, numAcct - 1);
        System.out.println("*Accounts sorted by account type and profile.");
        for(int i = 0; i < numAcct; i++){
            System.out.println(accounts[i]);
        }
        System.out.println("*end of list.");
    } //sort by account type and profile

     /**
     * Prints the interests and fees for each account.
     */
    public void printFeesAndInterests(){
        if(numAcct < 1){
            System.out.println("Account Database is empty!");
            return;
        }

    } 

    /**
     * Updates account balances by applying interests and fees.
     */
    public void printUpdatedBalances(){
        if(numAcct < 1){
            System.out.println("Account Database is empty!");
            return;
        }

    }

    private void quicksort(int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivotIndex = partition(lo, hi);
        quicksort(lo, pivotIndex - 1);
        quicksort(pivotIndex + 1, hi);
    }
    
    private int partition(int lo, int hi) {
        Account pivot = accounts[lo];
        int L = lo + 1;
        int R = hi;
        while (true) {
            while (L <= R && accounts[L].compareTo(pivot) <= 0) {
                L++;
            }
            while (R >= L && accounts[R].compareTo(pivot) > 0) {
                R--;
            }
            if (L < R) {
                swap(L, R);
            } else {
                break;
            }
        }
        swap(lo, R);
        return R;
    }
    
    private void swap(int i, int j) {
        Account temp = accounts[i];
        accounts[i] = accounts[j];
        accounts[j] = temp;
    }
    
}
