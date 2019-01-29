package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static String[] meaningfulComputation(Integer[] intArray, ArrayList<Integer> intArrayList, String[] strArray, boolean[] addOrNot){
        int littleOne = 0, bigOne = 0;
        if(intArray == null || intArrayList == null || strArray == null || addOrNot == null)
          return null;
        //Length of integer array,length of list and length of boolean array must be equal.
        //Length of array and list must be either equal to or greater than length of strArray.
        if(intArray.length != intArrayList.size()|| intArray.length != addOrNot.length || intArray.length < strArray.length)
          return null;
        for(int i = 0; i < strArray.length; i++){
          if(intArray[i] <= intArrayList.get(i) ){
            littleOne = intArray[i];
            bigOne = intArrayList.get(i);
          }
          else{
            littleOne = intArrayList.get(i) ;
            bigOne = intArray[i];
          }
        for (int j = 0; j < littleOne; j++){
            if(addOrNot[i])
                strArray[i] += "" + bigOne;
        }
        }
        return strArray;
      }
}
