package game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;

	public static int WIDTH = 1000;
	public static int HEIGHT = 800;
	public String title = "Food Fight";
	
	Thread thread;
	boolean isRunning = false;
	private BufferedImage levelImage = null;
	// instances
	private Handler handler;
	private KeyInput input;
	private Pause pause;
	private Camera cam;
	
	
	public Menu menu;
	public Level1 level;
	public HUD hud;
	
	
	
	
	/////////////////////////////////////////////////
	
	public STATE gameState = STATE.Menu;
	////////////////////////////////////////////////////

	public boolean isPaused = false;
	
	public Game() {
		
		new Window(WIDTH, HEIGHT, title, this);
		start();
	
		init();
		
	}
	
	private void init() {
		

		handler = new Handler();
		input = new KeyInput();
		cam = new Camera(0,0);
		menu = new Menu(this, handler);

		this.addKeyListener(input);

		this.addMouseListener(new MouseInput(handler, cam, menu, level, pause, this));
		

		BufferedImageLoader loader = new BufferedImageLoader();
		levelImage = loader.loadImage("/FoodFight.png");
		
		loadLevel(levelImage);
		
		
		
		//TODO figure out a way to load the level on new game. Not working
		
		// if (gameState == STATE.Level1) {
		//  	loadLevel(level);
		//}
		
		//if(gameState == STATE.Level1) {
			//loadLevel(level);
		//}
		
		
		// was trying to work out a way to pause the game timer and resume
//		if (gameState == STATE.Pause) {
//			try {
//				thread.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (gameState == STATE.Level1) {
//				thread.notify();
//			}
//				
//		}
	}

	private synchronized void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
		
	}
	
	synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("stack trace");
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
			while (delta >= 1) {
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
				cam.tick(handler.object.get(i));
			}
		}

		
		handler.tick();
		
// checking game state for debugging purposes
//		if(gameState == STATE.Menu) System.out.println("Game STATE = Menu");
//		else if(gameState == STATE.Level1) System.out.println("Game STATE = Level1");
//		else if(gameState == STATE.Pause) System.out.println("Game STATE = Pause");
//		else if(gameState == STATE.GameOver) System.out.println("Game STATE = GameOver");
	}
	


	
	public synchronized void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		///////////////////////////////////////////

		
		if(gameState == STATE.Menu) {
			
			Menu.render(g);
			
			g.dispose();
			
		}
		else if(gameState == STATE.Level1) {

			g.setColor(Color.red);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			HUD.render(g);
	
			
		}
		else if (gameState == STATE.Pause) {
			
			Pause.render(g);
			g.dispose();
		
		} 
		else if (gameState == STATE.GameOver) {
			
			GameOver.render(g);
			g.dispose();
		
		}
		else if (gameState == STATE.Win) {
			
			Win.render(g);
			g.dispose();
		
		}
		////////////////////////////////////////////
		g2d.translate(-cam.getX(), -cam.getY());
		handler.render(g);
		g2d.translate(cam.getX(), cam.getY());
		
		
		bs.show();
		g.dispose();
	}
	
	
	//loading level	
	
	private synchronized void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int xx = 0; xx < w; xx++) {
			for(int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx,  yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				// int pink = (pixel) & 0xff;
				
				if(red == 255)
					handler.addObject(new Block( xx*32, yy*32, ID.Block));
				
				if(blue == 255 && green == 0)
					handler.addObject(new Player( xx*32, yy*32, ID.Player, input, handler, this));
				
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
