public class DieTester {
    public static void main(String[] args) {
        System.out.println("Welcome to the dice simulator" + "\n");

        Die die1 = new Die();
        Die die2 = new Die();

        int count;
        int totalRolls = 0;

        // rolls until a double is scored
        for (int i = 0; i < 100; i++) {
            count = 1;
            die1.roll();
            die2.roll();
            while (die1.getFace() != die2.getFace()) {
                count++;
                die1.roll();
                die2.roll();
            }
            totalRolls += count;
        }
        System.out.println("Average # rolls to find doubles: " + totalRolls/100.0);

    }
}
