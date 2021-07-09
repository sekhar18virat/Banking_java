import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//import com.sun.org.apache.xpath.internal.operations.Mult;

public class giventest_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//();
		ArrayList<user22> users=new ArrayList<user22>();
		user22 u1=new user22(2,"virat","vizag","1234");
		u1.addAddress("hyd","4567");
		users.add(u1);
		user22 u2=new user22(3,"mahesh","delhi","4567");
		u2.addAddress("vizag","1234");
		users.add(u2);
		HashMap<String,ArrayList<user22>> h1=getCityUserinfo(users);
		print(h1);
		
	}

	private static void print(HashMap<String, ArrayList<user22>> h1) {
		// TODO Auto-generated method stub
        h1.entrySet().stream().forEach(e -> {
            System.out.format("City %s ", e.getKey());
            ArrayList<user22> usr1= e.getValue();
            usr1.forEach(usr -> System.out.print(" Id "+usr.getId()+ " name: " +usr.getName()));
            System.out.println();
        });
		
	}

	private static HashMap<String, ArrayList<user22>> getCityUserinfo(ArrayList<user22> users) {
		// TODO Auto-generated method stub
		HashMap<String,ArrayList<user22>> h1=new HashMap<>();
		for(user22 u:users) {
			ArrayList<Address> add=u.getaddress();
			for(Address a: add) {
				if(h1.containsKey(a.getCity())) {
					ArrayList<user22> k1=h1.get(a.getCity());
					k1.add(u);
				}
				else {
					ArrayList<user22> u12=new ArrayList<>();
					u12.add(u);
					h1.put(a.getCity(),u12);
				}
			}
		}
		return h1;
		//return null;
	}

}
class Address{
	private String city,zip;
	Address(String city ,String zip){
		this.city=city;
		this.zip=zip;
	}
	public String getCity() {
		return city;
	}
	public String getzip() {
		return zip;
	}
	
}
class user22{
	private int id;
	private String name;
	private ArrayList<Address> address=new ArrayList<Address>();
	user22(int id,String name,String city,String zip){
		this.id=id;
		this.name=name;
		Address arr=new Address(city,zip);
		address.add(arr);
		
	}
	public void addAddress(String city,String zip) {
		Address a=new Address(city,zip);
		address.add(a);
	}
	public ArrayList getaddress() {
		return address;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
