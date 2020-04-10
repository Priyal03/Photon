package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueue not only provide a data structure to store data * but also
 * gives you flow control, require for inter thread communication.
 */
public class ProducerConsumerSolution {
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();
		Produce p = new Produce(sharedQ);
		Consume c = new Consume(sharedQ);
		p.start();
		c.start();
	}
}

class Produce extends Thread {
	private BlockingQueue<Integer> sharedQueue;

	public Produce(BlockingQueue<Integer> aQueue) {
		super("PRODUCER");
		this.sharedQueue = aQueue;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(getName() + " produced " + i);
				sharedQueue.put(i);
				Thread.sleep(10); //just this statement makes whole of a difference from PCwithBQ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consume extends Thread{
	
	BlockingQueue<Integer> sharedQueue;
	
	public Consume(BlockingQueue<Integer> input) {
		// TODO Auto-generated constructor stub
		super("Consumer");
		this.sharedQueue = input;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++) {
			try {
				
				System.out.println("Consumed "+sharedQueue.take());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
