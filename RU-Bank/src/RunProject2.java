import java.io.FileNotFoundException;
/**
 * This is the entry point for the Project2 application.
 * It creates an instance of the TransactionManager and invokes its run method to
 * process transactions.
 * 
 * Arun Felix, Digvijay Singh
 */
public class RunProject2 {

    /**
     * The main method to start the application.
     * 
     * @param args command-line arguments (not used in this application).
     * @throws FileNotFoundException if the input file for transactions cannot be found.
     * @throws InterruptedException if the thread sleep in TransactionManager is interrupted.
     */
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        new TransactionManager().run();
    }
}
