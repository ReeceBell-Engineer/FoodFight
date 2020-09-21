package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	
	public Bullet(int x, int y, ID id, Handler handler, int mx, int my) {
		super(x, y, id);
		
		
		//velX = (mx - x) / 12;
		//velY = (my - y) / 12;
		
		velX = x / 12;
		velY = y / 12;
		
		
	}


	public void tick() {
		
		
	}
	

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

}
