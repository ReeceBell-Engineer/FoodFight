package game;

import java.awt.Graphics;
import java.awt.event.MouseEvent;


public class Level1 {

	private Game game;
	public Level1 (Game game, Handler handler) {
		this.game = game;
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 875, 30, 100, 32)) {
			game.gameState = STATE.Menu;
			

		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if(my > y && my < y + height) {
			
				System.out.println("over");
				return true;
			}else return false;
		}else return false;
	}

	public static void render(Graphics g) {
		
		

		
//		g.setColor(Color.red);
//		g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
//
//		g.setColor(Color.gray);
//		g.fillRect(5, 5, 200, 32);
//		g.setColor(Color.green);
//		g.fillRect(5, 5, hp*2, 32);
//		g.setColor(Color.black);
//		g.drawRect(5, 5, 200, 32);
//		
//		
//		g.setColor(Color.white);
//		g.drawString("Ammo: " + ammo, 4, 50);
//		
//		g.setColor(Color.white);
//		g.drawString("Enemies: " + enemies, 4, 60);
//		
//		g.setColor(Color.white);
//		g.drawRect(875, 30, 100, 32);
//		g.drawString("Back", 920, 45);
		
	}

}
