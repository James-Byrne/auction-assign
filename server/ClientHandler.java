/*
  Author : James Byre

  Functionlaity:
  - Manage interaction with a client
  - Allow clients to submit a bid
    - Say hello
    - Tell the user what item is currently on auction
    - Take a bid
*/

import java.io.*;
import java.net.*;
import java.util.*;

class ClientHandler implements Runnable {

  private Socket client;
  private ItemHandler itemHandler;
  private DataInputStream input;
  private PrintWriter output;
  private String currentBid;
  private String recieved;

  public ClientHandler(Socket client, ItemHandler itemHandler) {
    // client is referenced by socket number
    this.client = client;
    this.itemHandler = itemHandler;
  }

  public void run() {
    System.out.println("\n Entered the run function \n");
    // Create the input and output streams for communication with the user
    try {
      input = new DataInputStream(client.getInputStream());
      output = new PrintWriter(client.getOutputStream());
      System.out.println("\nSuccessfully got input & output stream \n");

      // TODO : Remove this test later
      output.print("test");
      System.out.println("\nSuccessfully got input & output stream \n");

      // Give the user instructions
      output.println("\nHello! Welcome to the auction\n");
      output.println("The current item is " + itemHandler.getCurrentItem() + "\n");
      output.println("The current bid is " + itemHandler.getCurrentBid().toString() + "\n");
      output.println("To place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT \n");
      System.out.println("\nSuccessfully got input & output stream \n");

      // Handle clients input & bids
      do {
        try {
        recieved = input.readLine();
          if(recieved == "get bid") {
            // echo the current bid
            output.println(currentBid);
            System.out.println("\n bid request resolved \n");
          }
          if(Integer.parseInt(recieved) > 0) {
            if(Integer.parseInt(itemHandler.getCurrentBid()) > Integer.parseInt(currentBid)){
                currentBid = itemHandler.getCurrentBid();
                // echo to the user the change in the bid
                output.println(currentBid);
            } else {
              // echo bid not set, too low & echo current bid
              output.println("\nYour bid is too low, the current bid is: " + currentBid + "\n");
            }
          } else {
            // Throw error to the user, input not a number
            output.println("\nPlease input a number \n");
          }
        } catch(IOException ioEx) {
            ioEx.printStackTrace();
            // throw invalid input error
            output.println("\nInvalid input please see the original instructions below  \n");
            output.println("\nTo place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT\n\n");
        }

      } while (!recieved.equals("QUIT"));
      // Connection closed
      output.println("Connection closed");
    }
    catch(IOException ioEx) {
      ioEx.printStackTrace();
    }
  }
}
