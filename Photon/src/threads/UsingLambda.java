package threads;

public class UsingLambda {
	
	public static void main(String args[]) throws InterruptedException {
		
		Thread t1 = new Thread( //using anonymous class 
				
				() -> //using lambda expression to remove redundant object.
		{ 
			for(int i=0;i<5;i++) {
				System.out.println("piku");
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread( () -> 
		{
			for(int i=0;i<5;i++) {
				System.out.println("bhensu");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}

}
