package game;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class GameTimer implements Runnable {
	

	public void run() {
		
		long startTime = System.currentTimeMillis();
		int oneHour = (1000 * 60 * 60);
		
		while(true) {
			long now = System.currentTimeMillis();
			long elapsedTime = (now - startTime) - (16 * oneHour);
			DateFormat df = new SimpleDateFormat("HH:mm:ss");

			System.out.println("Your current game time is " + df.format(elapsedTime));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


