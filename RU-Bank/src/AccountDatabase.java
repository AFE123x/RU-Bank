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

    /**
     * Given a valid account, the account will be added to database.
     * @param account
     * @return true if the account was added successfully, false otherwise.
     */
    public boolean open(Account account){
        if(account == null){
            return false;
        }
        else if(contains(account)){
            System.out.printf("");
        }
        accounts[numAcct++] = account;
        if(numAcct >= accounts.length){
            grow();
        }
        System.out.printf("%s(%s) opened.\n",account.getProfile().toString(),account.GetType());
        return true;
    } //add a new account

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

    /**
     * Sorts the accounts using the quicksort algorithm.
     * @param lo the starting index.
     * @param hi the ending index.
     */
    private void quicksort(int lo, int hi){
        if(lo >= hi){
            return;
        }
        Account pivot = accounts[lo];
        int L = lo + 1;
        int R = hi;
        while(L <= R){
            while(accounts[L].compareTo(pivot) <= 0){
                L++;
            }
            while(accounts[R].compareTo(pivot) > 0){
                R--;
            }
            if(L < R){
                swap(accounts[L],accounts[R]);
            }
        }
            swap(accounts[R],pivot);
            quicksort(lo, R-1);
            quicksort(R+1, hi);
    }

    /**
     * Swaps the positions of two accounts in the array.
     * @param a the first account.
     * @param b the second account.
     */
    private void swap(Account a, Account b) {
        Account temp = a;
        a = b;
        b = temp;
    }
}
