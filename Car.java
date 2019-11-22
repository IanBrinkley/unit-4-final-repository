import java.text.DecimalFormat;

public class Car {

  DecimalFormat fmt = new DecimalFormat("##.00");

  private String make;
  private String model;
  private double mpg;
  private double tankSize;
  private double fuel;

  public Car(String newMake, String newModel, double newMpg, double newTankSize) {
    make = newMake;
    model = newModel;
    mpg = newMpg;
    tankSize = newTankSize;
    fuel = tankSize;
  }

  public String getMake() {
    return make;
  }
  public String getModel() {
    return model;
  }
  public double getMpg() {
    return mpg;
  }
  public double getTankSize() {
    return tankSize;
  }
  public double getFuel() {
    return fuel;
  }

  public void drive(double miles) {
    if (fuel - miles/mpg < 0) {
      System.out.println(make + " " + model + "'s trip couldn't be completed, it ran out of fuel.");
      fuel = 0;
    } else {
      fuel -= (miles/mpg);
    }
  }

  public void addFuel(double addedFuel) {
    if (fuel + addedFuel > tankSize)
      fuel = tankSize;
    else
      fuel += addedFuel;
  }

  public String toString() {
    String result = "";
    result += "Make: " + make + ", Model: " + model;
    result += "\nMPG: " + fmt.format(mpg);
    result += "\nTank size: " + fmt.format(tankSize) + " gallons";
    result += "\nCurrent fuel left: " + fmt.format(fuel) + " gallons";
    return result;
  }
}
