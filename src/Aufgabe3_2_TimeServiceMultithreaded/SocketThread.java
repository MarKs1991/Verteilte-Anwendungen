package Aufgabe3_2_TimeServiceMultithreaded;

import java.net.Socket;

public class SocketThread extends Thread{

    Socket serverClient;
    int counter;

    public SocketThread(Socket serverClient, int counter) {
        this.serverClient = serverClient;
        this.counter = counter;
    }

    public void run()
    {
        TimeService timeService = new TimeService();
        timeService.timeServiceAPI(serverClient, counter);
    }
}
