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

      // TODO: Remove this
      System.out.println("Successfully opened input and output streams");

    } catch (IOException e) {
      e.printStackTrace();
    }


    // Strings for holding the messages to be sent
    // and responses fromt he server
    String message = "";
    String response = "";

    // Wait for user input
    do {
      while (networkInput.hasNextLine()) {
        response = networkInput.nextLine();
        System.out.println(response);
      }
      System.out.println("Server Message finished");
      while(userInput.hasNextLine()) {
        message = userInput.nextLine();
        System.out.println(message);
        output.println(message);
      }
    } while(message != "QUIT");

    System.out.println("\nGoodbye");
    System.exit(1);
  }
}
