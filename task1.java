import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Emp{ 	
	int salary; 	
	String city,name; 	
	Emp(int salary, String city, String name){ 		
		this.salary = salary; 
		this.city =city; 
		this.name = name; 
		} 	 	
	public int getSalary() {
		return salary;
	}
	public String getCity() {
		return city;
	}
	public String toString() { 
	// TODO Auto-generated method stub 
		return this.name; 	} 
	} 
public class clsss {  	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) { 	
		// TODO Auto-generated method stub 		
		ArrayList<Emp> empl= new ArrayList<Emp>(); 
		empl.add(new Emp(10000,"BOMBAY","E1")); 	
		empl.add(new Emp(12000,"DELHI","E2")); 	
		empl.add(new Emp(10000,"BHVRM","E3")); 	
		empl.sort((Emp l1,Emp l2)->l1.getSalary()-l2.getSalary()); 	
		empl.sort((Emp l1,Emp l2)->l1.getCity().compareTo(l2.getCity()));
		System.out.println(empl);  	}  
	
}