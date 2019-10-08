package Aufgabe1_2_Dispatcher;

import java.util.Arrays;

public class DispatcherMain{
	
	public static void main(String[] args) {
		int[] intArray = Dispatcher.execute(null, 10);

		System.out.println(Arrays.toString(intArray));

		System.exit(400);
		//Result result = new Result();
		//result.returnIntArray();
	}

}
