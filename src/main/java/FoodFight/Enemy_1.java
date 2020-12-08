package FoodFight;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

// This is the one and only enemy that we created

public class Enemy_1 extends GameObject {

	private Handler handler;
	private Game game;
	private BufferedImage enemy_image;
	
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	public Enemy_1(int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		this.setGame(game);
		
		enemy_image = ss.grabImage(5, 1, 32, 32);
	}

	public void tick() {
		
		x += velX;
		y += velY;
		// the randomness of the enemy movement was taken from RealTustGML tutorials
		choose = r.nextInt(30);
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
					x += (velX) * -2;
					y += (velY) * -2;
					
					velX *= -1;
					velY *= -1;
					
				}else if(choose == 0) {
					
					velX = (r.nextInt(4 - -4) + -4);
					velY = (r.nextInt(4 - -4) + -4);
				}
			}

			if(tempObject.getId() == ID.Bullet) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
					hp -= 50;
					handler.removeObject(tempObject);	
					
				}
			}	
		}
		
		if(hp <= 0) {
			
			handler.removeObject(this);
			HUD.enemies--;
			System.out.println("you have killed a bad guy!!!");
		}
		if(HUD.enemies <= 0) {
	
			System.out.println("you have killed all the bad guys!!!");
			game.gameState = STATE.Win;
			HUD.enemies = 28;

		}
	}

	public void render(Graphics g) {
		
		g.drawImage(enemy_image, x, y, null);
		
		//Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.green);
		//g2d.draw(getBoundsBig());	
	}

	// collision box
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

//	public Rectangle getBoundsBig() {
//		return new Rectangle(x-8, y-8, 48, 48);
//	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
