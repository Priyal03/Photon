package java8;

import java.util.Arrays;

public class LambdaIntro {

	public static void main(String[] ar) {
		Employee[] employees = { new Employee("David"), new Employee("Naveen"), new Employee("Alex"),
				new Employee("Richard") };

		System.out.println("Before Sorting Names: " + Arrays.toString(employees));

		Arrays.sort(employees, Employee::nameCompare);

		System.out.println("After Sorting Names " + Arrays.toString(employees));
		
//We have also see that Runnable is an functional interface with single method run(). So, when you pass lambda expression 
//to constructor of Thread class, compiler tries to convert the expression into equivalent Runnable code as shown in first 
//code sample. If compiler succeed then everything runs fine, if compiler is not able to convert the expression into 
//equivalent implementation code, it will complain. Here, in above example, lambda expression is converted to type Runnable.		
		
		new Thread(() -> System.out.println("new thread from runnable")).start();
//In simple words, a lambda expression is an instance of a functional interface. But a lambda expression itself does 
//not contain the information about which functional interface it is implementing; that information is deduced from 
//the context in which it is used.	          
	}
}

class Employee {
	String name;

	Employee(String name) {
		this.name = name;
	}

	public static int nameCompare(Employee a1, Employee a2) {
		return a1.name.compareTo(a2.name);
	}

	public String toString() {
		return name;
	}
}