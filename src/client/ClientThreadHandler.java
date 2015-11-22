import java.net.*;
import java.io.*;
import java.util.*;

public class ClientThreadHandler implements Runnable {

  private Socket link;
  private PrintWriter output;
  private Scanner networkInput;
  private Scanner userInput;
  private InetAddress host;
  private int PORT;
  private int currentTime;

  public ClientThreadHandler (InetAddress host, int PORT) {
    this.host = host;
    this.PORT = PORT;
  }

  public void run() {
    try {
      link = new Socket(host, PORT);
      // get and input and output stream
      output = new PrintWriter(link.getOutputStream(), true);
      networkInput = new Scanner(link.getInputStream());

      // Look for user input
      userInput = new Scanner(System.in);

      // Show that we succesfully opened input and output streams
      System.out.println("\n\nSuccessfully opened input and output streams");

    } catch (IOException e) {
      e.printStackTrace();
    }

    // Give the user instructions
    System.out.println("\nHello! Welcome to the auction.");
    System.out.println("The current item is " + networkInput.nextLine().toString());
    System.out.println("The current bid is " +  networkInput.nextLine().toString());
    System.out.println("To place a bid simply enter a number greater than the minimum bid, to find out what the current bid is enter 'get bid' to quit type QUIT \n");


    // Strings for holding the messages to be sent
    // and responses fromt he server
    String message = "";
    String response = "";

    // Wait for user input
    do {
      message = userInput.nextLine();
      output.println(message);

      response = networkInput.nextLine().toString();
      System.out.println(response);
    } while(message != "QUIT");

    System.out.println("\nGoodbye");
    System.exit(1);
  }
}
