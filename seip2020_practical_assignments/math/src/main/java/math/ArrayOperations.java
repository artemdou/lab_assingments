package math;

import java.util.ArrayList;

import io.FileIO;

/**
* The ArrayOperatios class provides simple arithmetic operations
* that consider an array of numbers.
*
* @author  artemdou
* @version 1.0
* @since   2020-04-29 
*/
public class ArrayOperations {

	/**
	 * Finds the prime numbers from a text file
	 * @param FileIO f, object of FileIo class
	 * @param String filepath, the location of the file where the numbers are
	 * @param MyMath mm, object of MyMath class
	 * @return list of prime numbers
	 */
	public int[] findPrimesInFile(FileIO f, String filepath, MyMath mm) {
		int[] array = f.readFile(filepath);
		ArrayList<Integer> primesList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 2) {
				if (mm.isPrime(array[i])) {
					primesList.add(array[i]);
				}
			}
			
		}
		return primesList.stream().mapToInt(i -> i).toArray();
		
	}
}
