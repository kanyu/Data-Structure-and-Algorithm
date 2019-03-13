import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the the Sort class. */
public class TestSort {
    /** Test the Sort.sort method */
    @Test
    public void testFindMin(){
        String[] input = {"i", "have", "an", "egg"};
        int actual = Sort.findMin(input, 0);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMin2(){
        String[] input = {"an", "have", "i", "egg"};
        int actual = Sort.findMin(input, 1);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testSwap(){
        String[] input = {"i", "have", "an", "egg"};
        Sort.swap(input, 0, 2);
        String[] expected = {"an", "have", "i", "egg"};
//        org.junit.Assert.assertArrayEquals(expected, input);
        assertArrayEquals(expected, input);
    }
    @Test
    public void testSort(){
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        //start
//        if(!java.util.Arrays.equals(input, expected)){
//
//            System.out.println("Error! There seems to be a problem with Sort.sort.");
//        }
        // improved
//        for(int i = 0; i < input.length; i++){
//            if(!input[i].equals(expected[i])){
//                System.out.println("Mismatch in position " + i +", expected: " + expected[i] + ", but got: " + input[i]);
//                return;
//            }
//        }
        //improve more
        assertArrayEquals(expected, input);
    }
    @Test
    public void testSort2(){
        String[] input = {"a", "d", "b", "k", "l", "h", "g", "i", "j", "c", "n", "e", "f", "m"};
        String[] expected = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

//    public static void main(String[] args){
////        testSort();
////        testFindMin();
//        testSwap();
//    }
}
