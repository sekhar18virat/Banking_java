import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Task_bank2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> acc=new HashSet<>();
		acc.add(103);
		acc.add(101);
		acc.add(104);
		customer c1=new customer("Sekhar",acc);
		Transaction t=new Transaction(4,0,10,0);
		//t.print();
		int ac1=101;
		int amount=100;
		t.withDrawl(c1,ac1,amount);
		t.print();
	}

}

//**************************************************************
class customer{
	 private String name;
	 private Set<Integer> accountno=new HashSet<>();
	
	 customer(String name,Set<Integer> acc){
		this.name=name;
		this.accountno=acc;
	}
	
	public Set getAcc() {
		return accountno;
	}
	
}

//**********************************************************************

class Transaction{
	public HashMap<Integer,Integer> noOfNotes=new HashMap<>();;
	public static double loadfactor=0.5;
	int amount;
	
	//*****************************************************************
	Transaction(int n50,int n20,int n10,int n5){
		noOfNotes.put(50, n50);
		noOfNotes.put(20, n20);
		noOfNotes.put(10, n10);
		noOfNotes.put(5, n5);
		this.amount=n50*50+n20*20+n10*10+n5*5;
		//print();
		}
	//*****************************************************************
	public boolean check_partial(int a,int b,int c) {
		double partial=b*loadfactor*a;
		if(this.amount-partial > c-partial) {
			return true;
		}
		return false;
		
	}
	//***********************************************************
	public void withDrawl(customer c1, int ac1, int amount) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		Set<Integer> checkacc=c1.getAcc();
		if(checkacc.contains(ac1)) {
			if(this.amount<amount) {
				System.out.println("Insufficient balance");
			}else {
				@SuppressWarnings("rawtypes")
				Iterator<Map.Entry<Integer,Integer>> itr=noOfNotes.entrySet().iterator();
				for(Map.Entry<Integer,Integer> itr2:noOfNotes.entrySet()) {
					int key=itr2.getKey();
					int value=itr2.getValue();
					if(check_partial(key,value,amount)) {
						int after_payment=(int) (value*loadfactor);
						noOfNotes.put(key,after_payment);
						this.amount-= after_payment*key;
					}
					else {
						noOfNotes.put(key,0);
					}
				}
				//print();
				
			}
			
		}else {
			System.out.println("Invalid account number ");
		}
		
	}
	//************************************************************
	public void print() {
		for(Map.Entry<Integer,Integer> itr:noOfNotes.entrySet()) {
			System.out.print(itr.getKey()+" ");
			System.out.println(itr.getValue());
			
		}
		
	}
	
}