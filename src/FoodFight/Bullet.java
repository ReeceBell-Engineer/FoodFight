package FoodFight;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// The bullet/pie is created on player click and cause damage to Enemy_1.
// Collision block was created by Dennis Lai

public class Bullet extends GameObject {

	private Handler handler;

	public Bullet(int x, int y, ID id, Handler handler, int mx, int my, SpriteSheet ss) {
		super(x, y, id, ss);
		this.setHandler(handler);
		
		// This small algorithm was taken from RealTutsGML java tutorials.
		velX = (mx - x) / 12;
		velY = (my - y) / 12;
		
	}

	public void tick() {
		x += velX;
		y += velY;

		// Collision for this was done by Dennis Lai
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(this);
                }
            }
        }	
	}

	// renders the bullet
	public void render(Graphics g) {
		final Color Brown = new Color(102, 51, 0);
		
		g.setColor(Brown);
		g.fillOval(x, y, 12, 16);
	}

	// collision box
	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
}
