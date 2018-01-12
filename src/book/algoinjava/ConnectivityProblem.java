package book.algoinjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConnectivityProblem {
  
  // TODO
  static Map<Integer, List<Integer>> pair = new HashMap<Integer, List<Integer>>();
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; ) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      sc.nextLine(); //skip the line
      
      if (isNewPair(x, y)) {
        System.out.println("new " + x + "-" + y);
        i++;
      }
      
      System.out.println(pair);
    }
    sc.close();
  }

  private static boolean isNewPair(int x, int y) {

//    System.out.println("x=" + x + ", y=" + y);

      // if two nodes are connected via another node
      Integer xparent = null, yparent = null;
      
      for (Map.Entry<Integer, List<Integer>> e : pair.entrySet()) {
        List<Integer> val = e.getValue();
        int key = e.getKey();
        
        if (val.contains(x) || key == x) {
          xparent = key;
        }
        
        if (val.contains(y) || key == y) {
          yparent = key;
        }
        
        // parent found for both the nodes, so stop searching
        if (xparent != null && yparent != null)
          break;
      }
      
      if (xparent != null && yparent != null) {

        // if connected 
        if (xparent.equals(yparent)) {          
          return false;
        } else {
          
          // new pair, but connected via two distinct node's internal pair
          List<Integer> meargeIn = pair.get(Math.min(xparent, yparent));
          List<Integer> toMearge = pair.get(Math.max(xparent, yparent));
          
          meargeIn.addAll(toMearge);
          meargeIn.add(Math.max(xparent, yparent));
          pair.remove(Math.max(xparent, yparent));
          return true;
        }
      } else if (xparent != null && yparent == null) {
        pair.get(xparent).add(y);
        return true;
      } else if (xparent == null && yparent != null) {
        pair.get(yparent).add(x);
        return true;
      } else {
        
        // node connected at all
        Integer min = Math.min(x, y);
        List<Integer> list = new ArrayList<Integer>();
        list.add(Math.max(x, y));
        pair.put(min, list);
        return true;
      }
  }

}
