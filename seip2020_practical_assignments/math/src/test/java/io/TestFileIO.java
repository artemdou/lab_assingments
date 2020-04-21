package io;

import java.io.File;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	
	@Rule 
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	
	@Test 
	public void testFeadFileFileDoesNotExist() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		f.readFile("test3.txt");
	}
	
	@Test 
	public void testReadFileFileEmpty() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		
		String resourceName = "test2.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();
		
		f.readFile(absolutePath);
	}
	
	@Test 
	public void testReadFileContainsInvalidEntry() {
		 thrown.expect(RuntimeException.class);
		//thrown.expectMessage("Given file is empty");
		
		String resourceName = "test3.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(resourceName).getFile());
		String absolutePath = file.getAbsolutePath();
		
		f.readFile(absolutePath);
		Assert.fail("Should have thrown an exception"); 
	}
	
	
}
