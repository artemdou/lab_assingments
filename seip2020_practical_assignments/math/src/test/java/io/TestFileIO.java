package io;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

public class TestFileIO {

	FileIO f;
	
	public TestFileIO() {
		this.f = new FileIO();
	}
	
	
	/*
	 * A test case that checks the 'normal' case. 
	 */
	@Test
	public void testReadFileNormal() {
		int[] test = {1,1,1,1};
		String resourceName = "test1.txt";
		 
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();
		 
		Assert.assertArrayEquals(test, f.readFile(absolutePath));
	}
	
}
