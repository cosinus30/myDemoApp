package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testNullStringArrayObject()
    {
        App obj = new App();
        Integer[] intArray = {1,2,3,4};
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        boolean[] boolList = {false,false,false,false};
        String[] strArray = null;
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testNullIntegerArrayObject()
    {
        App obj = new App();
        Integer[] intArray = null;
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        boolean[] boolList = {false,false,false,false};
        String[] strArray = {"abc","dfe","ghi","jkl"};
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }
    public void testNullBooleanArrayObject()
    {
        App obj = new App();
        Integer[] intArray = {1,2,3,4};
        ArrayList<Integer> intArrayList = null;
        boolean[] boolList = null;
        String[] strArray = {"abc","dfe","ghi","jkl"};
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testNullIntegerArrayListObject()
    {
        App obj = new App();
        Integer[] intArray = {1,2,3,4};
        ArrayList<Integer> intArrayList = null;
        boolean[] boolList = {false,false,false,false};
        String[] strArray = {"abc","dfe","ghi","jkl"};
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testAreLengthOfObjectsNotEqual()
    {
        App obj = new App();
        Integer[] intArray = {1,2,3,4,5};
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        boolean[] boolList = {false,false,false,false};
        String[] strArray = {"abc","dfe","ghi","jkl"};
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testAreLengthOfObjectsEqual()
    {
        App obj = new App();
        Integer[] intArray = {1,2,3,4};
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        boolean[] boolList = {false,false,false,false};
        String[] strArray = {"abc","dfe","ghi","jkl"};
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(strArray, ans);
    }

    public void testExpectedOutputWhileAdditionIsOff(){
        App obj = new App();
        Integer[] intArray = {5,6,7,8};
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        boolean[] boolList = {false,false,false,false};
        String[] strArray = {"abc","dfe","ghi","jkl"};
        String[] expectedOutput = {"abc","dfe","ghi","jkl"};
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertTrue(Arrays.equals(expectedOutput, ans));
    }

    public void testExpectedOutputWhileAdditionIsOn(){
        App obj = new App();
        Integer[] intArray = {5,6,7,8};
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        boolean[] boolList = {true,true,true,true};
        String[] strArray = {"abc","dfe","ghi","jkl"};
        String[] expectedOutput = {"abc5","dfe66","ghi777","jkl8888"};
        String [] ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertTrue(Arrays.equals(expectedOutput, ans));
    }

}
