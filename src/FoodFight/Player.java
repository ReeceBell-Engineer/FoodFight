package FoodFight;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// this is the player

public class Player extends GameObject {

	private int playerSpeed = 4;
	private float _acc = 1f;
	private float _dcc = 0.5f;
	private KeyInput input;
	Handler handler;
	Game game;
	
	private BufferedImage player_image;
	
	public Player(int x, int y, ID id, KeyInput input, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.game = game;
		this.input = input;
		
		player_image = ss.grabImage(1, 1, 32, 48);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
		collision();
		
		// horizontal
		// keys 0 right
		//keys 1 left
		if(input.keys[0]) velX += _acc;
		else if(input.keys[1]) velX -= _acc;
		else if(!input.keys[0] && !input.keys[1]) {
			if(velX > 0) velX -= _dcc;
			else if(velX < 0) velX += _dcc;
		}

		// Vertical
		// keys 2 up
		//keys 3 down
		if(input.keys[2]) velY -= _acc;
		else if(input.keys[3]) velY += _acc;
		else if(!input.keys[2] && !input.keys[3]) {
			if(velY > 0) velY -= _dcc;
			else if(velY < 0) velY += _dcc;
		}
		
		// game lose condition done by Lauren Tomasi
		if (HUD.hp <= 0) {
			game.gameState = STATE.GameOver;
		}
		
		// speed of player movement
		velX = clamp(velX, playerSpeed, - playerSpeed);
		velY = clamp(velY, playerSpeed, - playerSpeed);
	}
	
	private float clamp(float value, float max, float min) {
		if(value >= max) value = max;
		else if (value <= min) value = min;
		
		return value;
	}
	
	// the collision is very glitchy and can cause some issues with going through walls and enemies moving off the map
	// creating unwinnable situations.
	private synchronized void collision() {
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
					
					System.out.println("You hit a wall!");
				}
			}

			if(tempObject.getId() == ID.AmmoCrate) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.ammo += 10;
					handler.removeObject(tempObject);
					System.out.println("You got some ammo!");
				}
			}
			
			if(tempObject.getId() == ID.Enemy_1) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.hp--;
				}
			}
			
			if(tempObject.getId() == ID.HealthBox) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
					if(HUD.hp < 100 ) {
						
						if (HUD.hp > 90) {
							
							int hpPlus = 100 - HUD.hp;
							
							HUD.hp += hpPlus;
						} else {
							
							HUD.hp += 10;
						}
						handler.removeObject(tempObject);
						System.out.println("You got some health back!");
							
					} 
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(player_image, x, y, null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x + 2, y + 2, 28, 44);
	}
}
