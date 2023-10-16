import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Represents a manager for executing various transactions on accounts.
 * It reads transactions from a file and processes them.
 * Supported transactions include: open, close, deposit, withdraw, print, and others.
 * 
 * @author Digvijay Singh, Arun Felix
 */
public class TransactionManager {
    private Scanner scanner;
    private String decision;
    private AccountDatabase accountDatabase;

    /**
     * Constructs a new TransactionManager that initializes the account database
     * and sets up the scanner to read from an input file.
     * 
     * @throws FileNotFoundException if the input file cannot be found.
     */
    public TransactionManager() throws FileNotFoundException{
        // this.scanner = new Scanner(System.in);
        this.scanner = new Scanner(new File("../Testcases/input1.txt"));
        System.out.println("Transaction Manager is running.");
        accountDatabase = new AccountDatabase();
    }

      /**
     * Continuously reads and processes transactions from the input file.
     * For each transaction, it sleeps for a second and then proceeds.
     * 
     * @throws InterruptedException if the thread sleep is interrupted.
     */
    public void run() throws InterruptedException{
        while(true){
            // Thread.sleep(100);
            decision = scanner.nextLine();
            // System.out.println(decision);
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
                    break;
                case "PI":
                    accountDatabase.printFeesAndInterests();
                    break;
                case "UB":
                    accountDatabase.printUpdatedBalances();
                    break;
                case "Q":
                    return;
                case "":
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;

            }

        }
    }
    /**
     * Parses the transaction input to create the appropriate account type.
     * This method supports creating accounts of types: Checking, CollegeChecking, Savings, MoneyMarket.
     * 
     * @param input an array of strings representing the transaction data.
     * @return the created account or null if the transaction data is invalid.
     */
    private Account parse(String[] input) {
        Account account;
        try {
            switch (input[1]) {
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
            return account; 
        } catch (NumberFormatException e){
            System.out.println("Not a valid amount.");
            return null;
        } catch (IndexOutOfBoundsException e) {
            switch(input[0]){
                case "C":
                    System.out.println("Missing data for closing an account.");
                    break;
                default:
                    System.out.println("Missing data for opening an account.");
                    break;
            }
            return null;
        } catch (IllegalArgumentException e) {
            // System.out.println(e.getMessage());
            return null;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
