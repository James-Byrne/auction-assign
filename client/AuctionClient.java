/*
  Author : James Byrne

  Description
    - Establish a connection with a server
*/

import java.io.*;
import java.net.*;
import java.util.*;

public class AuctionClient {

  private static InetAddress host;
  private static final int PORT = 1234;
  private String response;
  private Int currentTime;

  public static void main(String[] args) {

    // Try to establish a connection with the server on localhost
    try {
      host = InetAddress.getLocalHost();
    }
    // Else exit the application
    catch (UnknownHostException uhEx){
      system.out.println("\nHost ID not found");
      system.exit(1);
    }

    run();
  }

  public static void run(){
    Socket link = null;

    try {
      // get and input and output stream
      output = new DataOutputStream(smtpSocket.getOutputStream());
      input = new DataInputStream(smtpSocket.getInputStream());

      // Wait for user input
      do {

        // Check for user input
        if((response = input.readLine()) != null) {
          // send the output to the server
          output.println(response);
        }


      } while(response != "Quit");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
