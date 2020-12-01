package game;

public class Camera {

	private float x;
	private float y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
		
	}
	
	public void tick(GameObject object) {
		
		x += ((object.getX()- x) - 1000/2) * .05f;
		y += ((object.getY()- y) - 800/2) * .05f;
		
		if(x <= 0) x = 0;
		if(x >= 924) x = 924;
		if(y <= 0) y = 0;
		if(y >= 391) y = 391;
		

	}

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
}
