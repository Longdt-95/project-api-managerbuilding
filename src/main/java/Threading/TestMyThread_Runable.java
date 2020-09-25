package Threading;


public class TestMyThread_Runable {

	public static void main(String[] args) {
		Mythread2 th1 = new Mythread2();
		Thread th1_1 = new Thread(th1);
		th1_1.start();
		Thread th1_2 = new Thread(th1);
		th1_2.start();
		Thread th1_3 = new Thread(th1);
		th1_3.setPriority(7);
		th1_3.start();
	}

}
