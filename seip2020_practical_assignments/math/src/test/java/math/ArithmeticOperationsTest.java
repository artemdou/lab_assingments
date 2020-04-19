package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.ArithmeticOperations;

public class ArithmeticOperationsTest {

	ArithmeticOperations op; 
	
	/*
	 * A test case that examines the divide method
	 * with 'normal' input values. 
	 */
	@Test
	public void testDevideNormal() {
		Assert.assertEquals(2, op.divide(4, 2), 0);
	}
	/*
	 * A test case that examines the divide method
	 * with numerator equal to zero. 
	 */
	@Test
	public void testDevideZeroNum() {
		Assert.assertEquals(0, op.divide(0, 100), 0);
	}
	
	@Test (expected = ArithmeticException.class)
	public void testDevideZeroDen() {
		op.divide(1, 0);
	}
	
	
	
	
}
