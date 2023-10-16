import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransactionManager {
    private Scanner scanner;
    private String decision;
    private AccountDatabase accountDatabase;
    public TransactionManager() throws FileNotFoundException{
        // this.scanner = new Scanner(System.in);
        this.scanner = new Scanner(new File("../Testcases/input.txt"));
        System.out.println("Transaction Manager is running.");
        accountDatabase = new AccountDatabase();
    }

    public void run() throws InterruptedException{
        while(true){
            Thread.sleep(100);
            decision = scanner.nextLine();
            System.out.println(decision);
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
            System.out.println(e.getMessage());
            return null;
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
