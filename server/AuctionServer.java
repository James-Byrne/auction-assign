/*
  Author : James Byrne

  Functionlaity
  - Allow connections from multiple clients
  - Hand the client off to the ClientHandler
*/
import java.io.*;
import java.net.*;
import java.util.*;
import ClientHandler;
import ItemFactory;
import ItemHandler;

// TODO
// Spawn a item thread and hold it as long as the server is operating
// Then pass a reference to that thread to each ClientHandler

public class AuctionServer {

  private static ServerSocket serverSocket;
  private static final int PORT = 1234;

  public static void main(String[] args) throws IOException {

    // Try to setup a socket at PORT
    // Else exit application
    try {
      serverSocket  = new ServerSocket(PORT);
    }
    catch (IOException ioEx) {
      System.out.println("\nUnable to set up port at " + PORT);
			System.exit(1)
    }

    // Create the itemHandler thread and pass reference to every client connection
    ItemHandler itemHandler = new ItemHandler;
    itemHandler.newAuction();

    do {
      // Wait for the client to make a connection
      Socket client = serverSocket.accept();

      System.out.println("\nNew client accepted.\n");

      ClientHandler handler = new ClientHandler(client, itemHandler);

      handler.start();
    }while(true);
  }
}
