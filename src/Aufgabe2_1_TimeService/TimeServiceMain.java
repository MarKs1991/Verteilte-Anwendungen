package Aufgabe2_1_TimeService;

import Aufgabe1_2_Dispatcher.DispatcherThread;

public class TimeServiceMain {

    TimeService timeService = new TimeService();
    public static void main(String[] args)
    {
       /* int ThreadCount = 4;

        SocketThread[] socketThreadArray = new SocketThread[ThreadCount];

        TimeService timeService = new TimeService();
        for (int i = 0; i <= ThreadCount - 1; i++)
        {
            socketThreadArray[i] = new SocketThread(timeService);
            socketThreadArray[i].start();
            System.out.println("Active Threads:"+ Thread.activeCount());
        }*/
       boolean running = true;
       while(running){
           TimeService timeService = new TimeService();
           timeService.timeServiceAPI();
       }
    }
}
