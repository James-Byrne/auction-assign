/*
  Author - James Byrne

  Description
  This class holds the information for all the different items that are used in the auction

*/

import java.io.*;

public class ItemFactory implements itemHandler {

  public ItemFactory () {
    // Default instructor
  }

  public ArrayList newAuction() {
    // holds the list of items for auction and their values
    List<Map> auctionItems = new ArrayList;
    // holds the information of a single item in the auction
    HashMap<String, String> item = new Hashmap();

    // fill the auction with fake items
    // Set the minimum bid by the second input
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

    return auctionItems;
  }

}
