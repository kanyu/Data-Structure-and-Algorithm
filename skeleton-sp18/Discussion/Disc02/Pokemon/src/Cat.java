public class Cat {
    public String name;
    public static String noise;

    public Cat(String name, String noise){
        this.name = name;
        this.noise = noise;
    }

    public void play(){
        System.out.println(noise + " I'm " + name + " the cat!");
    }

    public static void anger(){
        noise = noise.toUpperCase();
    }

    public static void calm(){
        noise = noise.toLowerCase();
    }

    public static void main(String[] args){
        Cat a = new Cat("Cream", "Meow!"); // create new cat name "Cream" who make noise "Meow!" and assign to a
        Cat b = new Cat("Tubbs", "Nyan!"); // create new cat name "Tubbs" who make noise "Nyan!" and assign to b
        a.play(); // print "Meow! I'm Cream the cat!"
        b.play(); // print "Nyan! I'm Tubb the cat!"
        Cat.anger(); // Meow!, Nyan! -> MEOW!, NYAN!
        a.calm(); // MEOW! -> Meow!
        a.play(); // print "Meow! I'm Cream the cat!"
        b.play(); // print "NYAN! I'm Tubb the cat!"
    }
}
