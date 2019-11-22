import java.text.DecimalFormat;

public class BankAccount {

    DecimalFormat fmt = new DecimalFormat("#0.00");
    private int pin;
    private String username;
    private double currentBal;
    private double interestRate;

    public BankAccount(int iPin, String iUsername, double iInterestRate) {
        pin = iPin;
        username = iUsername;
        interestRate = iInterestRate;
    }

    public int getPin() { return pin; }
    public String getUsername() { return username; }
    public double getBalance() { return currentBal; }
    public double getInterest() { return interestRate; }

    public void setUsername(String newUsername) { username = newUsername; }
    public void setPin(int newPin) { pin = newPin; }
    public void setInterestRate(double iInterest) { interestRate = iInterest; }

    public void deposit(double amt) {
        currentBal += amt;
    }

    public void withdraw(double amt) {
        if (currentBal - amt < 0) {
            currentBal = 0;
            System.out.println("# ERROR: Could not withdraw past $0");
        }
        else {
            currentBal -= amt;
        }
    }

    public void compoundInterest() {
        currentBal += ((int)(currentBal * interestRate)/100.0);
    }

    public String toString() {
        return ("User " + username + " has balance $" + currentBal + ". \n" + "PIN: " + pin + "\nInterest Rate: " + interestRate + "%");
    }
}
