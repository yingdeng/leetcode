/*
Find the k most frequent elements in an array

Result
Most Frequent Key : 1 , 6 times occurred
Most Frequent Key : 1 , 6 times occurred
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// Find the k most frequent elements in an array in a stream
public class Drill11 {
 
 static int[] input={1,2,3,4,5,5,7,8,1,1,1,2,9,3,6,4,5,5,2,1,1};
 static int[][] output = new int[input.length][2];

 public static void main(String[] args)
 {
  for(int i=0;i<output.length;i++){
   output[i][0]=-1;
   output[i][1]=-1;
  }
  
  solveUsingHashMap(input);
  solveUsingFixedsizeArray(input);
  
 }

 public static void solveUsingHashMap(int[] input){
  Map<Integer,Integer> hmap = new HashMap<>();
  
  for(int i=0;i<input.length;i++){
   int tmp=input[i];
   if(hmap.containsKey(tmp)){
    int value=hmap.get(tmp);
    hmap.put(tmp, value+1);
   }else
    hmap.put(tmp, 1);
  }
  
  Iterator itor = hmap.entrySet().iterator();
  
  int maxKey=0;
  int maxValue=0;
  while(itor.hasNext()){
   Entry<Integer, Integer> et=(Entry)itor.next();
   if(et.getValue()>maxValue){
    maxValue=et.getValue();
    maxKey=et.getKey();
   }   
  }
  
  System.out.println("Most Frequent Key : " + maxKey + " , " + maxValue + " times occurred");  
 }
 