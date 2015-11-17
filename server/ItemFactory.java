/*
  Author - James Byrne

  Description
  TODO : If I have enough time change this to pass a JSON Object
  Creates an ArrayList, each item within the arraylist is a HashMap which represents and item and its properties. 
  An example of its structure can be seen below

  ArrayList[0] {
    Map.contents {
      "name" : "example"
      "bid"  : "0"
    }
  }

*/

import java.io.*;

public class ItemFactory {

  public ItemFactory () {
    // Default instructor
  }

  public ArrayList newAuction() {
    // holds the list of items for auction and their values
    List<Map> auctionItems = new ArrayList;
    // holds the information of a single item in the auction
    HashMap<String, String> item = new Hashmap();

    // fill the auction with items
    // Set the name and starting bid
    item.put('name', 'Antique Chair');
    item.put('bid', '10')
    auctionItems.add(item);

    this.item = new Hashmap();
    item.put('name', 'Antique Dresser');
    item.put('bid', '500');
    auctionItems.add(item);

    this.item = new Hashmap();
    item.put('name', 'Oak Table');
    item.put('bid', '0');
    auctionItems.add(item);

    this.item = new Hashmap();
    item.put('name', 'Victorian House');
    item.put('bid', '500000');
    auctionItems.add(item);

    // Return the list of items
    return auctionItems;
  }

}
