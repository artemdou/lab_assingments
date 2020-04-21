package math;

import java.io.File;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import io.FileIO;
import math.MyMath;
import math.ArrayOperations;


public class ArrayOperationsTest {

	ArrayOperations ao;
	
	public ArrayOperationsTest() {
		this.ao = new ArrayOperations();
	}
	
	/*
	 * A test case that checks the 'normal' case. 
	 */
	@Test
	public void testFindPrimesInFile() {
		int[] test = {3,5,11};
		String resourceName = "arraysTest.txt";
		 
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();
		MyMath mm = new MyMath();
		FileIO f = new FileIO();
		Assert.assertArrayEquals(test, ao.findPrimesInFile(f, absolutePath, mm));
	}
	
	
}
