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
//                    accountDatabase.printSorted();
                    break;
                case "UB":
                    accountDatabase.printUpdatedBalances();
                    break;
                case "":
                    break;
                case "Q":
                    return;
                default:
                    System.out.println("Invalid command!");
                    break;

            }

        }
    }
    private Account parse(String[] input){
        try {
            switch(input[1]){
                case "C":
                    return Checking.makeChecking(input);
                case "CC":
                    return CollegeChecking.makeCollegeChecking(input);
                case "S":
                    break;
                case "MM":
                    break;
                default:
                    return null;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Not enough data");
            return null;
        }
        return null;
        
    }



}
