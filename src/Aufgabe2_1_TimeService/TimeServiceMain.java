package Aufgabe2_1_TimeService;

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

           TimeService timeService = new TimeService();
           timeService.timeServiceAPI();

    }
}
