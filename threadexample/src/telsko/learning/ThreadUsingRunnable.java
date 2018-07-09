package telsko.learning;

class A
{}

// priority range(1-10). by default all threads have the same priority - (5)
//If a class already extends some class then we use runnable interface 
	class PrintHi extends A implements Runnable{// runnable interface is a functional interface .has only one method called "run"
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hi");
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
			
		}
		
	}
}

class PrintHello extends A implements Runnable{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hello");	
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		
		
	}
}

public class ThreadUsingRunnable {

	public static void main(String[] args) throws Exception{
		
PrintHi obj1 = new PrintHi();
PrintHello obj2 = new PrintHello();

//obj1.start(); --- runnable interface does not have start method
// If we create threads.It will run the "run" method in threads 
//Pass the object of runnable to thread


Thread t1 = new Thread(obj1);
t1.start();
try {Thread.sleep(10);}catch(Exception e) {}

Thread t2 = new Thread(obj2);
t2.start();
//obj2.start();

t1.setPriority(Thread.MIN_PRIORITY);
t2.setPriority(Thread.MAX_PRIORITY);


t1.setName("Hi Thread");
t2.setName("Hello Thread");
System.out.println(t1.getName());//default name will be Thread-0
System.out.println(t2.getName());//default name will be Thread-1


System.out.println(t1.isAlive());// returns true

t1.join(); // joins two threads together and makes the main thread wait until until threads finish execution
t2.join(); // t1 and t2 are branches of main thread -- after finishing execution t1 and t2 join the main thread

//obj1.show();
//obj2.show();

System.out.println(t1.isAlive()); // returns false - thread dead

System.out.println("bye");// --- we need it at the last -- main thread prints bye before because it doesnot have any job
	}

}
