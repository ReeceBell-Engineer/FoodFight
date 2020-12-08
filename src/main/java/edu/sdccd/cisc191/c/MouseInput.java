package edu.sdccd.cisc191.c;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	
	private Handler handler;
	private Camera camera;
	private Game game;
	private Menu menu;
	
	
	public MouseInput (Handler handler, Camera camera, Menu menu, Game game) {
		this.handler = handler;
		this.camera = camera;
		this.setMenu(menu);
		this.game = game;
		
	}
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if(my > y && my < y + height) {

				return true;
			}else return false;
		}else return false;
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player && game.ammo >= 1) {
				handler.addObject(new Bullet(tempObject.getX() + 16, tempObject.getY() + 24, ID.Bullet, handler, mx, my));
				game.ammo--;
			}
		}
		
		
		if (game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 400, 150, 200, 32)) {
				game.gameState = STATE.Game;
			}
	
			
			if(mouseOver(mx, my, 400, 250, 200, 32)) {
				System.exit(0);
			}
		}
		
		if (game.gameState == STATE.Game) {
			if(mouseOver(mx, my, 875, 30, 100, 32)) {
				game.gameState = STATE.Menu;
			}

		}
		
		
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
