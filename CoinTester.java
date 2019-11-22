public class CoinTester {
  public static void main(String[] args) {
    Coin myCoin = new Coin();
    Coin yourCoin = new Coin();

    System.out.println("My coin: " + myCoin);
    System.out.println("Your coin: " + yourCoin);

    Coin dime = new Coin();
    int HCount = 0;
    final int MAX_FLIPS = 12;

    for (int i = 0; i < MAX_FLIPS; i++) {
      dime.flip();
      if (dime.isHeads())
        HCount++;
    }

    for (int i = 0; i < HCount; i++) System.out.print('H');
    for (int i = 0; i < MAX_FLIPS - HCount; i++) System.out.print('T');

    System.out.println("\n" + "# of heads in " + MAX_FLIPS + " flips: " + HCount);
  }
}
