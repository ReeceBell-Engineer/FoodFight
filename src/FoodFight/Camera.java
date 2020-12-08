package FoodFight;

// This is the camera that changes the view of the game dependent on what it is assigned to.

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
		if(x >= 1055) x = 1055;
		if(y <= 0) y = 0;
		if(y >= 1288) y = 1288;	

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
