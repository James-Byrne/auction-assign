/*
  Author : James Byrne

  Description
    - Establish a connection with a server
    - Allow user to send input to the server
*/

import java.io.*;
import java.net.*;
import java.util.*;

public class AuctionClient {

  private static InetAddress host;
  private static final int PORT = 1234;
  private static String response;
  private static Integer currentTime;
  private static DataOutputStream output;
  private static DataInputStream input;
  private static Socket link;

  public static void main(String[] args) {

    // Try to establish a connection with the server on localhost
    try {
      host = InetAddress.getLocalHost();
    }
    // Else exit the application
    catch (UnknownHostException uhEx){
      System.out.println("\nHost ID not found");
      System.exit(1);
    }
    // TODO : Remove the below 
  //   run();
  // }
  //
  // public static void stop(){
  //   System.out.println("Stopping connection");
  //   System.exit(1);
  // }
  //
  // public static void run(){
  //   Socket link = null;

    try {
      link = new Socket(host, PORT);
      // get and input and output stream
      output = new DataOutputStream(link.getOutputStream());
      input = new DataInputStream(link.getInputStream());

      // Wait for user input
      do {

        // Check for user input
        if((response = input.readLine()) != null) {
          // send the output to the server
          output.writeUTF(response);
          output.flush();
        }


      } while(response != "Quit");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
