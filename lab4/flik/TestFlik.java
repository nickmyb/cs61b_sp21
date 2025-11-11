package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
	public void testIsSameNumber() {
		int i = 0;
		for (int j = 0; i < 500; ++i, ++j) {
			assertTrue(Flik.isSameNumber(i, j));
		}
	}
}
