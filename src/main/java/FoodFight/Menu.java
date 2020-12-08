package FoodFight;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// this is the Menu STATE.

public class Menu extends MouseAdapter {

	private Game game;
	
	public Menu(Game game, Handler handler) {
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
		g.drawString("Food Fight !", 365, 100);
		
		g.setFont(fnt2);
		g.setColor(Color.red);
		g.drawRect(400, 150, 200, 32);
		g.drawString("Play", 470, 175);
		
		g.setColor(Color.red);
		g.drawRect(400, 200, 200, 32);
		g.drawString("Help", 470, 225);
		
		g.setColor(Color.red);
		g.drawRect(400, 250, 200, 32);
		g.drawString("Quit", 470, 275);
		
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}	
