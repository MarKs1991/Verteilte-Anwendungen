package Aufgabe3_1_TimeServiceClient;

import java.awt.*;
import java.io.*;
import java.net.Socket;

public class TimeServiceClient {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        boolean running= true;
        try {

            while(running) {
            System.out.println("geben sie date oder time in die Konsole ein");
            input = reader.readLine();




            if (input.equals("date")) {
                String currentDate = dateFromServer("127.0.0.1");
                System.out.println(currentDate);
            }
            else if(input.equals("time")) {
                String currentTime = timeFromServer("127.0.0.1");
                System.out.println(currentTime);
            }
            else
                {
                running = false;
                System.out.println("Verbindung unterbrochen");
                }
        }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String dateFromServer(String ip) {

        String currentDate = null;
        try {
            Socket socket = new Socket(ip, 2100);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String Info = bufferedReader.readLine();
            //System.out.println(Info);

            bufferedWriter.write("date");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            currentDate = bufferedReader.readLine();
            //System.out.println(currentDate);

            bufferedWriter.write("a");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String ConInfo = bufferedReader.readLine();
            //System.out.println(ConInfo);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentDate;
    }


    public static String timeFromServer(String ip) {

        String currentTime = null;
        try {
            Socket socket = new Socket(ip, 2100);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String Info = bufferedReader.readLine();
            //System.out.println(Info);

            bufferedWriter.write("time");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            currentTime = bufferedReader.readLine();
            //System.out.println(currentTime);

            bufferedWriter.write("a");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String ConInfo = bufferedReader.readLine();
            //System.out.println(ConInfo);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return currentTime;
    }
}




