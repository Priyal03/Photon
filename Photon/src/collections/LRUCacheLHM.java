package collections;

import java.util.LinkedHashMap;

public class LRUCacheLHM<K,V> extends LinkedHashMap<K, V>{

	private static final long serialVersionUID = 5404254729524369444L;
	private final int capacity ;
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		// TODO Auto-generated method stub
		return (size()>this.capacity);
	}

	public LRUCacheLHM(int capacity) {
		// TODO Auto-generated constructor stub
		super(capacity+1,1.0f,true);
		this.capacity=capacity;
	}
	public V find(K key) {
		return super.get(key);
	}
	
	public void set(K key, V value) {
		super.put(key, value);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCacheLHM<Integer, Integer> cache = new LRUCacheLHM<>(
				2);
		cache.set(2, 1); // Will add an element with key as 2 and value as 1
		cache.set(3, 2); // Will add an element with key as 3 and value as 2
		
		LRUCacheLHM<Integer, String> pairs = new LRUCacheLHM<>(
				3);
		
		pairs.put(1,  "A");
		pairs.put(2,  "B");
		pairs.put(3,  "C");
		pairs.put(4,  "D");

		pairs.get(3); //Accessing 3rd element
		 
		//Access 1st pair
		pairs.getOrDefault(1, "oops");
		 
		pairs.forEach((key, value) -> {
		    System.out.println("Key:"+ key + ", Value:" + value);
		});     
		// Will add an element with key as 4 and value as 3. Also will remove
		// the element with key 2 as it was added least recently and cache can
		// just have two elements at a time
		cache.set(4, 3);

		// Since element with key 2 was removed, it will return null
		System.out.println("Find at 2 "+cache.find(2));

		// It will return value 2 and move the element with key 3 to the head.
		// After this point, element with key 4 will be least recently accessed
		System.out.println("Find at 3 "+cache.find(3));

		// Will add an element with key as 5 and value as 4. Also will remove
		// the element with key 4 as it was accessed least recently and cache
		// can just have two elements at a time
		cache.set(5, 4);

		// Since element with key 2 was removed, it will return null
		System.out.println("Find at 4 "+cache.find(4));
		
		
	}

	

}
