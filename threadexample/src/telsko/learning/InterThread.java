package telsko.learning;

class Q {
	int num;
	boolean valSet = false;
	
//	while using wait use synchronized because we dont need any conflict
//	wait and notify belong to object class.they wait for objects
	public synchronized void put(int num) {
// for wait we dont specify time- so there should be some other thread that should be notified		
		while(valSet) {
			try { wait();}catch(Exception e) {} 
		}
		System.out.println("put"+num);
		this.num = num;
		valSet=true;
		notify();
	}
	
	public synchronized void get() {
		
		while(!valSet) {
			try { wait();}catch(Exception e) {} 
		}
		System.out.println("get"+num);
		valSet=false;
		notify();
	}
}

class Producer implements Runnable{
	
	Q q;

	public Producer(Q q) {
		super();
		this.q = q;
		Thread t = new Thread(this,"Producer");
		t.start();
	}
	
	public void run() {
		int i = 0;
		while(true) {
			q.put(i++);
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}
}

class Consumer implements Runnable{
	
	Q q;

	public Consumer(Q q) {
		super();
		this.q = q;
		Thread t = new Thread(this,"Consumer");
		t.start();
	}
	
	public void run() {
		q.get();
		try {Thread.sleep(1000);}catch(Exception e) {}
	}
}

public class InterThread {
// threads interacting with each other
	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);

	}

}
