package FoodFight;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// The Block is what makes up the walls of the game
// Sprite contributed by Esther Song

public class Block extends GameObject {
	
	private BufferedImage block_image;
	
	public Block(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		block_image = ss.grabImage(5, 2, 32, 32);
	}

	public void tick() {
		
	}
	
	// renders sprite
	public void render(Graphics g) {
		g.drawImage(block_image, x, y, null); 
	}

	// collision box
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
