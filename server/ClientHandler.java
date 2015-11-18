/*
  Author : James Byre

  Functionlaity:
  - Manage interaction with a client
  - Allow clients to submit a bid
    - Say hello
    - Tell the user what item is currently on auction
    - Take a bid
*/

import ItemHandler;

class ClientHandler extends Thread {

  private Socket client;
  private ItemHandler itemHandler;
  private DataInputStream input;
  private PrintStream output;
  private String currentBid;

  public ClientHandler(Socket client, ItemHandler itemHandler) {
    // client is referenced by socket number
    this.client = client;
    this.itemHandler = itemHandler;
  }

  public void run() {

    // Create the input and output streams for communication with the user
    try {
      input = new DataInputStream(client.getInputStream());
      output = new PrintStream(serviceSocket.getOutputStream());
      // TODO : Remove below if the above works
      // input = new Scanner(client.getInputStream());
      // output = new PrintWriter(
      // client.getOutputStream(), true
      // );
    }
    catch(IOException ioEx) {
      ioEx.printStackTrace();
    }

    // Give the user instructions
    output.println("\nHello! Welcome to the auction\n");
    output.println("The current item is"
    + itemHandler.getCurrentItem() + "\n");
    output.println("The time left is"
    + itemHandler.getCurrentBid() + "\n");
    output.println("To place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT \n");



    // Handle clients input & bids
    do {

      try {
        if(input.readLine() == "get bid") {
          // echo the current bid
        }
        if(Integer.parseInt(input.readLine()) > 0) {
          if(itemHandler.getCurrentBid() > currentBid){
              currentBid = itemHandler.getCurrentBid();
              //  echo to the user the change in the bid
              output.println(currentBid);
          } else {
            // echo bid not set, too low & echo current bid
            output.println("\nYour bid is too low, the current bid is: " + currentBid + "\n");
          }
        } else {
          // Throw error to the user, input not a number
          output.println("\nPlease input a number \n");
        }
      } catch() {
          // throw invalid input error
          output.println("\nInvalid input please see the original instructions below  \n");
          output.println("\nTo place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT\n\n")
      }

    } while (!recieved.equals("QUIT"));
  }
}
