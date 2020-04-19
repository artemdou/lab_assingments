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
}
