package collections;



	import java.util.HashMap;
	 
	public class HashMapMain {
	 
		public static void main(String[] args) {
			HashMap<String, String> employeeDeptmap = new HashMap<>();
			
			//check if map is empty
			boolean empty = employeeDeptmap.isEmpty();
			System.out.println("is employeeDeptmap empty: "+empty);
			
			// Putting key-values pairs in HashMap
			employeeDeptmap.put("Arpit","Tech");
			employeeDeptmap.put("John", "Sales");
			employeeDeptmap.put("Martin", "HR");
			employeeDeptmap.put("Vaibhav","Tech");
			
	      System.out.println(employeeDeptmap);
			//check size of map
			System.out.println("size of employeeDeptmap: "+employeeDeptmap.size());
			
			// get value from HashMap
			System.out.println("Martin's department: "+employeeDeptmap.get("Martin"));
			// Robin's department will be null as we don't have key as "Robin"
			System.out.println("Robin's department: "+employeeDeptmap.get("Robin"));
			
			if(employeeDeptmap.containsKey("John"))
			{
				System.out.println("employeeDeptmap has John as key");
			}
			
			if(employeeDeptmap.containsValue("Sales"))
			{
				System.out.println("employeeDeptmap has Sales as value");
			}
			
			// Removing all entries from Map
			employeeDeptmap.clear();
			System.out.println(employeeDeptmap);
			
			HashMap<String,Integer> teamGoalMap=new HashMap<>();
			teamGoalMap.put("team1",1);
			teamGoalMap.put("team2",1);
			teamGoalMap.put("team3", null);
			
			teamGoalMap.compute("team1",(t,g)->g+1);
			
			System.out.println(teamGoalMap);
			
			if(teamGoalMap.computeIfPresent("team3", (t,g)->g+1)==null) {
				//compute if key is present and value is not null.
				System.out.println("removed the key");
			}
			System.out.println(teamGoalMap);
			teamGoalMap.computeIfAbsent("team3", g->2);
				//compute if key is absent and this function doesnot return null.
				
			
			System.out.println(teamGoalMap);
		}
	}
