
public class Trader implements Observer {
	private Subject auction;
	
	public Trader(Subject auction) {
		this.auction = auction;
		auction.addObserver(this);
	}

	// this is invoked when the state of the auction has changed
	public void update(Object newState) {
		Trade latestTrade = (Trade)newState;
		display(latestTrade);
	}
	
	public void display(Trade latestTrade) {
		System.out.println("The latest trade is " + latestTrade);
	}
}
