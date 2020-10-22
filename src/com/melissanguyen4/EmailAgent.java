package com.melissanguyen4;
//resources: https://www.samlogic.net/articles/smtp-commands-reference.htm
//https://www.geeksforgeeks.org/send-email-using-java-program/
import java.io.*;
import java.net.*;




public class EmailAgent {

    public static void main(String[] args) throws Exception {
	    // write your code here

        // Establish a TCP connection with the mail server.
            // SMTP port 25 continues to be used primarily for SMTP relaying. SMTP relaying is the transmission of email from email server to email server.
        Socket socket = new Socket(" " + "hostname", 25 );
        // Create a BufferedReader to read a line at a time.
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        // Read greeting from the server.

        String response = br.readLine();
        System.out.println(response);
        if (!response.startsWith("220")) {
            throw new Exception("220 reply not received from server.");
        }
        // Get a reference to the socket's output stream.

        OutputStream os = socket.getOutputStream();
        // Send HELO command and get server response.
        String command = "HELO ALICE\r\n";
        System.out.print(command);
        os.write(command.getBytes("US-ASCII"));
        response = br.readLine();
        System.out.println(response);
        if (!response.startsWith("250")) {
            throw new Exception("250 reply not received from server.");
        }
        // Send MAIL FROM command.

        String mailFrom = "MAIL FROM: <email>";
        System.out.print(mailFrom);
        os.write(command.getBytes("US-ASCII"));
        response = br.readLine();
        System.out.println(response);
        if (!response.startsWith("250")) {
            throw new Exception("250 reply not received from server.");
        }
        // Send RCPT TO command.

        String commandRTPT = "RCPT TO: <email>";
        System.out.print(commandRTPT);
        os.write(command.getBytes("US-ASCII"));
        response = br.readLine();
        System.out.println(response);
        if (!response.startsWith("250")) {
            throw new Exception("250 reply not received from server.");
        }

        // Send DATA command.
        String commandDATA = "DATA TO: <email>";
        System.out.print(commandDATA);
        os.write(command.getBytes("US-ASCII"));
        response = br.readLine();
        System.out.println(response);
        if (!response.startsWith("354")) {
            throw new Exception("354 reply not received from server.");
        }

        // Send message data.
        String sendMessage = "email sent";
        System.out.print(sendMessage);
        os.write(command.getBytes("US-ASCII"));



        // End with line with a single period.

        String singlePeriod = ".";
        System.out.print(singlePeriod);
        os.write(command.getBytes("US-ASCII"));
        response = br.readLine();
        System.out.println(response);
        if (!response.startsWith("250")) {
            throw new Exception("250 reply not received from server.");
        }




        // Send QUIT command.
        // closing connection <SERVER> Service closing transmission channel
        String commandQUIT = "QUIT";
        System.out.print(commandQUIT);
        os.write(command.getBytes("US-ASCII"));
        response = br.readLine();
        System.out.println(response);
        if (!response.startsWith("221")) {
            throw new Exception("221 reply not received from server.");
        }


    }
}
