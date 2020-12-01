package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	
	
	private float _acc = 1f;
	private float _dcc = 0.5f;
	private KeyInput input;
	Handler handler;
	Game game;
	
	public Player(int x, int y, ID id, KeyInput input, Handler handler, Game game) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler = handler;
		this.game = game;
		this.input = input;
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
		
		velX = clamp(velX, 6, -6);
		velY = clamp(velY, 6, -6);
	}
	
	private float clamp(float value, float max, float min) {
		if(value >= max) value = max;
		else if (value <= min) value = min;
		
		return value;
		
	}
	

	private synchronized void collision() {
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			
			if(tempObject.getId() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			


			
			if(tempObject.getId() == ID.AmmoCrate) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.ammo += 10;
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ID.Enemy_1) {
				if(getBounds().intersects(tempObject.getBounds())) {

					HUD.hp--;
				}
			}
			
			if(tempObject.getId() == ID.HealthBox) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
					if(HUD.hp < 100) {
						
						for(int z = 0; z < 5; z++) {
							
							HUD.hp += z;
						}
						handler.removeObject(tempObject);
							
					}
				}
			}
		}
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 32, 32);
	}


}
