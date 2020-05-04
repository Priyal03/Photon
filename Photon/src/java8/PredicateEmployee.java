package java8;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateEmployee 
{
    public static Predicate<Employeee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }
     
    public static Predicate<Employeee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }
     
    public static Predicate<Employeee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }
     
    public static List<Employeee> filterEmployees (List<Employeee> employees, 
                                                Predicate<Employeee> predicate) 
    {
        return employees.stream()
                    .filter( predicate )
                    .collect(Collectors.<Employeee>toList());
    }
}   
//shree leathers kolkata.