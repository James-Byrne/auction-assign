/*
  Author : James Byrne

  Functionality
  - Take a client connection
  - Create a new instance of ItemHandler
  - Spawn a ClientHandler and pass a reference to the ItemHandler
*/
import java.io.*;
import java.net.*;
import java.util.*;

public class AuctionServer {

  private static ServerSocket serverSocket;
  private static final int PORT = 1234;

  public static void main(String[] args) throws IOException {

    // Try to setup a socket at PORT
    // Else exit application
    try {
      serverSocket = new ServerSocket(PORT);
      System.out.println("\nPort connected suscessfully \n");
    }
    catch (IOException ioEx) {
      System.out.println("\nUnable to set up port at " + PORT + "\n\n");
			System.exit(1);
    }

    // Create the itemHandler thread and pass reference to every client connection
    ItemHandler itemHandler = new ItemHandler();

    do {

      try {
        // Wait for the client to make a connection
        Socket client = serverSocket.accept();
        System.out.println("\nNew client accepted.\n");

        Thread clientHandler = new Thread(new ClientHandler(client, itemHandler));
        clientHandler.start();

        // // Spawn a new client handler to take over the auction
        // ClientHandler handler = new ClientHandler(client, itemHandler);
        //
        // handler.run();
      }
      catch (IOException ioEx) {
        ioEx.printStackTrace();
      }
    }while(true);
  }
}
