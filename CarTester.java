import java.text.DecimalFormat;

public class CarTester {
  public static void main(String[] args) {

    DecimalFormat fmt = new DecimalFormat("##.00");

    Car myCar = new Car("Toyota", "Corolla", 27.9, 13.0);
    Car yourCar = new Car("Subaru", "Crosstrek", 29.7, 12.4);

    System.out.println("Info on my car:");
    System.out.println(myCar);

    System.out.println("");

    System.out.println("My car's mpg: " + fmt.format(myCar.getMpg()));
    System.out.println("My car's current fuel: " + fmt.format(myCar.getFuel()));
    myCar.drive(100.0);
    System.out.println("My car's fuel after 100 miles: " + fmt.format(myCar.getFuel()));
    myCar.addFuel(10.6);
    System.out.println("My car's fuel after adding 10.6 gallons: " + fmt.format(myCar.getFuel()));

    System.out.println();

    System.out.println("Your car's mpg: " + fmt.format(yourCar.getMpg()));
    System.out.println("Your car's current fuel: " + fmt.format(yourCar.getFuel()));
    yourCar.drive(100.0);
    System.out.println("Your car's fuel after 100 miles: " + fmt.format(yourCar.getFuel()));

    String randomName = "";
    int upperBound = (int)(Math.random()*8+4);
    for (int i = 0; i < upperBound; i++) {
      char addedChar = (char)((int)(Math.random()*26+65));
      randomName += addedChar;
    }

    System.out.println("");

    Car randomCar = new Car("Random", randomName.toLowerCase(), (Math.random()*25+5), (Math.random()*15+3));

    System.out.println("Random car's make: " + randomCar.getMake());
    System.out.println("Random car's model: " + randomCar.getModel());
    System.out.println("Random car's mpg: " + fmt.format(randomCar.getMpg()) + ", tank size: " + fmt.format(randomCar.getTankSize()));
    randomCar.drive(17.3);
    System.out.println("Random car's fuel after 17.3 miles: " + fmt.format(randomCar.getFuel()));

  }
}
