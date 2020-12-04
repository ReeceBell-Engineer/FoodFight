package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD{
	public static int ammo = 100;
	public static int enemies = 28;
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
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Ammo: " + ammo, 4, 60);
		
		
		// TODO enemies left. hard coded. would be nice to dynamically change based on enemies objects actually loaded
		g.setColor(Color.white);
		g.drawString("Enemies: " + enemies, 4, 90);
		
		
		//back - pause button
		g.setFont(fnt);
		g.setColor(Color.white);
		//g.drawRect(875, 30, 100, 32);
		g.drawRect(Game. WIDTH - 120 , Game.HEIGHT - 775, 100, 32);
		g.drawString("Back", 920, 45);
		
		// GameTimer
		g.setFont(fnt2);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("" + GameTimer.finalGT , Game.WIDTH/2 - 75, Game.HEIGHT/2 - 340);
		
		
	}

// TODO need to make a text box that displays the current game time elapsed. updated to the millisec.

}
