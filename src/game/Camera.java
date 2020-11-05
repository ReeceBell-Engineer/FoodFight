package game;

public class Camera {

	private static float x;
	private float y;
	
	public Camera(float x, float y) {
		Camera.x = x;
		this.y = y;
		
	}
	
	public void tick(GameObject object) {
		
		x += ((object.getX()- x) - 1000/2) * .05f;
		y += ((object.getY()- y) - 563/2) * .05f;
		
		if(x <= 0) x = 0;
		if(x >= 924) x = 924;
		if(y <= 0) y = 0;
		if(y >= 618) y = 618;
		

	}

	public static float getX() {
		return Camera.x;
	}

	public void setX(float x) {
		Camera.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	
}
