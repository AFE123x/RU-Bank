public class AccountDatabase {
    private Account [] accounts; //list of various types of accounts
    private int numAcct; //number of accounts in the array
    public AccountDatabase(){
        this.accounts = new Account[4];
        this.numAcct = 0;
    }
    private int find(Account account) {
        for(int i = 0; i < numAcct; i++){
            if(accounts[i].equals(account)){
                return i;
            }
        }
        return -1;
    } 
    private void grow() {
        Account [] temp = new Account[accounts.length + 4];
        for(int i = 0; i < accounts.length; i++){
            temp[i] = accounts[i];
        }
        accounts = temp;

    }
    public boolean contains(Account account){
        return find(account) != -1;
    }
    public boolean open(Account account){
        if(account == null){
            return false;
        }
        accounts[numAcct++] = account;
        if(numAcct >= accounts.length){
            grow();
        }
        return true;
    } //add a new account
    public boolean close(Account account){
        if(account != null){
            for(int i = 0; i < numAcct; i++){
            if(account.equals(accounts[i])){
                accounts[i] = null;
                numAcct--;
                return true;
            }
        }
        }
        return false;
        
    } //remove the given account
    public boolean withdraw(Account account){
        if(account != null){
            for(int i = 0; i < numAcct; i++){
                if(account.equals(accounts[i])){
                    if(accounts[i].balance )
                }
            }
        }
    } //false if insufficient fund
    public void deposit(Account account){

    }
    public void printSorted(){

    } //sort by account type and profile
    public void printFeesAndInterests(){

    } //calculate interests/fees
    public void printUpdatedBalances(){

    } //apply the interests/fees
}