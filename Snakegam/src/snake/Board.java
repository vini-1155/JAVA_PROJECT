package snake;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{
	private Image apple;
	private Image dot;
	private Image head;
	
	private final int ALL_dots = 900;
	private final int DOT_SIZE = 10;
	private final int RANDOM_POSITION = 25;
	
	private int apple_x;
	private int apple_y;
	
	private final int x[] = new int[ALL_dots];
	private final int y[] = new int[ALL_dots];
	
	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean downDirection = false;
	private boolean upDirection = false;
	
	private int dots;
	private Timer timer;
	
	private boolean inGame = true;
	
	Board(){
		
		addKeyListener(new TAdapter());
		
		setBackground(Color.black);
		setFocusable(true);
		setPreferredSize(new Dimension(400, 400));
		
		loadImages();
		initGame();
	}
	
	public void loadImages() {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("snake/icons/apple.png"));
		apple = i1.getImage();
		
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("snake/icons/dot.png"));
		dot = i2.getImage();
		
		ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("snake/icons/head.png"));
		head = i3.getImage();
		
		
	}
	
	public void initGame() {
		dots = 3;
		
		for(int i = 0; i<dots; i++) {		
			y[i] = 50;					// y[0,1,2] = 50
			x[i] = 50 - i * DOT_SIZE;  	// x[0,1,2] = 50, 40, 30
		}
		
		locateApple();
		timer = new Timer(140, this);
		timer.start();
		
		
	}
	public void locateApple() {
		int r = (int) (Math.random() *RANDOM_POSITION);
		apple_x = r * DOT_SIZE;
		
		 r = (int)(Math.random() * RANDOM_POSITION);
		apple_y = r * DOT_SIZE;
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(inGame) {
			checkApple();
			checkCollusion();
			move();
		}
		
		repaint();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		draw(g);
	}

	public void draw(Graphics g) {
		
		if(inGame) {
			g.drawImage(apple,apple_x, apple_y,this);
			
			for(int i = 0; i< dots; i++) {
				if(i == 0) {
					g.drawImage(head,x[i], y[i], this );
					
				}
				else {
					g.drawImage(dot, x[i], y[i], this);
				}
				
			}
			Toolkit.getDefaultToolkit().sync();
		}else {
			gameOver(g);
		}
		
	}
	
	public void gameOver(Graphics g) {
		String msg = "Game Over";
		Font font = new Font("SAN SARIF", Font.BOLD, 14);
		FontMetrics metrics = getFontMetrics(font);
		g.setColor(Color.WHITE);	
		g.drawString(msg, (300 - metrics.stringWidth(msg))/2, 300/2);
	}

	public void move() {
		for(int i = dots ; i>0 ; i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		if(leftDirection) {
			x[0] -= DOT_SIZE;
		}
		
		if(rightDirection) {
			x[0] += DOT_SIZE;
		}
		if(upDirection) {
			y[0] -= DOT_SIZE;
		}
		if(downDirection) {
			y[0] += DOT_SIZE;
		}		
	}
	
	public void checkApple() {
		
		if((x[0] == apple_x) && (y[0] == apple_y)) {
			dots++;
			locateApple();
		}
	}
	
	public void checkCollusion() {
		
		for(int i = dots; i> 0 ; i--) {	
			if (( i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
		}
		if(y[0] >= 300 || x[0] >= 300 || y[0] < 0 || x[0] < 0) {
			inGame = false;
		}
		
//		if() {
//			inGame = false;
//		}
//		
//		if() {
//			inGame = false;
//		}
//		if() {
//			inGame = false;
//		}
		
		
		
		if(!inGame) {
			timer.stop();
		}
		
	}
	
	
	
	
	public class TAdapter extends KeyAdapter{
		@Override
		public void  keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_LEFT  && (!rightDirection)) {
				leftDirection = true;
				upDirection = false;
				downDirection = false;
			}
			
			if(key == KeyEvent.VK_RIGHT  && (!leftDirection)) {
				rightDirection = true;
				upDirection = false;
				downDirection = false;
			}
			
			if(key == KeyEvent.VK_UP  && (!downDirection)) {
				leftDirection = false;
				rightDirection = false;
				upDirection = true;
			}
			
			if(key == KeyEvent.VK_DOWN  && (!upDirection)) {
				leftDirection = false;
				rightDirection = false;
				downDirection = true;
			}
		}
	}

}
