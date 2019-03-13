public class Cat extends Animal {
  public Cat(String name, int age) {
    super(name, age);
    noise = "meow!";
  }


  public static void main(String[] args) {
    Cat c = new Cat("Thor", 4);
    c.greet();
    Cat d = new Cat("Kan", 6);
    d.greet();

    Animal e = new Animal("Beast", 5);
    e.greet();
  }
}
