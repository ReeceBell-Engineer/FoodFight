package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy_1 extends GameObject {

	private Handler handler;
	private Game game;
	
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	public Enemy_1(int x, int y, ID id, Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
	}

	public void tick() {
		x += velX;
		y += velY;
		choose = r.nextInt(30);
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) {
				if(getBoundsBig().intersects(tempObject.getBounds())) {
					x += (velX) * -3;
					y += (velY) * -3;
					
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
			game.enemies--;
		}
		
		
	}

	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x,  y,  32, 32);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.green);
		g2d.draw(getBoundsBig());
			
	}


	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
		
	}
	public Rectangle getBoundsBig() {
		return new Rectangle(x-8, y-8, 48, 48);
	}

}
