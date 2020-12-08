package FoodFight;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// ammo crate that gives += 10 ammo to player
// Sprite sheet contributed by Esther Song

public class AmmoCrate extends GameObject {
	
	private BufferedImage crate_image;

	public AmmoCrate(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		crate_image = ss.grabImage(6, 2, 32, 32);
	}

	public void tick() {
		
	}
	
	// renders sprite
	public void render(Graphics g) {
		g.drawImage(crate_image, x, y, null);
	}

	// collision box
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
