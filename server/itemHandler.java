/*
  Author - James Byrne

  Description
  - Gets an instance of ItemFactory
*/

public class ItemHandler extends Thread {

  ItemFactory itemFactory;
  private Hashmap<String, String> item;
  private List<Map> auctionItems;
  String currentItem = 0;

  public ItemHandler () {
    // Default constructor
    this.itemFactory = new ItemFactory();
    this.auctionItems = itemFactory.newAuction();
  }

  // Set the bid of a new item
  public String bid (String newBid){
    if(Integer.parseInt(newBid) > auctionItems.get(currentItem).get('bid')) {
      auctionItems.get(currentItem).get('bid') = newBid;
      return 'Bid Successful! Current bid ' + newBid;
    } else {
      return 'Bid Unsucessful. Current bid is '
      + auctionItems.get(currentItem).get('bid');
    }
  }

  // Get the name of the current item
  public String getCurrentItem() {
    return auctionItems.get(currentItem).get('name');
  }

  // Get the top bid on the current item
  public String getCurrentBid() {
    return auctionItems.get(currentItem).get('bid');
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
  public ArrayList listItems(){
    return auctionItems;
  }


}
