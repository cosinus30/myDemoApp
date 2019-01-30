package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World of Yours!");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<Integer>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
          
          Integer[] inputIntegerArray = new Integer[25];
          int index = 0;
          while(sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputIntegerArray[index] = value;
            index++;
          }

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          String[] strArray = new String[25];
          index = 0;
          while(sc1.hasNext())
          {
            strArray[index] = sc1.next().replaceAll("\\s","");
            index++;
          }

          boolean[] boolArray = new boolean[25];
          index = 0;
          while(sc1.hasNext())
          {
            boolArray[index] = Boolean.parseBoolean(sc1.next().replaceAll("\\s", ""));
            index++;
          }

          String[] result = App.meaningfulComputation(inputIntegerArray,inputList,strArray,boolArray);

         Map map = new HashMap();
          map.put("result", "hello");
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
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