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
  private Scanner input;
  private PrintWriter output;
  private String currentBid;

  public ClientHandler(Socket client, ItemHandler itemHandler) {
    // client is referenced by socket number
    this.client = client;
    this.itemHandler = itemHandler;
  }

  public void run(){
    // String for user input
    String userMessage;

    // Give the user instructions
    output.println("\nHello! Welcome to the auction\n");
    output.println("The current item is"
    + itemHandler.getCurrentItem() + "\n");
    output.println("The time left is"
    + itemHandler.getCurrentBid() + "\n");
    output.println("To place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT \n");



    // Handle clients input & bids
    do {
      // Accept message from the client
      // userMessage = input.nextLine();

      // Accept messages from the user
      try {
        input = new Scanner(client.getInputStream());
        output = new PrintWriter(
        client.getOutputStream(), true
        );
      }
      catch(IOException ioEx) {
        ioEx.printStackTrace();
      }

      try {
        if(client.input == "get bid") {
          // echo the current bid
        }
        if(Integer.parseInt(client.input) > 0) {
          if(itemHandler.getCurrentBid() > currentBid){
              currentBid = itemHandler.getCurrentBid();
              //  echo to the user the change in the bid
          } else {
            // echo bid not set, too low
            // echo the current bid
          }
        } else {
          // Throw error to the user, input not a number
        }
      } catch() {
          // throw invalid input error
      }

    } while (!recieved.equals("QUIT"));
  }
}