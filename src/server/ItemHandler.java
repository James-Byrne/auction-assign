/*
  Author - James Byrne

  Description
  - Gets an instance of ItemFactory
*/

import java.util.*;

public class ItemHandler extends Thread {

  ItemFactory itemFactory;
  private HashMap<String, String> item;
  private List<Map> auctionItems;
  int  currentItem = 0;

  public ItemHandler () {
    // Default constructor
    this.itemFactory = new ItemFactory();
    this.auctionItems = itemFactory.newAuction();
  }

  // Set the bid of a new item
  public String bid (String newBid){

    if(Integer.parseInt(newBid) > (Integer)auctionItems.get(currentItem).get("bid")){
      auctionItems.get(currentItem).put("bid", Integer.parseInt(newBid));
      return "Bid Successful! Current bid " + newBid;
    } else {
      return "Bid Unsucessful. Current bid is "
      + auctionItems.get(currentItem).get("bid").toString();
    }
  }

  // Get the name of the current item
  public String getCurrentItem() {
    return auctionItems.get(currentItem).get("name").toString();
  }

  // Get the top bid on the current item
  public String getCurrentBid() {
    return auctionItems.get(currentItem).get("bid").toString();
  }

  // Move on to the next item in the auction
  // If there is no items left end the auction
  public void nextItem() {
    if(currentItem == auctionItems.size()) {
      // TODO End the Auction when we run out of items
      // auctionOver();
    } else {
      currentItem += 1;
    }
  }

  // TODO : Evaluate this, I dont think its needed for this assignment
  // remove an item
  public void removeItem(Integer index) {
    auctionItems.remove(index);
    if(currentItem == index) {
      nextItem();
    }
  }

  // TODO : Evaluate this, I dont think its needed for this assignment
  // return the list of all items
  public List<Map> listItems(){
    return auctionItems;
  }
}
