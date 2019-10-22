package Aufgabe4_1_HTTPS_Client;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPSClient {

    public static void main(String[]args)
    {
        //Aufgabe 4.1
        String URLOutput = get("https://www.bundestag.de/presse");

        //Aufgabe 4.2a
        boolean Existing = urlExists("https://aslp0329.azurewebsites.net");
        System.out.println(Existing);

        //Aufgabe 4.2b
        String URLOutputString = getHTMLString("https://aslp0329.azurewebsites.net");
        System.out.println(URLOutputString);
        System.out.println(URLOutputString.length());
    }


    public static String get(String URLstring)
    {
        try {
            URL url = new URL(URLstring);

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            try {

                SSLSocket socket = (SSLSocket) factory.createSocket(url.getHost(), 443);

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                writer.write("GET /presse HTTP/1.1");
                writer.newLine();
                writer.write("Host: www.bundestag.de");
                writer.newLine();
                writer.write("");
                writer.newLine();
                writer.flush();


        boolean reading = true;

              while(reading)
              {
                  String output = reader.readLine();
                  System.out.println(output);
                  if(output == null)
                  {
                      reading = false;
                  }
              }

                 } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    return URLstring;
    }


    public static boolean urlExists(String s) {
        try {
            URL url = new URL(s);

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            try {

                SSLSocket socket = (SSLSocket) factory.createSocket(url.getHost(), 443);


                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                writer.write("GET /presse HTTP/1.1");
                writer.newLine();
                writer.write("Host: www.bundestag.de");
                writer.newLine();
                writer.write("");
                writer.newLine();
                writer.flush();

                boolean reading = true;
                if(reader.readLine()!= null) {
                    return true;
                }
                else
                    {
                        return false;
                    }

            } catch (IOException e) {
                return false;
            }
        } catch (MalformedURLException e) {
            return false;
        }
    }


    public static String getHTMLString(String URLstring)
    {
        String output1 = "";
        try {
            URL url = new URL(URLstring);

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

            try {
                SSLSocket socket = (SSLSocket) factory.createSocket(url.getHost(), 443);

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                writer.write("GET /presse HTTP/1.1");
                writer.newLine();
                writer.write("Host: www.bundestag.de");
                writer.newLine();
                writer.write("");
                writer.newLine();
                writer.flush();

                StringBuffer stringBuffer = new StringBuffer();

                boolean reading = true;
                while(reading)
                {


                    String output = reader.readLine();
                    stringBuffer.append(output);
                    if(output == null)
                    {
                        break;
                    }

                    stringBuffer.toString();


                    output1 = output1 + output;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return output1;
    }
}