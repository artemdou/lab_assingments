package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.MyMath;

public class MyMathTest {

	MyMath mm;
	
	public MyMathTest() {
		this.mm = new MyMath();
	}
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); 

	@Test 
	public void testFactorialInvalidInputNegative() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid input");
		mm.factorial(-5);
	}
	
	@Test 
	public void testFactorialInvalidInputUpperBound() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid input");
		mm.factorial(20);
	}
	
	@Test
	public void testFactorialNormal() {
		Assert.assertEquals(720, mm.factorial(6), 0);
	}
	
	@Test
	public void testFactorialZero() {
		Assert.assertEquals(1, mm.factorial(0), 0);
	}
	
	@Test
	public void testIsPrimeTrue() {
		Assert.assertTrue(mm.isPrime(7));
	}	
	
	@Test
	public void testIsPrimeTrueForSmallNums() {
		Assert.assertTrue(mm.isPrime(2));
		Assert.assertTrue(mm.isPrime(3));
	}
	
	@Test
	public void testIsPrimeFalse() {
		Assert.assertFalse(mm.isPrime(6));
		Assert.assertFalse(mm.isPrime(9));
	}
	
	@Test 
	public void testIsPrimeInvalidInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid input");
		mm.isPrime(1);
	}
	
	
}
