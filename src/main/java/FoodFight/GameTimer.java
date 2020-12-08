package FoodFight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

// this is a time that keeps a running clock of the time the game is playing.
// Reece Bell did this.

public class GameTimer implements Runnable {
	
	public static String finalGT = "";
	private volatile static boolean exit = false;
	private static boolean isRunning = false;
	Game game;

	static long startTime = System.currentTimeMillis();
	static int oneHour = (1000 * 60 * 60);

	public void run() {

		isRunning = true;
			
		while(!exit) {
			long now = System.currentTimeMillis();
			long elapsedTime = (now - startTime) - (16 * oneHour);
			DateFormat df = new SimpleDateFormat("mm:ss:SS");
			
			if(isRunning) {
				//System.out.println("Your current game time is " + df.format(elapsedTime));
				finalGT = df.format(elapsedTime);
			}
			finalGT = df.format(elapsedTime);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return;
	
	}
	
	public static void stop() {
		exit = true;
		
		isRunning = false;
		
		long GameTime = System.currentTimeMillis() - startTime;
		long elapsedTime = (GameTime) - (16 * oneHour);
		DateFormat df = new SimpleDateFormat("HH:mm:ss:SS");
		
		if(!isRunning) {
			System.out.println("Your current game is paused");
			System.out.println("Your current game time is " + df.format(elapsedTime));
	
			finalGT = df.format(elapsedTime);
			System.out.println("Your survival game time is " + finalGT);

		}
	}

	public static boolean isRunning() {
		return isRunning;
	}

	public static void setisRunning(boolean isRunning) {
		GameTimer.isRunning = isRunning;
	}
}


