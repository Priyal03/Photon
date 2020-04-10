package threads;

class Counter{
	
	int count;
	
	public synchronized void increment() {
		count++;
	}
}

public class SycnDemo {
	
	public static void main(String agrs[]) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Counter c =new Counter();	
//		c.increment();
		
		Thread t1 = new Thread ( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++) {
					c.increment();
				}
			}
		});
		
		Thread t3 = new Thread ( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<1000;i++) {
					c.increment();
				}
			}
		});
		
		t1.start();
		
		t3.start();
		
		t1.join();
		
		System.out.println("count "+c.count);
		
		t3.join(); //any number can come btwn 1000 to 2000. 
//if I do start join start join then it will be 2000 perfect as its anyway getting performed by two threading 
		//not in parallel but one after another.
		
		
		System.out.println("count "+c.count);
	}

}
