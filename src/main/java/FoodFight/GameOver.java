package FoodFight;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// This displays the STATE for a winning condition. 

public class GameOver extends MouseAdapter {

	Game game;
	static String finalTime = GameTimer.finalGT;
	
	public GameOver(Game game, Handler handler) {
		this.setGame(game);

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
		g.setColor(Color.gray);
		g.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
		
		// menu
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Game Over", Game.WIDTH/2 - 125, Game.HEIGHT/2 - 300);
		
		
		g.setFont(fnt2);
		g.setColor(Color.red);
		g.drawRect(Game.WIDTH/2 - 100,  Game.HEIGHT/2 - 250, 200, 32);
		g.drawString("New Game", 425, 175);
		
		g.setColor(Color.red);
		g.drawRect(Game.WIDTH/2 - 100, Game.HEIGHT/2 - 200, 200, 32);
		g.drawString("Quit", 470, 225);

		g.drawString("" + finalTime , Game.WIDTH/2 - 75, Game.HEIGHT/2);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}	