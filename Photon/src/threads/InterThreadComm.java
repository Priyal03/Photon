package threads;

class ValueObject {

	int num;
	boolean set = false;

	public synchronized void getNum() {
		while (!set) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("consuming " + num);
		set = false;
		notify();
	}

	public synchronized void setNum(int num) {
		while (set) {
			try {
				wait(); // wait on thread is done with the help of object.
				// thread is waiting for this particular object here.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("setting value " + num);
		this.num = num;
		set = true;
		notify();
	}
}

class Producer implements Runnable {

	ValueObject vo;

	Producer(ValueObject vo) {
		this.vo = vo;
		Thread t = new Thread(this, "producer");
		t.start();
	}

	public void run() {

		int i = 0;
		while (true) {
			vo.setNum(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {

	ValueObject vo;

	Consumer(ValueObject vo) {
		this.vo = vo;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}

	public void run() {

		while (true) {

			try {
				vo.getNum();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class InterThreadComm {

	public static void main(String[] args) {

		ValueObject vo = new ValueObject();

		new Producer(vo); // using annonymous object.
		new Consumer(vo);

	}

}
