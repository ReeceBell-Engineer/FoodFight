package game;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class MouseInput extends MouseAdapter {

	
	private Handler handler;
	private Camera cam;
	private Game game;
	private Menu menu;
	private Level1 level;
	private GameObject tempPlayer = null;
	
	
	Thread gameTimerThread = new Thread(new GameTimer());
	
	
	public MouseInput (Handler handler, Camera cam, Menu menu, Level1 level, Pause pause, Game game) {
		this.handler = handler;
		this.cam = cam;
		this.setMenu(menu);
		this.setLevel(level);
		this.game = game;
		
	}
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if(my > y && my < y + height) {

				return true;
			}else return false;
		}else return false;
	}
	
	public void findPlayer() {
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) {
				tempPlayer = handler.object.get(i);
				break;
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		
		if(tempPlayer != null) {
			
			if (HUD.ammo > 0) {
			GameObject tempBullet = handler.addObject(new Bullet(tempPlayer.x + 16, tempPlayer.y + 16, ID.Bullet, handler, my, my));
			
			float angle = (float) Math.atan2(my - tempPlayer.y - 16 + cam.getY(), mx - tempPlayer.x - 16 + cam.getX());
			int bulletVel = 20;
			
			tempBullet.velX = (float) ((bulletVel) * Math.cos(angle));
			tempBullet.velY = (float) ((bulletVel) * Math.sin(angle));
			
			HUD.ammo --;
			}
			
		
			
			
		} else findPlayer();
		
		
		if (game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 400, 150, 200, 32)) {
				game.gameState = STATE.Level1;
				
				if( gameTimerThread.isAlive()) {
					System.out.println("gameTimerThread is running");
				}else gameTimerThread.start();
				//gameTimerThread.notify();
				 // GameTimer thread
				//gameTimerThread.start(); // gameTimerThread started
			} 
	
			
			if(mouseOver(mx, my, 400, 250, 200, 32)) {
				System.exit(0);
			}
		}
		
		if (game.gameState == STATE.Level1) {

			//g.drawRect(875, 30, 100, 32);
			
			if(mouseOver(mx, my, Game. WIDTH - 120 , Game.HEIGHT - 775, 100, 32)) {
				game.gameState = STATE.Pause;
				
				//Thread gameTimerThread = new Thread(new GameTimer()); // GameTimer thread
				//gameTimerThread.start(); // gameTimerThread started
				GameTimer.stop();

			}

		}
		if (game.gameState == STATE.Pause) {
			if(mouseOver(mx, my, Game.WIDTH/2 - 100,  Game.HEIGHT/2 - 250, 200, 32)) {
				game.gameState = STATE.Level1;
				
			}
			if(mouseOver(mx, my, Game.WIDTH/2 - 100, Game.HEIGHT/2 - 200, 200, 32)) {
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
	public Level1 getLevel() {
		return level;
	}
	public void setLevel(Level1 level) {
		this.level = level;
	}
	
}
