package Oops;

import java.util.*;

public class StringEqualsMethod {
  public static void main(String args[]){
     String s=null;
     String s1="gfg";
//      System.out.println(s.equals("gfg"));
      System.out.println("gfg".equals(s));
      System.out.println(s1.equals(s));
//      System.out.println(null>"kas");

      int[] arr=new int[]{2,3,4,9};
//      Arrays.sort(arr);
//      for(int i:arr){
//          System.out.println(i);
//      }
      System.out.println(Arrays.toString(arr));
      List<String> li=new ArrayList<>();
      List<String> l2=new ArrayList<>();
      l2.add(new String("atul"));
      l2.add(new String("ram"));
      li.add("A");
      li.add("F");
      li.add("D");
      Collections.sort(li);
      li.add("E");
      System.out.println(li);
  }
}