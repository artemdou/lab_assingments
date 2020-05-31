package math;

/**
* The MyMath provides arithmetic operations
* that serve as hands-on practice on Unit Testing.
*
* @author  artemdou
* @version 1.0
* @since   2020-04-20 
*/
public class MyMath {

	
	/**
	 * Calculates the factorial of a given number
	 * @param i the Integer whose factorial is calculated
	 * @return the factorial of the input
	 * @exception IllegalArgumentException when <b>i<b> in (0,12)
	 */
	public int factorial(int i) {
		if (i == 0) {
			return 1;
		} else if (i < 0 || i > 12) {
			throw new IllegalArgumentException("Invalid input");
		} else {
			return i * factorial(i - 1); 
		}
	}
	
	/**
	 * Checks if i >= 2 is a prime number.
	 * @param i
	 * @return boolean (true if i is a prime number)
	 * @exception IllegalArgumentExceptio when <b>i<b> < 2 
	 */
	public boolean isPrime(int i) {
		if (i < 2) {
			throw new IllegalArgumentException("Invalid input");
		} else if (i == 3 || i == 2) {
			return true;
		} else if (i%2 == 0 || i%3 == 0) {
			return false;
		} else {
			return true;
		}
	}
}
