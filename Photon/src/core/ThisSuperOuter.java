package core;

public class ThisSuperOuter extends Base{

	public ThisSuperOuter() {
		super();
	}

	public ThisSuperOuter(String x) {
		super(x);
	}
	
	private int a = 10;
	
	public static void main(String[] args) {
		
		ThisSuperOuter outer = new ThisSuperOuter("888");
		
		ThisSuperOuter.Inner inner = outer.new Inner();
		
		inner.myMethod();
	}

	class Inner {
		
		private int a = 20;
		
		public Inner() {

		}

		public void myMethod() {
			
			System.out.println(this.a+" Inner class Object");
			
			System.out.println(ThisSuperOuter.this.a + " Outer class object");
		}
	}

}
