package Amain;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import gameObjects.Constants;
import graphics.Assets;
import input.KeyBoard;
import input.MouseInput;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import states.LoadingState;
import states.MenuState;
import states.State;


public class Window extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private Canvas canvas;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private final int FPS = 60;
	private double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	private int AVERAGEFPS = FPS;
	
	private KeyBoard keyBoard;
	private MouseInput mouseInput;
        
        private BufferedImage imgFondo;
	
	public Window()
	{
		setTitle("Nave espacial");
		setSize(Constants.WIDTH, Constants.HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		canvas = new Canvas();
		keyBoard = new KeyBoard();
		mouseInput = new MouseInput();
		
		canvas.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setMaximumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setMinimumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		canvas.setFocusable(true);
		
		add(canvas);
		canvas.addKeyListener(keyBoard);
		canvas.addMouseListener(mouseInput);
		canvas.addMouseMotionListener(mouseInput);
		setVisible(true);
                
                try {
            File archivo = new File("src/imgObjetos/image.jpg");
            imgFondo = ImageIO.read(archivo);
                    System.err.println("Archivo encontrado: " + archivo.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
	
	

	public static void main(String[] args) {
		new Window().start();
	}
	
	
	private void update(){
		keyBoard.update();
		State.getCurrentState().update();
	}

	private void draw(){
		bs = canvas.getBufferStrategy();
		
		if(bs == null)
		{
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		//-----------------------
		g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
		
		g.drawImage(imgFondo, 0, 0, this);
			
		State.getCurrentState().draw(g);
		
		g.setColor(Color.WHITE);
		
		g.drawString(""+AVERAGEFPS, 10, 20);
		
		//---------------------
		
		g.dispose();
		bs.show();
	}
	
	private void init()
	{
		
		Thread loadingThread = new Thread(new Runnable() {

			@Override
			public void run() {
				Assets.init();
			}
		});
		
		
		
		State.changeState(new LoadingState(loadingThread));
	}
	
	
	@Override
	public void run() {
		
		long now = 0;
		long lastTime = System.nanoTime();
		int frames = 0;
		long time = 0;
		
		init();
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime)/TARGETTIME;
			time += (now - lastTime);
			lastTime = now;
			
			
			
			if(delta >= 1)
			{		
				update();
				draw();
				delta --;
				frames ++;
			}
			if(time >= 1000000000)
			{
				AVERAGEFPS = frames;
				frames = 0;
				time = 0;
				
			}
			
			
		}
		
		stop();
	}
	
	private void start(){
		
		thread = new Thread(this);
		thread.start();
		running = true;
		
		
	}
	private void stop(){
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}