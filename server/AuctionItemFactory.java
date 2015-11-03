/*
  Author - James Byrne

  Description
  This class holds the information for all the different items that are used in the auction

*/

import java.io.*;

public class AuctionItemFactory {

  private int itemNumber = 0;

  public AuctionItems () {
    // Default instructor
  }

  // Just for testing
  public void setItemNumber(int itemNumber) {
    this.itemNumber = itemNumber
  }

  public void getNewItem () {
    // return a new item
    return(getItem());
  }

  // returns the next item for the auction
  private HashMap getItem () {
    switch (itemNumber) {
      case 0 :
        Map item = new HashMap();
        item.put("description", "description of item 0\n");
        item.put("reserve", "0");
        item.put("currentBid", "0");
        itemNumber++;
        break;

      case 1 :
        Map item = new HashMap();
        item.put("description", "description of item 1\n");
        item.put("reserve", "0");
        item.put("currentBid", "0");
        itemNumber++;
        break;

      case 2 :
        Map item = new HashMap();
        item.put("description", "description of item 2\n");
        item.put("reserve", "0");
        item.put("currentBid", "0");
        itemNumber++;
        break;

      default :
        return null;
        break;
    }
    return item;
  }
}
