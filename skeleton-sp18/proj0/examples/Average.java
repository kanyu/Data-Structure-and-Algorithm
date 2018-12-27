/******************************************************************************
 *  Compilation:  javac Average.java
 *  Execution:    java Average < data.txt
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Reads in a sequence of real numbers, and computes their average.
 *
 *  % java Average
 *  10.0 5.0 6.0
 *  3.0 7.0 32.0
 *  <Ctrl-d>
 *  Average is 10.5
 *
 *  Note <Ctrl-d> signifies the end of file on Unix.
 *  On windows use <Ctrl-z>.
 *
 ******************************************************************************/

public class Average {
    public static void main(String[] args) {
        int count = 0;       // number input values
        Double sum = 0.0;    // sum of input values
        In StdIn = new In();
        // read data and compute statistics
        while (!StdIn.isEmpty()) {
            Double value = StdIn.readDouble();
            sum += value;
            count++;
        }

        // compute the average
        Double average = sum / count;

        // print results
        StdOut.println("Average is " + average);
    }
}
