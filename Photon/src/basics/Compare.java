package basics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Compare {

	public static void main(String[] args) {
		
		//One example where compareTo is not consistent with equals in JDK is BigDecimal class

		BigDecimal bd1 = new BigDecimal("2.0");
		BigDecimal bd2 = new BigDecimal("2.00");
		     
		System.out.println("comparing BigDecimal using equals: " + bd1.equals(bd2));
		System.out.println("comparing BigDecimal using compareTo: " + bd1.compareTo(bd2));

		Student john12 = new Student(1001, "John", 12);
		Student john13 = new Student(1002, "John", 13);
		     
		//compareTo will return -1 as age of john12 is less than john13
		System.out.println("comparing John, 12 and John, 13 with compareTo :" + john12.compareTo(john13));

		//custom ordering by comparator
		Comparator<Student> orderByName = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.name.compareTo(o2.name);
			}
		};
		
        
		Order ord1 = new Order(101,2000, "Sony");
        Order ord2 = new Order(102,4000, "Hitachi");
        Order ord3 = new Order(103,6000, "Philips");
     
        
        List<Order> orders = new ArrayList<Order>();//putting Objects into Collection to sort
        orders.add(ord3);
        orders.add(ord1);
        orders.add(ord2);
     
        System.out.println("Unsorted Collection : " + orders);
     
        Collections.sort(orders); //Sorting Order Object on natural order - ascending
        System.out.println("List of Order object sorted in natural order : " + orders);
     
        
        Collections.sort(orders, Collections.reverseOrder()); // Sorting object in descending order in Java
        System.out.println("List of object sorted in descending order : " + orders);
             
        
        Collections.sort(orders, new Order.OrderByAmount());//Sorting object using Comparator in Java
        System.out.println("List of Order object sorted using Comparator - amount : " + orders);
     
        
        Collections.sort(orders, new Order.OrderByCustomer());// Comparator sorting Example - Sorting based on customer
        System.out.println("Collection of Orders sorted using Comparator - by customer : " + orders);
	}
}
