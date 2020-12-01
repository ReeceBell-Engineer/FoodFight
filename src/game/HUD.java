package game;

import java.awt.Color;
import java.awt.Graphics;

public class HUD{
	public static int ammo = 100;
	public static int enemies = 28;
	public static int hp = 100;

	
	public static void render(Graphics g) {
		

		// HP bar
		g.setColor(Color.gray);
		g.fillRect(5, 5, 200, 32);
		g.setColor(Color.green);
		g.fillRect(5, 5, hp*2, 32);
		g.setColor(Color.black);
		g.drawRect(5, 5, 200, 32);
		
		
		//Ammo count
		g.setColor(Color.white);
		g.drawString("Ammo: " + ammo, 4, 50);
		
		
		// TODO enemies left. hard coded. would be nice to dynamically change based on enemies objects actually loaded
		g.setColor(Color.white);
		g.drawString("Enemies: " + enemies, 4, 60);
		
		
		//back - pause button
		g.setColor(Color.white);
		//g.drawRect(875, 30, 100, 32);
		g.drawRect(Game. WIDTH - 120 , Game.HEIGHT - 775, 100, 32);
		g.drawString("Back", 920, 45);
		
		
	}

// TODO need to make a text box that displays the current game time elapsed. updated to the millisec.

}
