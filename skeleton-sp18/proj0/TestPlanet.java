public class TestPlanet{
  public static void main(String[] args){
    // Planet(double xP, double yP, double xV, double yV,
    //                                     double m, String img){
    Planet Bear = new Planet(1, 0, 3, 5, 10, "images/jupiter.gif");
    Planet Thor = new Planet(3, 3, 2, 5, 5, "images/jupiter.gif");
    Planet Duck = new Planet(5, -3, 1, 5, 50, "images/jupiter.gif");

    System.out.println(Bear.calcForceExertedBy(Thor));
    System.out.println(Bear.calcForceExertedBy(Duck));
  }
}
