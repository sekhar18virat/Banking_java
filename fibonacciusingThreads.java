import java.util.ArrayList;
import java.util.List;

//import com.sun.tools.javac.util.List;

public class FibnocThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1=new ArrayList<>();
		int size=10;
		producer11 p1=new producer11(l1,size);
		Thread t1=new Thread(p1,"T1");
		t1.start();
		
	}

}

class producer11 implements Runnable{
	private int capacity;
	private List<Integer> nums=new ArrayList<>();
	producer11(List<Integer> nums,int capacity){
		this.nums=nums;
		this.capacity=capacity;
		nums.add(0);
		nums.add(1);
	}
	public void produce(int i) throws InterruptedException {
		synchronized(nums) {
			while(nums.size()==capacity) {
				System.out.println("Completed the execution "+Thread.currentThread().getName());
				nums.wait();
			}
			Thread.sleep(1000);
			nums.add(nums.get(i-1)+nums.get(i-2));
			System.out.println(nums);
			//nums.add(i);
			System.out.println("produced by "+Thread.currentThread().getName()+" Value is "+nums.get(i));
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i=2;
		try {
			while(i<=capacity) {
				produce(i++);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}