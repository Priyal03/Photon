package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//take the entry set then use comparator to sort the values from it and then put this list of entries to new hashmap..
public class SortMapValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> attendance = new HashMap<String, Integer>();

		attendance.put("Japan", 100);
		attendance.put("France", 20);
		attendance.put("Russia", 50);
		attendance.put("India", 30);

		//take the entry set.
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(attendance.entrySet());
		
		
		Comparator<Map.Entry<String, Integer>> comparation = new Comparator<Map.Entry<String,Integer>>() {
			
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

				return o1.getValue()>o2.getValue()?1:(o1.getValue()<o2.getValue()?-1:0);
			}
		};
		
		Collections.sort(list, comparation);

/*		// Sort the list by overriding collections.sort method
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		}); */

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		temp.forEach((k, v) -> System.out.println(k + " " + v));

	}

}
