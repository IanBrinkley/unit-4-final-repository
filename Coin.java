public class Coin {
  // declarations for the attributes (instance variables) of each coin.
  private int face;

  private final int HEADS = 0;
  private final int TAILS = 1;

  // the coin constructor that defines what happens when a coin object is made.
  public Coin() {
    flip();
  }

  // the accessor method for the face variable. (a 'getter')
  public int getFace() {
    return face;
  }

  // the mutator method for the face variable. (a 'setter')
  public void setFace(int newFace) {
    face = newFace;
  }

  // the method that defines what happens when the coin flips.
  public void flip() {
    face = (int) (Math.random() * 2);
  }

  // the isheads method tells us if the coin's face is a heads or not.
  public boolean isHeads() {
    return (face == HEADS);
  }

  // toString converts the boolean into a string of heads or tails.
  public String toString() {
    String result = "";
    if (isHeads())
      result = "Heads";
    else
      result = "Tails";
    return result;
  }
}
