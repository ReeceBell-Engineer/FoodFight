package FoodFight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// this is a help menu that gives player instructions

public class Help extends MouseAdapter {

	private Game game;
	
	public Help(Game game, Handler handler) {
		this.setGame(game);
	}
	
//	public void mousePressed(MouseEvent e) {
//		int mx = e.getX();
//		int my = e.getY();
//
//		if(mouseOver(mx, my, 400, 150, 200, 32)) {
//			game.gameState = STATE.Level1;
//		}
//	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
//	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
//		if (mx > x && mx < x + width) {
//			if(my > y && my < y + height) {
//			
//				System.out.println("over");
//				return true;
//			}else return false;
//		}else return false;
//	}
	
	public void tick() {
		
	}
	
	public static void render(Graphics g) {
		
		// menu background
		g.setColor(Color.black);
		g.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
		
		
		// menu
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Controls", 400, 100);
		
		
		g.setFont(fnt2);
		g.setColor(Color.red);
		g.drawString("Press W to move up", 370, 175);
		
		g.setColor(Color.red);
		g.drawString("Press A to move left", 370, 225);
		
		g.setColor(Color.red);
		g.drawString("Press D to move right", 370, 275);
		
		g.setColor(Color.red);
		g.drawString("Press S to move down", 370, 325);
		
		g.setColor(Color.red);
		g.drawString("Use left or right mouse button to fire food from your spork", 100, 375);
		
		g.setColor(Color.red);
		g.drawRect(400, 450, 200, 32);
		g.drawString("Back", 470, 475);
		
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}	