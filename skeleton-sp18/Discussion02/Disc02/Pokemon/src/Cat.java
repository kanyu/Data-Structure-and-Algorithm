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
        Cat a = new Cat("Cream", "Meow!"); // create new cat name "Cream" who make noise "Meow!" and assign to a, static noise = "Meow!"
        Cat b = new Cat("Tubbs", "Nyan!"); // create new cat name "Tubbs" who make noise "Nyan!" and assign to b, static noise = "Nyan!"
        a.play(); // print "Nyan! I'm Cream the cat!"
        b.play(); // print "Nyan! I'm Tubb the cat!"
        Cat.anger(); // Nyan! -> NYAN!
        a.calm(); // NYAN! -> nyan!
        a.play(); // print "nyan! I'm Cream the cat!"
        b.play(); // print "nyan! I'm Tubb the cat!"
    }
}
