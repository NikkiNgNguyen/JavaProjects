
public class StockMarket {
 public static void main(String[] args) {
  Stock MSFT = new Stock();
  Stock GOOG = new Stock();
  
  // create some bidders
  Trader Nikki = new Trader(MSFT);
  Trader Audrey = new Trader(MSFT);
  Trader Mimi = new Trader(GOOG);
  Trader Tom = new Trader(GOOG);

  // submit some bids to the auction 
  MSFT.submitTrade(new Trade("Nikki",150));
  MSFT.submitTrade(new Trade("Audrey",160));
  GOOG.submitTrade(new Trade("Mimi",165));
  GOOG.submitTrade(new Trade("Tom",170));
  MSFT.submitTrade(new Trade("Nikki", 175));

  // The bidding has gone too high for Amy.
  MSFT.removeObserver(Audrey);
  System.out.println("Audrey is out of the game");
  
  // few more bids
  GOOG.submitTrade(new Trade("Mimi",180));
  GOOG.submitTrade(new Trade("Tom",185));
  
  // now too high for Julie
  GOOG.removeObserver(Mimi);
  System.out.println("Mimi is out of the game");


  // this doesn't make sense, but just to show that
  // there is now only one observer (Pat)
  MSFT.submitTrade(new Trade("Nikki",190));
  GOOG.submitTrade(new Trade("Tom",190));

 }
}
