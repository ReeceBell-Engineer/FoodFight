package FoodFight;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// Player key input is handled here. Method was learned from RealTutsGML
// this is the second way that player movement was made and this seems to
// be much better.

public class KeyInput extends KeyAdapter {
	
	public boolean keys[] = new boolean[4];
	
	public void keyPressed(KeyEvent e) {	
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D) { keys[0] = true; }
		if(key == KeyEvent.VK_A) { keys[1] = true; }
		if(key == KeyEvent.VK_W) { keys[2] = true; }
		if(key == KeyEvent.VK_S) { keys[3] = true; }
		
	}
	
	public void keyReleased(KeyEvent e) {
	
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D) { keys[0] = false; }
		if(key == KeyEvent.VK_A) { keys[1] = false; }
		if(key == KeyEvent.VK_W) { keys[2] = false; }
		if(key == KeyEvent.VK_S) { keys[3] = false; }
		
	}
}
