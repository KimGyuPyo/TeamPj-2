package maintest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Currency;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	// SCREEN 세팅
	final int originalTilesize = 32;
	final int scale = 1;
	
	public final int tileSize = originalTilesize * scale;
	
	public final int maxScreenCol = 40;
	public final int maxScreenRow = 40;
	public final int screenWidth = tileSize * maxScreenCol; // 1280
	public final int screenHeight = tileSize * maxScreenRow; // 1280
	
	// fps 설정
	int FPS =10; // 조작감을 위해 값을 바꿀 필요가 있음
	
	// 시스템
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Sound sound = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public ObjSetter oSetter = new ObjSetter(this);
	Thread gameThread;
	
	// 엔티티랑 오브젝트
	Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[10];

	
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);		
	}
	
	public void setupGame() {
		
		oSetter.SetObject();
		
		playMusic(0);
	}

	public void startGameThread() {		
		gameThread = new Thread(this);
		gameThread.start();
	}

/* sleep 방식
 * 
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; //0.0166초
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			
			// 정보 갱신 캐릭터 위치 같은것
			update();
						
			
			// 맵 그리는것
			repaint(); // paintComponent 메소드가 호출되는 방식???????;
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
*/// 델타 방식
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();				
				repaint();
				delta--;
			}

		}
	}
	
	public void update() { // * 48을 해서 칸마다 문직이는 느낌을 줌
		
		player.update();
	}

	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		for(int i = 0 ; i < obj.length ; i++ ) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}			
		}
		
		player.draw(g2);
		
		g2.dispose();
	}
	public void playMusic(int i) {
		
		sound.setFile(i);
		sound.play();
		sound.loop();
	}
	
	public void stopMusic() {
		
		sound.stop();
	}
	
	public void playSE(int i) {
		
		sound.setFile(i);
		sound.play();
	}
}