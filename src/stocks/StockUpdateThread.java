package stocks;

import java.util.Random;

public class StockUpdateThread implements Runnable {

	private StockServer server;
	private Random random;

	public StockUpdateThread(StockServer server) {
		this.server = server;
		this.random = new Random();
	}

	public void run() {
		StockServer.Stock[] allStocks = StockServer.Stock.values();
		
		for (int i = 0; i < 10; i++) {
			try {
				for (int j = 0; j < allStocks.length; j++) {

					int newValue = random.nextInt(401) + 100;

					server.UpdateStock(allStocks[j], newValue);
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}