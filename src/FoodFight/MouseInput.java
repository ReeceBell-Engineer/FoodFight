package FoodFight;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// this handles all mouse input from the player

public class MouseInput extends MouseAdapter {

	private Handler handler;
	private Camera cam;
	private Game game;
	
	Help help;
	 Menu menu;
	Level1 level;
	
	private SpriteSheet ss;
	private GameObject tempPlayer = null;
	
	Thread gameTimerThread = new Thread(new GameTimer());
	
	public MouseInput (Handler handler, Camera cam, Menu menu,Help help, Level1 level, Pause pause, Game game, SpriteSheet ss) {
		this.handler = handler;
		this.cam = cam;
		this.menu = menu;
		this.help = help;
		this.level = level;
		this.game = game;
		this.ss = ss;
		
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
		
		if (game.gameState == STATE.Level1) {
		
			if(tempPlayer != null) {
				
				if (HUD.ammo > 0) {
				GameObject tempBullet = handler.addObject(new Bullet(tempPlayer.x + 16, tempPlayer.y + 16, ID.Bullet, handler, my, my, ss));
				
				float angle = (float) Math.atan2(my - tempPlayer.y - 16 + cam.getY(), mx - tempPlayer.x - 16 + cam.getX());
				int bulletVel = 10;
				
				// bullet velocity was handled a couple different ways. This turned out to be the best. 
				
				tempBullet.velX = (float) ((bulletVel) * Math.cos(angle));
				tempBullet.velY = (float) ((bulletVel) * Math.sin(angle));
				
				HUD.ammo --;
				System.out.println("You have fired a pie!!!!");
				
				}

			} else findPlayer();
			
		}
		if (game.gameState == STATE.Menu) {
			
			// new game button
			// does not create a new game. Was able to open a new instance of the game but it would not stop the current running game.
			// 
			if(mouseOver(mx, my, 400, 150, 200, 32)) {
				
				game.gameState = STATE.Level1;
				
				if( gameTimerThread.isAlive()) {
					System.out.println("gameTimerThread is running after Level1 starts");
				}else gameTimerThread.start();
				
				System.out.println("New game pressed from main menu");
				
				// print current STATE
				System.out.println("gameState = Level1");
			}
			
			if(mouseOver(mx, my, 400, 200, 200, 32)) {
				
				game.gameState = STATE.Help;
	
				System.out.println("Help pressed from main menu");
				
				// print current STATE
				System.out.println("gameState = Help");
			} 
	
			// exit game button
			if(mouseOver(mx, my, 400, 250, 200, 32)) {
			
				System.out.println("exiting game from main menu");
				
				System.exit(0);
				
			}
		}
		
		if (game.gameState == STATE.Help) {
			
			// Help button
			if(mouseOver(mx, my, 400, 450, 200, 32)) {
				
				game.gameState = STATE.Menu;

				System.out.println("back to main menu from help");
				
				// print current STATE
				System.out.println("gameState = Menu");
			} 
		}
		
		if (game.gameState == STATE.Level1) {
			
			//g.drawRect(875, 30, 100, 32);
			
			if(mouseOver(mx, my, Game. WIDTH - 120 , Game.HEIGHT - 775, 100, 32)) {
				game.gameState = STATE.Pause;

				System.out.println("Pause Button pressed from Level1");
				
				//Thread gameTimerThread = new Thread(new GameTimer()); // GameTimer thread
				//gameTimerThread.start(); // gameTimerThread started
				//GameTimer.stop();
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
		
		else if (game.gameState == STATE.GameOver) {
			
			HUD.hp = 100;
			
			if(mouseOver(mx, my, Game.WIDTH/2 - 100,  Game.HEIGHT/2 - 250, 200, 32)) {
				game.gameState = STATE.Level1;
				
			}
			
			if(mouseOver(mx, my, Game.WIDTH/2 - 100, Game.HEIGHT/2 - 200, 200, 32)) {
				game.gameState = STATE.Menu;
				
			}
		}
		
		else if (game.gameState == STATE.Win) {
			
			HUD.hp = 100;
			
			if(mouseOver(mx, my, Game.WIDTH/2 - 100,  Game.HEIGHT/2 - 200, 200, 32)) {
				game.gameState = STATE.Level1;

			}
			
			if(mouseOver(mx, my, Game.WIDTH/2 - 100, Game.HEIGHT/2 - 150, 200, 32)) {
				game.gameState = STATE.Menu;

			}		
		}
	}
//	public Menu getMenu() {
//		return menu;
//	}
//	public void setMenu(Menu menu) {
//		this.menu = menu;
//	}
//	public Level1 getLevel() {
//		return level;
//	}
//	public void setLevel(Level1 level) {
//		this.level = level;
//	}
	
}
