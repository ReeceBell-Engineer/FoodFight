package FoodFight;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

// This is what loads the images from the res folder. 
// This includes loading the map that was created using paint.net and the sprite sheet

public class BufferedImageLoader {
	
	private BufferedImage image;
	
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return image;
	}
	
}
