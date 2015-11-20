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
  private static Socket link;
  private static PrintWriter output;
  private static Scanner networkInput;
  private static Scanner userInput;

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
    Thread clientThread = new Thread(new ClientThreadHandler(host, PORT));
    clientThread.start();
  }

  // private static void sendMessages() {
  //   try {
  //     link = new Socket(host, PORT);
  //     // get and input and output stream
  //     output = new PrintWriter(link.getOutputStream(), true);
  //     networkInput = new Scanner(link.getInputStream());
  //
  //     // Look for user input
  //     userInput = new Scanner(System.in);
  //
  //     // TODO: Remove this
  //     System.out.println("Successfully opened input and output streams");
  //
  //   } catch (IOException e) {
  //     e.printStackTrace();
  //   }
  //
  //
  //   // Strings for holding the messages to be sent
  //   // and responses fromt he server
  //   String message = "";
  //   String response = "";
  //
  //   // Wait for user input
  //   do {
  //     while ((response = networkInput.nextLine()) != null) {
  //       System.out.println(response);
  //     }
  //     while((message = userInput.nextLine()) != null){
  //       // TODO : Remove this after debugging
  //       System.out.println(message);
        // output.println(message);
  //     }
  //     output.flush();
  //   } while(message != "QUIT");
  //
  //   System.out.println("\nGoodbye");
  //   System.exit(1);
  // }
}
