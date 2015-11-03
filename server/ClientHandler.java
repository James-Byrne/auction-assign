/*
  Author : James Byre

  Functionlaity:
  - Manage interaction with a client
  - Allow clients to submit a bid
    - Say hello
    - Tell the user what item is currently on auction
    - Take a bid
*/


class ClientHandler extends Thread {

  private Socket client;
  private Scanner input;
  private PrintWriter output;

  public ClientHandler(Socket client) {
    // client is referenced by socket number
    this.client = client;

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
  }

  public void run(){
    // String for user input
    String userMessage;

    // Give the user instructions
    output.println("\nHello! Welcome to the auction\n");
    output.println("The current item is a ???\n");
    output.println("The time left is ???\n");
    output.println("To place a bid simply enter a number, to quit type QUIT \n");



    // Handle clients input & bids
    do {
      // Accept message from the client
      userMessage = input.nextLine();



    } while (!recieved.equals("QUIT"));
  }
}
