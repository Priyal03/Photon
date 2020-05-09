package basics;

public class ClassCast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double d = 129.00; 
		
		long l = (new Double(d)).longValue();
		
		double f=3*0.1;

		if(f==0.3) {
			System.err.println("yo "+f);
		}else {
			System.err.println("Nooo "+f);
		}
	}

}
