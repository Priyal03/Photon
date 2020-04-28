package basics;

public class Student implements Comparable<Student> {
	
	//comparable = natural ordering of objects. lexicographically
    private int id;
    String name;
    private int age;
 
    /*
     *Compare a given Student with current(this) object.
     *If current Student id is greater than the received object,
     *then current object is greater than the other.
     */ 

    public Student(int id,String name,int age) {
		// TODO Auto-generated constructor stub
    	this.id=id;
    	this.name=name;
    	this.age=age;
	}
    
	@Override
	public int compareTo(Student otherStudent) {
		// TODO Auto-generated method stub
		   return (this.id < otherStudent.id ) ? -1: (this.id > otherStudent.id) ? 1:0 ;
	}

}

