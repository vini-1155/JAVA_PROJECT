package travelandtourism;
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Splash extends JFrame implements Runnable{
	Thread thread;
	Splash(){
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("splash.jpg"));
		
		Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		
		add(image);
		
		setVisible(true);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
//		try {
//			Thread.sleep(3000);
//			setVisible(false);
//	}catch (Exception e){
//		
//	}
	}

	public static void main(String[] args) {
		Splash frame = new Splash();
		int x = 1;
		for(int i =1 ; i<= 500;x+=4, i++) {
			frame.setLocation(700 - (i/2 + 20) , 400 - (i/4 + 20));
			frame.setSize((i+x)/2 - 30, i +(x/9) - 100);
		}

	}

}
