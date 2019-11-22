import java.text.DecimalFormat;

public class BankAccount2 {

  DecimalFormat fmt = new DecimalFormat("#0.00");
  private String pin;
  private String username;
  private String password;
  private double minBal;
  private double currentBal;
  private double interestRate;

  public BankAccount2(String iPin, String iUsername, String iPassword, double iMinBal, double iCurrentBal, double iInterestRate) {
    pin = iPin;
    username = iUsername;
    password = iPassword;
    minBal = iMinBal;
    currentBal = iCurrentBal;
    interestRate = iInterestRate;
  }

  public String getPin() { return pin; }
  public String getUsername() { return username; }
  public String getPassword() { return password; }
  public double getMinBal() { return minBal; }
  public double getBalance() { return currentBal; }
  public double getInterest() { return interestRate; }

  public void setUsername(String newUsername) { username = newUsername; }
  public void setPassword(String newPassword) { password = newPassword; }
  public void setMinBal(double iMinBal) { minBal = (iMinBal > 0 ? iMinBal : 0); }
  public void setInterestRate(double iInterest) { interestRate = iInterest; }

  public boolean testPassword(String testPass) {
    return testPass == password;
  }

  public void deposit(double amt) {
    currentBal += amt;
  }

  public void withdraw(double amt) {
    if (currentBal - amt < minBal) {
      currentBal = minBal;
      System.out.println("# ERROR: Could not withdraw past minimum balance of $" + fmt.format(minBal));
    }
    else {
      currentBal -= amt;
    }
  }

  public void compoundInterest() {
    currentBal += (currentBal * (interestRate/100.0));
  }

  public String toString() {
    return ("User " + username + " has balance $" + currentBal + ".");
  }
}
