public class Dog extends Animal {
  public Dog(String name, int age) {
    super(name, age);
    noise = "Woof!";
  }

  @Override
  public void greet() {
    System.out.println("Dog " + name + " says: " + makeNoise());
  }

  public void playFetch() {
    System.out.println("Fetch, " + name + "!");
  }
  public static void main(String[] args) {
    Animal a = new Animal("Pluto", 10);
    Cat c = new Cat("Garfield", 6);
    Dog d = new Dog("Fido", 4);

    a.greet();
    c.greet();
    d.greet();
    a = c;
    ((Cat) a).greet();
    a.greet();
    a = new Dog("Spot", 10);
    d = (Dog) a;
  }
}
