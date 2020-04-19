package math;

import math.ArithmeticOperations;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArithmeticOperationsTest {

	ArithmeticOperations op;
	
	public ArithmeticOperationsTest() {
		this.op = new ArithmeticOperations();
	}
	
	/*
	 * A test case that examines the divide method
	 * with 'normal' input values. 
	 */
	@Test
	public void testDevideNormal() {
		Assert.assertEquals(2, op.divide(4, 2),0);
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
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()

	@Test 
	public void testMultiplyShouldThrowExceptionOnNegativeInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		op.multiply(-5, 1);
	}
	
	@Test 
	public void testMultiplyShouldThrowExceptionOnNotIntegerInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		op.multiply(Integer.MAX_VALUE, 100);
	} 
}
