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

      String recieved;

      // Handle clients input & bids
      do {
        System.out.println("Waiting on user input");
        recieved = input.nextLine();
        System.out.println("Got user input : " + recieved);
        try {
          if(recieved == "get bid") {
            // echo the current bid
            output.println("The current bid is " + currentBid);
            System.out.println("bid request resolved");

          } else if (Integer.valueOf(recieved) > 0) {

            if(Integer.valueOf(itemHandler.getCurrentBid()) > Integer.valueOf(currentBid)){
              currentBid = itemHandler.getCurrentBid();
              // echo to the user the change in the bid
              output.println(currentBid);
            } else {
              // echo bid not set, too low & echo current bid
              output.println("Your bid is too low, the current bid is: " + currentBid );
            }
          } else {
            // throw invalid input error
            output.println("Invalid input please see the original instructions below ");
            output.println("To place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT");
          }
        } catch (NumberFormatException e) {
          System.out.println("Caught number format error");
          System.out.println(e);
          output.println("Please input a number");
        }
      } while (!recieved.equals("QUIT"));
      System.out.println("User disconnected");
    } catch(IOException ioEx) {
        ioEx.printStackTrace();
    }
  }
}
