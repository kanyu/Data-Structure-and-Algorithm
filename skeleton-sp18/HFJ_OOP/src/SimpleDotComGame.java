public class SimpleDotComGame {
  public static void main(String[] args) {
    int numOfGuesses = 0;
    int randomNum = (int) (Math.random() * 5);
    int[] locations = {randomNum, randomNum+1, randomNum+2};
    GameHelper helper = new GameHelper();
    SimpleDotCom theDotCom = new SimpleDotCom();
    theDotCom.setLocationCells(locations);
    while (theDotCom.isAlive) {
      String guess = helper.getUserInput("Enter a number: ");
      String result = theDotCom.checkYourself(guess);
      numOfGuesses++;
      if (result.equals("kill")) {
        System.out.println("You took " + numOfGuesses + " guesses");
      }
    }
  }
}
