/*

Methods:

The client should be able to add or subtract money from their bank account.
They should be able to get their pin.
They should be able to see the amount of money in their account.
They should be able to check their interest rate.
They should be able to call account.compoundInterest(), which compounds interest.
They should be able to change their password, but not get their current one.
They should be able to check if their password equals something.
They should be able to check and change their minimum balance.

toString:

Account username, current balance

Variables:

They should set a pin on initialization.
They should set a username and password.
They should set a minimum balance.
They should set a starting balance.
They should set an interest rate.

*/
import java.text.DecimalFormat;

public class BankAccountClient {
  public static void main(String[] args) {
    DecimalFormat fmt = new DecimalFormat("#0.00");
    BankAccount2 myAccount = new BankAccount2("6704928", "IanB", "12345", 100.0, 100.0, 0.5);
    BankAccount2 hisAccount = new BankAccount2("4983754", "ZackS", "76543", 1000.0, 2500.0, 1.0);

    System.out.println(myAccount.toString());
    System.out.println();

    System.out.println("Is my password 123456? " + Boolean.toString(myAccount.testPassword("123456")));

    myAccount.deposit(20.0);
    System.out.println("My account's balance after adding $20: $" + fmt.format(myAccount.getBalance()));
    myAccount.withdraw(40.0); // should print "subtracted 20.0, minimum balance is 100.0."
    System.out.println("My account's balance after subtracting $40: $" + fmt.format(myAccount.getBalance()));

    System.out.println("My minimum balance: $" + fmt.format(myAccount.getMinBal()));
    myAccount.setMinBal(50.0);
    System.out.println("My minimum balance is now: $" + fmt.format(myAccount.getMinBal()));

    System.out.println("My pin: " + myAccount.getPin());

    myAccount.setPassword("123456");

    System.out.println();
    System.out.println("His password: " + hisAccount.getPassword());
    hisAccount.setUsername("ZachS");

    System.out.println("His interest rate: $" + fmt.format(hisAccount.getInterest()));
    System.out.println("His current balance: $" + fmt.format(hisAccount.getBalance()));
    hisAccount.deposit(160.0);
    hisAccount.compoundInterest();
    System.out.println("His balance after deposit and interest: $" + fmt.format(hisAccount.getBalance()));
  }
}
