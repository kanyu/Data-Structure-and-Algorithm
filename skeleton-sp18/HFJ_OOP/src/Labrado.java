public class Labrado extends Doggo{
  @Override
  public void bark(Doggo d) {
    System.out.print("L");
  }
  public static void main(String[] args) {
    Doggo l = new Labrado();
    l.bark(l);
  }
}
