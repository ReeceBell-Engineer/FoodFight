package FoodFight;
import java.awt.Graphics;
import java.util.LinkedList;

// this handles the adding and removal of objects
// method learned from RealTutGML tutorials

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public synchronized void tick() {
		for(int i = 0; i < object.size(); i++) {
			object.get(i).tick();
	
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			object.get(i).render(g);
	
		}
	}
	
	public GameObject addObject(GameObject tempObject) {
		object.add(tempObject);
		return tempObject;
	}
	
	public GameObject removeObject(GameObject tempObject) {
		object.remove(tempObject);
		return tempObject;
	}
}
