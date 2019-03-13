public class SimpleDotCom {
  private int [] locationsCells;
  private int numOfHits = 0;
  private String result = "miss";
  public boolean isAlive = true;
  public SimpleDotCom() {

  }
  public void setLocationCells(int[] loc) {
    locationsCells = loc;
  }
  public String checkYourself(String stringGuess) {
    int guess = Integer.parseInt(stringGuess);
    for (int cell : locationsCells) {
      if (guess == cell) {
        result = "hit";
        numOfHits++;
        break;
      }
    }
    if (numOfHits == locationsCells.length) {
      isAlive = false;
      result = "kill";
    }
    System.out.println(result);
    return result;
  }
}
