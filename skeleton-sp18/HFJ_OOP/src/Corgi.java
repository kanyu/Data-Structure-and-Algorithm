public class Corgi extends Doggo {
  public void bark(Corgi c) {
    System.out.print("B");
  }
  @Override
  public void bark(Doggo d) {
    System.out.print("C");
  }
  public void play(Doggo d) {
    System.out.print("D");
  }
  public void play(Corgi c) {
    System.out.print("E");
  }
  public static void main(String[] args) {
    Doggo d = new Corgi();
    Corgi c = new Corgi();

   // d.play(d);
   // d.play(c);
    c.play(d);
    c.play(c);

    c.bark(d);
    c.bark(c);
    d.bark(d);
    d.bark(c);
  }
}
