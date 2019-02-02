package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.ElementScanner6;

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
        System.out.println( "Hello World!!!!!!!" );

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
            inputList.add(Integer.parseInt(sc1.next().replaceAll("\\s","")));
          }//End of input1 process!
          
          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          ArrayList<Integer> inputIntegerArray = new ArrayList<Integer>();
          while(sc2.hasNext())
          {
            inputIntegerArray.add(Integer.parseInt(sc2.next().replaceAll("\\s","")));
          }

          String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          ArrayList<String> strArray = new ArrayList<String>();
          while(sc3.hasNext())
          {
            strArray.add(sc3.next().replaceAll("\\s", ""));
          }  //End of input3 process!

          String input4 = req.queryParams("input4");
          java.util.Scanner sc4 = new java.util.Scanner(input4);
          sc4.useDelimiter("[;\r\n]+");
          ArrayList<Boolean> boolArray = new ArrayList<Boolean>();
          while(sc4.hasNext())
          {
            boolArray.add(Boolean.parseBoolean(sc4.next().replaceAll("\\s", "")));
          }//End of input4 process!

        Map<String,String> map = new HashMap<String,String>();

        ArrayList<String> result = App.meaningfulComputation(inputIntegerArray,inputList,strArray,boolArray);
        String sum = "";
        
        if(result.size() != 0 && result != null){
          for(int i = 0 ;i < result.size() ; i++)
            sum += result.get(i); 
          map.put("result", sum);
        }
        else{
          map.put("result","uncoputable! form1&2:Integer, form3:String, form4:boolean. All form's set size must be equal!");
        }
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
  

    public static ArrayList<String>meaningfulComputation(ArrayList<Integer> intArray, ArrayList<Integer> intArrayList, ArrayList<String> strArray, ArrayList<Boolean> addOrNot){
        int littleOne = 0, bigOne = 0;
        if(intArray == null || intArrayList == null || strArray == null || addOrNot == null)
          return null;
        //Length of integer array,length of list and length of boolean array must be equal.
        //Length of array and list must be either equal to or greater than length of strArray.
        if(intArray.size() != intArrayList.size()|| intArray.size() != addOrNot.size() || intArray.size() < strArray.size())
          return null;
        for(int i = 0; i < strArray.size(); i++){
          if(intArray.get(i) <= intArrayList.get(i) ){
            littleOne = intArray.get(i);
            bigOne = intArrayList.get(i);
          }
          else{
            littleOne = intArrayList.get(i) ;
            bigOne = intArray.get(i);
          }
        for (int j = 0; j < littleOne; j++){
            if(addOrNot.get(i))
                strArray.set(i, strArray.get(i) + "" + bigOne);
        }
        }
        return strArray;
      }

}