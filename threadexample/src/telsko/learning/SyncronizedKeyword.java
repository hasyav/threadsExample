package telsko.learning;

class Counter{
	int count;
	
	public synchronized int increment() {
		return count++; // count = count + 1
	}
}


public class SyncronizedKeyword {

	public static void main(String[] args) throws Exception {
		
		Counter c = new Counter();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<1000;i++) {
					c.increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<1000;i++) {
					c.increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("count is" + c.count);

	}

}
