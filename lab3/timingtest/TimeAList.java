package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static double timeAListForNConstruction(int n) {
        AList<Integer> aList = new AList<>();
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < n; i += 1) {
            aList.addLast(i);
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int i = 0; i < 8; i += 1) {
            int n = 1000*(1<<i);
            ns.addLast(n);
            double t = timeAListForNConstruction(n);
            times.addLast(t);
            opCounts.addLast(n);
        }

        printTimingTable(ns, times, opCounts);
    }
}
