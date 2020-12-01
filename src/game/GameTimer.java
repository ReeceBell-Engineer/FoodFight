package game;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class GameTimer implements Runnable {
	private volatile static boolean exit = false;
	private static boolean isRunning = false;
	
	
	static long startTime = System.currentTimeMillis();
	static int oneHour = (1000 * 60 * 60);

	public void run() {

		
			
		while(!exit) {
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

	
		return;
	
	}

	
	public static void stop() {
		exit = true;
		

		
		long GameTime = System.currentTimeMillis() - startTime;
		long elapsedTime = (GameTime) - (16 * oneHour);
		DateFormat df = new SimpleDateFormat("HH:mm:ss:SS");
		
		System.out.println("Your current game is paused");
		System.out.println("Your current game time is " + df.format(elapsedTime));

		

		
	}


	public static boolean isRunning() {
		return isRunning;
	}


	public static void setisRunning(boolean isRunning) {
		GameTimer.isRunning = isRunning;
	}



}


