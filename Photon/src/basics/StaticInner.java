package basics;

// took from Javin Paul and modified for me.
public class StaticInner {

		
	private static String message = "Hello Priyal";
	private String nonStatic = "I am not static";
	 
	
    // Static nested class
    private static class MessagePrinter{
        //Only static member of Outer class is directly accessible in nested static class

    	
    	
        public void printMessage(){
            System.out.println("Message from nested static class : " + message+" "); //+nonStatic); gives context compile time error
        }
    }
 
    //non static nested class - also called Inner class
    private class Inner{
     
        // Both static and non static member of Outer class is accessible in this Inner class
        public void display(){
            System.out.println(" Message from non static nested or Inner class : " + message+" "+nonStatic);
        }
    }
    // How to create instance of static and non static nested class
    public static void main(String... args){
     
        // creating instance of nested Static class
    	StaticInner.MessagePrinter printer = new StaticInner.MessagePrinter();
     
        //calling non static method of nested static class
        printer.printMessage();
     
        // creating instance of non static nested class or Inner class
        // In order to create instance of Inner class you need an Outer class instance
     
        StaticInner outer = new StaticInner(); //outer class instance for creating non static nested class
     
        StaticInner.Inner inner  = outer.new Inner();
     
        //calling non static method of Inner class
        inner.display();
     
        // we can also combine above steps in one step to create instance of Inner class
        StaticInner.Inner nonStaticInner = new StaticInner().new Inner();
     
        // similarly you can now call Inner class method
        nonStaticInner.display();
        
    }

}
