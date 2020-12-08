package FoodFight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

// this is what displays the game info for the player

public class HUD{
	public static int ammo = 100;
	public static int enemies = 26;
	public static int hp = 100;
	
	GameTimer gt;

	public static void render(Graphics g) {
		
		Font fnt = new Font("arial", 1, 20);
		Font fnt2 = new Font("arial", 1, 30);
		
		// HP bar
		g.setColor(Color.gray);
		g.fillRect(5, 5, 200, 32);
		g.setColor(Color.green);
		g.fillRect(5, 5, hp*2, 32);
		g.setColor(Color.black);
		g.drawRect(5, 5, 200, 32);
		
		//Ammo count
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH/2 - 495, Game.HEIGHT/2 - 360, 130, 60);
		g.setFont(fnt);
		g.setColor(Color.yellow);
		g.drawString("Ammo: " + ammo, 10, 60);
		
		// TODO enemies left. hard coded. would be nice to dynamically change based on enemies objects actually loaded
		g.setColor(Color.orange);
		g.drawString("Enemies: " + enemies, 10, 90);
		
		//back - pause button
		g.setColor(Color.blue);
		//g.drawRect(875, 30, 100, 32);
		g.fillRect(Game. WIDTH - 120 , Game.HEIGHT - 775, 100, 32);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Back", 910, 45);
		
		// GameTimer
		g.setColor(Color.blue);
		g.fillRect(Game.WIDTH/2 - 125, Game.HEIGHT/2 - 365, 200, 30);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("" + GameTimer.finalGT , Game.WIDTH/2 - 75, Game.HEIGHT/2 - 340);

	}
}
