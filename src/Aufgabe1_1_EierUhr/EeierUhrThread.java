package Aufgabe1_1_EierUhr;

public class EeierUhrThread extends Thread{
	
	public int m;
	public String a;

	public EeierUhrThread(int m, String a) {
		super();
		this.m = m;
		this.a = a;
	}
	
	public void run()
	{
		schlafen(m);
		System.out.println("sleepTime:" +  m);
		System.out.println("Output:" + a);
	}
	
	private static void schlafen(int m)
	{
		try {
			
			System.out.println("Active Threads:"+ Thread.activeCount());
		
				while(m>0)
				{
				Thread.sleep(1000);
				System.out.println("RemainingTime:"+ m);
				m--;
				}
		
			}
		catch (InterruptedException t){}
		
	}
	
	
	
}
