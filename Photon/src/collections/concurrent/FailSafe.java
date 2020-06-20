package collections.concurrent;

import java.util.concurrent.ConcurrentHashMap; 
import java.util.concurrent.CopyOnWriteArrayList; 
import java.util.Iterator; 
  
class FailSafe { //non fail fast iterators
    public static void main(String args[]) 
    { 
        CopyOnWriteArrayList<Integer> list 
            = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 }); 
        Iterator itr = list.iterator(); 
        while (itr.hasNext()) { 
            Integer no = (Integer)itr.next(); 
             
            if (no == 8) 
  
                // This will not print, 
                // hence it has created separate copy 
                list.add(14); 
            
            System.out.println(no);
        }
        ConcurrentHashMap<String, Integer> map 
        = new ConcurrentHashMap<String, Integer>(); 

    map.put("ONE", 1); 
    map.put("TWO", 2); 
    map.put("THREE", 3); 
    map.put("FOUR", 4); 

    // Getting an Iterator from map 
    Iterator it = map.keySet().iterator(); 

    while (it.hasNext()) { 
        String key = (String)it.next(); 
        System.out.println(key + " : " + map.get(key)); 

        // This will reflect in iterator. 
        // Hence, it has not created separate copy 
        map.put("SEVEN", 7); 
    } 
    } 
} 