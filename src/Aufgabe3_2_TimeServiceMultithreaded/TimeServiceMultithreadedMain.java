package Aufgabe3_2_TimeServiceMultithreaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.*;
public class TimeServiceMultithreadedMain {

    TimeService timeService = new TimeService();
    public static void main(String[] args)
    {
        try{
            ServerSocket server=new ServerSocket(2100);
            int counter= 0;
            System.out.println("Server gestartet");
            while(true){
                counter++;
                Socket serverClient = server.accept();
                System.out.println("Client:" + counter + " verbunden");
                SocketThread socketThread = new SocketThread(serverClient,counter);

                socketThread.start();

            }
        }catch(Exception e) {
            System.out.println(e);
        }
       /* int ThreadCount = 2;

        SocketThread[] socketThreadArray = new SocketThread[ThreadCount];


        for (int i = 0; i <= ThreadCount - 1; i++)
        {
            socketThreadArray[i] = new SocketThread(true);
            socketThreadArray[i].start();
            System.out.println("Active Threads:"+ Thread.activeCount());
        }*/

        /*try {
           ServerSocket serverSocket = new ServerSocket(2100);
           serverSocket.accept();

           TimeService timeService = new TimeService();
            timeService.timeServiceAPI(serverSocket);



            SocketThread socketThread = new SocketThread(serverSocket);
            SocketThread.start();
          /*  int ThreadCount = 1;

            SocketThread[] socketThreadArray = new SocketThread[ThreadCount];
            for (int i = 0; i <= ThreadCount - 1; i++)
            {
                socketThreadArray[i] = new SocketThread(socket);
                socketThreadArray[i].start();
                System.out.println("Active Threads:"+ Thread.activeCount());
            }*/

       /* } catch (IOException e) {
            e.printStackTrace();*/

    }
}
