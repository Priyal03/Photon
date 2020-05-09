package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java8.PredicateEmployee.*;

public class TestEmployeePredicates {
	public static void main(String[] args) {
		Employeee e1 = new Employeee(1, 23, "M", "Rick", "Beethovan");
		Employeee e2 = new Employeee(2, 13, "F", "Martina", "Hengis");
		Employeee e3 = new Employeee(3, 43, "M", "Ricky", "Martin");
		Employeee e4 = new Employeee(4, 26, "M", "Jon", "Lowman");
		Employeee e5 = new Employeee(5, 19, "F", "Cristine", "Maria");
		Employeee e6 = new Employeee(6, 15, "M", "David", "Feezor");
		Employeee e7 = new Employeee(7, 68, "F", "Melissa", "Roy");
		Employeee e8 = new Employeee(8, 79, "M", "Alex", "Gussin");
		Employeee e9 = new Employeee(9, 15, "F", "Neetu", "Singh");
		Employeee e10 = new Employeee(10, 45, "M", "Naveen", "Jain");

		List<Employeee> employees = new ArrayList<Employeee>();
		employees.addAll(Arrays.asList(new Employeee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 }));

		System.out.println(filterEmployees(employees, isAdultMale()));

		System.out.println(filterEmployees(employees, isAdultFemale()));

		System.out.println(filterEmployees(employees, isAgeMoreThan(35)));

		// Employees other than above collection of "isAgeMoreThan(35)"
		// can be get using negate()
		System.out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));
	}
}

//They move your conditions (sometimes business logic) to a central place. This helps in unit-testing them separately.
//Any change need not be duplicated into multiple places. Java predicate improves code maintenance.
//The code e.g. “filterEmployees(employees, isAdultFemale())” is very much readable than writing a if-else block.