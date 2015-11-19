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
  private static Integer currentTime;

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

    try {
      Socket link = new Socket(host, PORT);
      // get and input and output stream
      PrintWriter output = new PrintWriter(link.getOutputStream());
      Scanner networkInput = new Scanner(link.getInputStream());
      Scanner userInput = new Scanner(System.in);
      String message, response;


      // Wait for user input
      do {
        message =  userInput.nextLine();
        output.println(message);
        response = networkInput.nextLine();
        System.out.println(response);
      } while(response != "QUIT");

      System.out.println("\nGoodbye");
      System.exit(1);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
