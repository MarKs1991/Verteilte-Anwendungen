package Aufgabe1_2_Dispatcher;

public class Result implements F{

	int x;
	int n;
	static int [] intArray = new int[DispatcherThread.n ];

	protected void putIntToArray(int x, int i, DispatcherThread CurrentThread) {
	synchronized (CurrentThread)
		{
			int f = f(x);
			intArray[i] = f;
			try {
				CurrentThread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	protected int[] returnIntArray(int n, DispatcherThread CurrentThread, DispatcherThread[] threadArray) {
		for (int i = 0; i <= threadArray.length -1 ; i++){
			synchronized (threadArray[i]) {

				threadArray[i].notify();
			}
	}
		return intArray;
	}

	protected void notifyThread(DispatcherThread CurrentThread ){
		synchronized (CurrentThread)
		{
			CurrentThread.notifyAll();
		}
	}
	@Override
	public int f(int x) {
		return x;
	}
}
