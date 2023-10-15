import java.util.Scanner;

public class TransactionManager {
    private Scanner scanner;
    private String decision;
    private AccountDatabase accountDatabase;
    public TransactionManager(){
        this.scanner = new Scanner(System.in);
        System.out.println("Transaction Manager is running.");
        accountDatabase = new AccountDatabase();
    }

    public void run(){
        while(true){
            decision = scanner.nextLine();
            String[] decisionArray = decision.split("\\s+");

            switch(decisionArray[0]){
                case "O":
                    accountDatabase.open(parse(decisionArray));
                    break;
                case "C":
                    accountDatabase.close(parse(decisionArray));
                    break;
                case "D":
                    accountDatabase.deposit(parse(decisionArray));
                    break;
                case "W":
                    accountDatabase.withdraw(parse(decisionArray));
                    break;
                case "P":
                    accountDatabase.printSorted();
                case "PI":
                    break;
                case "UB":
                    accountDatabase.printUpdatedBalances();
                    break;
                case "Q":
                    return;
                default:
                    System.out.println("Invalid command!");
                    break;

            }

        }
    }
    private Account parse(String[] input) {
        Account account;
        try {
            switch (input[0]) {
                case "C":
                    account =  Checking.makeChecking(input);
                    break;
                case "CC":
                    account = CollegeChecking.makeCollegeChecking(input);
                    break;
                case "S":
                    account = Savings.makeSavings(input);
                    break;
                case "MM":
                    account  = MoneyMarket.makeMoneyMarket(input);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid account type");
            }
            if (account != null) {
                System.out.println(account.getHolder() + " (" + account.getClass().getSimpleName() + ") opened.");
            }
            return account; 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Display the error message
            return null;
        }
    }



}
