package Threading;



public class TestThread {

	public static void main(String[] args) {
		Mythread1 th1 = new Mythread1();
		th1.start();
		Mythread1 th2 = new Mythread1();
		th2.start();
		Mythread1 th3 = new Mythread1();
		th3.start();
	}

}
