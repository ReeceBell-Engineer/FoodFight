package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class HealthBox extends GameObject {

private BufferedImage health_image;
	
	public HealthBox(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		
		health_image = ss.grabImage(3, 1, 32, 32);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(health_image, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
