package ro.horia.searching;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraySearchTest {

	int[] inputArray = {123,453,213,45,1,8,44,69};
	
	@Test
	public void testLinearSearch() {
		assertEquals(-1, ArraySearch.linearSearch(inputArray, 45311));
	}

}
