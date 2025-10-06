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
}
