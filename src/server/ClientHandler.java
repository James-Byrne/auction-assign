/*
  Author : James Byre

  Description:
  The Client Handler class manages a users (client) session. It does this by revcieving user input from the client machine and acting upon it.

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
  private Scanner input;
  private PrintWriter output;
  private String currentBid;

  public ClientHandler(Socket client, ItemHandler itemHandler) {
    // client is referenced by socket number
    this.client = client;
    this.itemHandler = itemHandler;
  }

  public void run() {
    System.out.println("Entered the run function ");
    // Create the input and output streams for communication with the user
    try {
      input = new Scanner(client.getInputStream());
      output = new PrintWriter(client.getOutputStream(), true);

      System.out.println("Successfully got input & output stream ");


      output.println(itemHandler.getCurrentItem());
      output.println(itemHandler.getCurrentBid());

// TODO : clean up this file
      // Give the user instructions
      // output.println("\nHello! Welcome to the auction.");
      // output.println("The current item is " + itemHandler.getCurrentItem());
      // output.println("The current bid is " + itemHandler.getCurrentBid().toString());
      // output.println("To place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT \n");
      // Flush the output stream
      // output.flush();
      // System.out.println("Instructions given to client");

      String recieved;

      // Handle clients input & bids
      do {
        System.out.println("Waiting on user input");
        // TODO: Something wrong with this line?
        recieved = input.nextLine();
        System.out.println("Got user input : " + recieved);

        if(recieved == "get bid") {
          // echo the current bid
          output.println("The current bid is " + currentBid);
          System.out.println("\n bid request resolved \n");

        } else if(Integer.parseInt(recieved) > 0) {
          // The above line needs a try catch for a number format exception 
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
      } while (recieved.equals("QUIT"));
    } catch(IOException ioEx) {
        ioEx.printStackTrace();
        // throw invalid input error
        output.println("\nInvalid input please see the original instructions below  \n");
        output.println("\nTo place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT\n\n");
    }
  }
}
