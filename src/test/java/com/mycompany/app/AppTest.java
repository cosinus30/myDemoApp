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
        ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Boolean> boolList = new ArrayList<Boolean>(Arrays.asList(false,false,false,false));
        ArrayList<String> strArray = null;
        ArrayList<String> ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testNullIntegerArrayObject()
    {
        App obj = new App();
        ArrayList<Integer> intArray = null;
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Boolean> boolList = new ArrayList<Boolean>(Arrays.asList(false,false,false,false));
        ArrayList<String> strArray = new ArrayList<String>(Arrays.asList("abc","def","ghe","jkl"));
        ArrayList<String> ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }
    public void testNullBooleanArrayObject()
    {
        App obj = new App();
        ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Boolean> boolList =null;
        ArrayList<String> strArray = new ArrayList<String>(Arrays.asList("abc","def","ghe","jkl"));
        ArrayList<String> ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testNullIntegerArrayListObject()
    {
        App obj = new App();
        ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> intArrayList = null;
        ArrayList<Boolean> boolList = new ArrayList<Boolean>(Arrays.asList(false,false,false,false));
        ArrayList<String> strArray = new ArrayList<String>(Arrays.asList("abc","def","ghe","jkl"));
        ArrayList<String> ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testAreLengthOfObjectsNotEqual()
    {
        App obj = new App();
        ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Boolean> boolList = new ArrayList<Boolean>(Arrays.asList(false,false,false,false));
        ArrayList<String> strArray = new ArrayList<String>(Arrays.asList("abc","def","ghe","jkl"));
        ArrayList<String> ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(null, ans);
    }

    public void testAreLengthOfObjectsEqual()
    {
        App obj = new App();
        ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Boolean> boolList = new ArrayList<Boolean>(Arrays.asList(false,false,false,false));
        ArrayList<String> strArray = new ArrayList<String>(Arrays.asList("abc","def","ghe","jkl"));
        ArrayList<String> ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        assertEquals(strArray, ans);
    }

    public void testExpectedOutputWhileAdditionIsOn(){
        App obj = new App();
        ArrayList<Integer> intArray = new ArrayList<Integer>(Arrays.asList(5,6,7,8));
        ArrayList<Integer> intArrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        ArrayList<Boolean> boolList = new ArrayList<Boolean>(Arrays.asList(true,true,true,true));
        ArrayList<String> strArray = new ArrayList<String>(Arrays.asList("abc","def","ghe","jkl"));
        ArrayList<String> expectedOutput = new ArrayList<String>(Arrays.asList("abc5","def66","ghe777","jkl8888"));
        ArrayList<String> ans = obj.meaningfulComputation(intArray, intArrayList, strArray, boolList);
        String sumTrue = "", sumAns = "";
        for (int i = 0; i < expectedOutput.size(); i++){
            sumTrue += expectedOutput.get(i);
            sumAns += ans.get(i);
        }
        assertTrue(sumTrue.equals(sumAns));
    }

}
