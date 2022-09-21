/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
public class YourFirstAccount {

    public static void main(String[] args) {
       // Do not touch the code in Account.java
        // Write your program here
        Account account = new Account("account", 100.00);
        
        account.deposit(20.00);
        
        System.out.println(account);
        
    }
}
