package Aufgabe1_1_EierUhr;

public class Eieruhr {
	

	public static void eieruhrStart(int ms, String output)
	{
		EeierUhrThread a = new EeierUhrThread(ms, output);
		a.start();
		
		
		
	}
	
	
}

