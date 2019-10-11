package Aufgabe2_1_TimeService;

import com.sun.security.ntlm.Server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeService {

    private String Input = "";

    public void timeServiceAPI()
    {
        boolean running = true;

        while(running) {

            try {
                ServerSocket serverSocket = new ServerSocket(2100);


                Socket socket = serverSocket.accept();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                bufferedWriter.write("Time Service: Geben sie date oder time ein um Datum oder Uhrzeit zu erhalten, " +
                        "geben sie etwas anderes ein um die Verbindung zu trennen," +
                        " um den Server komplett runterzufahren geben sie exterminate ein.");
                bufferedWriter.newLine();
                bufferedWriter.flush();


                while (!Input.equals("exterminate")) {

                    Clock clock = new Clock();

                    Input = bufferedReader.readLine();
                    if (Input.equals("date")) {
                        bufferedWriter.write(clock.date());
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } else if (Input.equals("time")) {
                        bufferedWriter.write(clock.time());
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    /*} else if (Input.equals("end")){
                            running
                            socket.close();*/
                    } else {
                        bufferedWriter.write("Abbruch der Verbindung");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        socket.close();
                    }
                }
                running = false;


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
