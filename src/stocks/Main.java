package stocks;

public class Main {

	public static void main(String[] args){
		
		StockServer stockServer = new StockServer();
		
        StockFollowers tamiTan = new StockFollowers("Tami Tan", stockServer);
        StockFollowers timSaroli = new StockFollowers("Tim Saroli", stockServer);
        StockFollowers simaDides = new StockFollowers("Sima Dides", stockServer); // תיקנתי כאן ל-Dides שיהיה כמו בשאלה
        
        StockUpdateThread updater = new StockUpdateThread(stockServer);
        
        Thread tamiThread = new Thread(tamiTan);
        Thread timThread = new Thread(timSaroli);
        Thread simaThread = new Thread(simaDides);
        Thread updaterThread = new Thread(updater);
        
        tamiThread.start();
        timThread.start();
        simaThread.start();
        updaterThread.start();
	}
}