package collections;


public class GenericsDemo {
	 
	public static <T extends Comparable<T>> T findSmaller(T a,T b){
		//accepts only comparable objects
		if(a.compareTo(b)<0)
			return a;
		else
			return b;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The Smaller between 5 and 6 is: "+findSmaller(5,6));
		System.out.println("The Smaller between Hello and World is: "+findSmaller("Hello","World"));
	}
 
}
