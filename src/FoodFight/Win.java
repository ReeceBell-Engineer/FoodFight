package FoodFight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// this is the menu for when a game is won

public class Win extends MouseAdapter {
	
	Game game;
	static String finalTime = GameTimer.finalGT;
	
	public Win(Game game, Handler handler) {
		this.setGame(game);
		
		HUD.ammo = 100;
		HUD.enemies = 26;
		HUD.hp = 100;
	}
	
	public void mousePressed(MouseEvent e) {
//		int mx = e.getX();
//		int my = e.getY();
		
//		if(mouseOver(mx, my, Game.WIDTH/2 - 100,  Game.HEIGHT/2 - 250, 200, 32)) {
//			game.gameState = STATE.Level1;
//			
//		}
//		if(mouseOver(mx, my, Game.WIDTH/2 - 100, Game.HEIGHT/2 - 200, 200, 32)) {
//			game.gameState = STATE.Menu;
//			
//		}
	}

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
		g.drawString("You WIN!!!!!!!", Game.WIDTH/2 - 150, Game.HEIGHT/2 - 300);
		
		
		g.setFont(fnt2);
		g.setColor(Color.red);
		g.drawRect(Game.WIDTH/2 - 100,  Game.HEIGHT/2 - 200, 200, 32);
		g.drawString("New Game", 425, 225);
		
		g.setColor(Color.red);
		g.drawRect(Game.WIDTH/2 - 100, Game.HEIGHT/2 - 150, 200, 32);
		g.drawString("Quit", 470, 275);

		g.drawString("Game Time: " + finalTime , Game.WIDTH/2 - 175, Game.HEIGHT/2);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}	