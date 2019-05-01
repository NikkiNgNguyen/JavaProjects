
public class Trade {
	private String trader;
	private double amount;

	public Trade(String trader, double amount) {
		this.trader = trader;
		this.amount = amount;
	}

	public String toString() {
		return "Trader: " + trader + " $" + amount;
	}

}
