package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer Class in java.
 */
class Prod implements Runnable {

	private final BlockingQueue<Integer> sharedQueue;

	public Prod(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println("Produced : " + i);
				// put/produce into sharedQueue.
				sharedQueue.put(i);
			} catch (InterruptedException ex) {
				System.out.println("Exception in Producer Run method at : " + i);
			}
		}
	}

}

/**
 * Consumer Class in java.
 */
class Con implements Runnable {

	private BlockingQueue<Integer> sharedQueue;

	public Con(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				// take/consume from sharedQueue.
				System.out.println("				CONSUMED : " + sharedQueue.take());
			} catch (InterruptedException ex) {
				System.out.println("Exception in Consumer Run method  : " );
			}
		}
	}

}

public class PCwithBQ {

	public static void main(String args[]) {

		// Creating shared object
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();

		Prod producer = new Prod(sharedQueue);
		Con consumer = new Con(sharedQueue);

		Thread producerThread = new Thread(producer, "ProducerThread");
		Thread consumerThread = new Thread(consumer, "ConsumerThread");
		producerThread.start();
		consumerThread.start();

	}

}