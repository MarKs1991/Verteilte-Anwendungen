package Aufgabe1_2_Dispatcher;

public class DispatcherThread extends Thread{

	public int i;
	public F f;
	public static int n;
	static int []  intArray = new int[n];
	static DispatcherThread[] threadArray;

	public DispatcherThread(int i, F f, int n, DispatcherThread[] threadArray) {
		super();
		this.i = i;
		this.f = f;
		this.n = n;
		this.threadArray = threadArray;
	}
	public int[] getIntArray() {
		return intArray;
	}

	public void run()
	{
		Result result = new Result();
		int x = i * 5;

		if(n == x)
		{
			intArray = result.returnIntArray(n, this, threadArray);
			Dispatcher.running = false;
		}
	   result.putIntToArray(x, i, this);
	}
}