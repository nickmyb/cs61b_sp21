package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
	@Test
	public void testThreeAddThreeRemove() {
		AListNoResizing<Integer> alist = new AListNoResizing<>();
		BuggyAList<Integer> buggyAList = new BuggyAList<>();

		int[] arr = {4, 5, 6};

		for (int i = 0; i < arr.length; i++) {
			alist.addLast(arr[i]);
			buggyAList.addLast(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			int i1 = alist.removeLast();
			int i2 = buggyAList.removeLast();

			assertEquals(i1, i2);
		}
	}

	@Test
	public void randomizedTest() {
		AListNoResizing<Integer> L = new AListNoResizing<>();
		BuggyAList<Integer> buggyAList = new BuggyAList<>();

		int M = 1000;
		int N = 50000;
		for (int i = 0; i < N; i += 1) {
			int operationNumber = StdRandom.uniform(0, 4);
			if (operationNumber == 0) {
				// addLast
				int size1 = L.size();
				if (size1 < M) {
					int randVal = StdRandom.uniform(0, 100);
					L.addLast(randVal);
					buggyAList.addLast(randVal);
					System.out.println("AListNoResizing.addLast(" + randVal + ")");
					System.out.println("BuggyAList.addLast(" + randVal + ")");
				}
			} else if (operationNumber == 1) {
				// size
				int size1 = L.size();
				int size2 = buggyAList.size();
				System.out.println("AListNoResizing.size: " + size1);
				System.out.println("BuggyAList.size: " + size2);
				assertEquals(size1, size2);
			} else if (operationNumber == 2) {
				// getLast
				int size1 = L.size();
				int size2 = buggyAList.size();
				if (size1 > 0 && size2 > 0) {
					int last1 = L.getLast();
					System.out.println("AListNoResizing.getLast: " + last1);
					int last2 = buggyAList.getLast();
					System.out.println("BuggyAList.getLast: " + last2);
					assertEquals(last1, last2);
				}
			} else if (operationNumber == 3) {
				// removeLast
				int size1 = L.size();
				int size2 = buggyAList.size();
				if (size1 > 0 && size2 > 0) {
					int last1 = L.removeLast();
					System.out.println("AListNoResizing.removeLast: " + last1);
					int last2 = buggyAList.removeLast();
					System.out.println("BuggyAList.removeLast: " + last2);
					assertEquals(last1, last2);
				}
			}
		}
	}
}
