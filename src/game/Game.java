package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;

	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	private Camera camera;
	static BufferedImage level = null;
	
	
	public int ammo = 100;
	public int hp = 100;
	// add number of enemies
	public int enemies = 28;
	public Menu menu;
	/////////////////////////////////////////////////
	
	public STATE gameState = STATE.Menu;
	////////////////////////////////////////////////////
	
	public Game() {
		new Window(1000, 563, "Zombie Game", this);
		

		start();
		
		camera = new Camera(0,0);
		handler = new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler, camera, menu, this));
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/test_level.png");
		
		
		
		if(gameState == STATE.Game) {
			loadLevel(level);
			
		} else {
			gameState = STATE.Menu;
			menu = new Menu(this, handler);
		}
		
	}

	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		isRunning = false;
		try {
			thread.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run () {
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
			}
		}
		stop();
		
	}
	
	public void tick() {
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) {
				camera.tick(handler.object.get(i));
			}
		}
		
		handler.tick();
		
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		///////////////////////////////////////////
		
		
		if(gameState == STATE.Game) {
			
		
			g.setColor(Color.red);
			g.fillRect(0,0,1000,563);
			
			g2d.translate(-camera.getX(), -camera.getY());
			g2d.translate(camera.getX(), camera.getY());
			
			
			g.setColor(Color.gray);
			g.fillRect(5, 5, 200, 32);
			g.setColor(Color.green);
			g.fillRect(5, 5, hp*2, 32);
			g.setColor(Color.black);
			g.drawRect(5, 5, 200, 32);
			
			
			g.setColor(Color.white);
			g.drawString("Ammo: " + ammo, 4, 50);
			
			g.setColor(Color.white);
			g.drawString("Enemies: " + enemies, 4, 60);
			
			g.setColor(Color.white);
			g.drawRect(875, 30, 100, 32);
			g.drawString("Back", 920, 45);
			
			
			
			
		} else if (gameState == STATE.Menu){
			g.setColor(Color.black);
		    g.fillRect(0,0,1000,563);
			
			g.setColor(Color.red);
			g.fillRect(100, 100, 100, 63);
			Menu.render(g);
		}
		
		g.dispose();
		bs.show();
		
		////////////////////////////////////////////
		handler.render(g);
	}
	
	//loading level
	
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < w; xx++) {
			for(int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx,  yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				@SuppressWarnings("unused")
				int pink = (pixel) & 0xff;
				
				if(red == 255)
					handler.addObject(new Block( xx*32, yy*32, ID.Block));
				
				if(blue == 255 && green == 0)
					handler.addObject(new Player( xx*32, yy*32, ID.Player, handler, this));
				
				if(green == 255 && blue == 0)
					handler.addObject(new Enemy_1( xx*32, yy*32, ID.Enemy_1, handler, this));
				
				if(green == 255 && blue == 255 && red == 0)
					handler.addObject(new AmmoCrate( xx*32, yy*32, ID.AmmoCrate));
				
				if(green == 0 && blue == 50 && red == 200)
					handler.addObject(new HealthBox( xx*32, yy*32, ID.HealthBox));
				
			
			}
		
		
		
		
		}
	}
	
	public static void main(String args[]) {
		new Game();
	}
}	
