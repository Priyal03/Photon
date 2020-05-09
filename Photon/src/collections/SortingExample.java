package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * You can pass it Comparator for defining sorting order. If no comparator passed than Object must implement 
 * Comparable interface in order to be sorted.
 * @author coder
 *
 */
public class SortingExample {

    public static void main(String args[]) throws InterruptedException{            
   
        // Sort List and Set in ascending order
       
        // Sorting List in Java in ascending order in Java
        List<Integer> list = Arrays.asList( 1, 2, 5, 9, 3, 6, 4, 7, 8);
       
        System.out.println("Unsorted List in Java: " + list);
       
        // Sorting List into Java now, Collections.sort()  method will sort
        // the collection passed
        // to it. Doesn't return anything it just sort the collection itself

        Collections.sort(list); //sorting collection
       
        System.out.println("List in Java sorted in ascending order: " + list);
       
        // sorting List in descending order in Java, Collections.sort() method can be used
        // to sort all element in descending order if we pass it comparator which can
        // return descending order for elements. here is an example of sorting List
        // in descending order  in Java
        // Collection class provides a in built-in comparator for that which can
        // sort objects in reverse order i..e descending order for Integers or
        // any other Object in Java
       
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Java List sorted in descending order: " + list);
       
        // Any List implementation in Java like ArrayList, LinkedList
        // can be sorted in ascending and descending order in Java by following above
        // example, let's see a quick example for sorting ArrayList and LinkedList
        // in ascending and descending order in Java
       
       
        //Sorting ArrayList in ascending order in Java
        ArrayList alphabets = new ArrayList();
        alphabets.add("c");
        alphabets.add("b");
        alphabets.add("a");
        alphabets.add("d");
       
        System.out.println("Unsorted ArrayList in Java : " + alphabets);
       
        //Sorting ArrayList into ascending order
        Collections.sort(alphabets);
       
        System.out.println("Sorted ArrayList in ascending order in Java : " + alphabets);
       
        //Sorting ArrayList into descending order or reverse order in Java
        Collections.sort(alphabets, Collections.reverseOrder());
       
        System.out.println("ArrayList sort in descending order in Java : " + alphabets);      
       
    }  
 
}
