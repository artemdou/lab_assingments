package math;

import java.util.ArrayList;

import io.FileIO;

public class ArrayOperations {

	/**
	 * Finds the prime numbers from a text file
	 * @param FileIO f
	 * @param String filepath
	 * @param MyMath mm
	 * @return list of prime numbers
	 */
	public int[] findPrimesInFile(FileIO f, String filepath, MyMath mm) {
		int[] array = f.readFile(filepath);
		ArrayList<Integer> primesList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (mm.isPrime(array[i])) {
				primesList.add(array[i]);
			}
		}
		return primesList.stream().mapToInt(i -> i).toArray();
		
	}
}
