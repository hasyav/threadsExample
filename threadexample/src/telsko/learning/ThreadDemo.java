package telsko.learning;

//there will be a main thread for a class.but  for syncronus operations we need to do extends Thread
// no priority - random order
class Hi extends Thread{// when we extend a class with thread.the object will become a thread,it will have thread properties
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hi");
		try {
		Thread.sleep(1000);// there will be a default thread in java - main thread this is that
		}catch(Exception e) {}
			
		}
		
	}
}

class Hello extends Thread{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("Hello");	
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		
		
	}
}
public class ThreadDemo {

	public static void main(String[] args) {
		
Hi obj1 = new Hi();
Hello obj2 = new Hello();

obj1.start(); // start always calls run. we have to write the ipliemented code in run method -- must
try {Thread.sleep(10);}catch(Exception e) {}//add a delay so that "Hi" executes first -- no clash between two


obj2.start();

//obj1.show();
//obj2.show();
	}

}
