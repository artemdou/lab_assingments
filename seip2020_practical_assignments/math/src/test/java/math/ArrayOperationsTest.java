package math;

import java.io.File;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

import io.FileIO;
import math.MyMath;
import math.ArrayOperations;


public class ArrayOperationsTest {

	ArrayOperations ao;
	
	public ArrayOperationsTest() {
		this.ao = new ArrayOperations();
	}
	
	/*
	 * A test case that checks the 'normal' case with mocks. 
	 */
	@Test
	public void testFindPrimesInFile() {
		
		MyMath mm = mock(MyMath.class);
		FileIO f = mock(FileIO.class);
		
		int[] expected = {1,5,6};
		when(f.readFile("something")).thenReturn(expected);
		
		when(mm.isPrime(1)).thenReturn(false);
		when(mm.isPrime(5)).thenReturn(true);
		when(mm.isPrime(6)).thenReturn(false);
		
		Assert.assertArrayEquals(new int[] {5}, ao.findPrimesInFile(f, "something", mm));
	}
	
	
}
