import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(100);
        numbers.add(40);

        System.out.println(numbers.get(0));
        System.out.println("iter 1");
        for(int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        System.out.println("iter 2");
        for(Integer value : numbers) {
            System.out.println(value);
        }

        //Removing items (careful!)
        numbers.remove(numbers.size() - 1);

        // This is very slow
        numbers.remove(0);
        // List interface
        List<String> values = new ArrayList<String>();

        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        doTimings("ArrayList", arrayList);
        doTimings("LinkedList", linkedList);
    }

    private static void doTimings(String type, List<Integer> list){
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1E5; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms for " + type);
    }
}
