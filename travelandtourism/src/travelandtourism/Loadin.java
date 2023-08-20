package travelandtourism;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Loadin extends JFrame implements Runnable{

	Thread t;
	JProgressBar bar;
	String username;
	Loadin(String username){
		this.username = username;
		t = new Thread((Runnable)this);
		
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel ltnt = new JLabel("Travel and Tourism");
		ltnt.setBounds(150, 20, 400, 30);
		ltnt.setForeground(Color.ORANGE);
		ltnt.setFont(new Font("SERIF", Font.BOLD, 35));
		add(ltnt);
		
		bar = new JProgressBar();
		bar.setBounds(170, 75, 250, 25);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel lpw = new JLabel("Loading Please wait...");
		lpw.setBounds(220, 105, 200, 20);
		lpw.setForeground(Color.red);
		lpw.setFont(new Font("SERIF", Font.BOLD, 14));
		add(lpw);
		
		
		JLabel luser = new JLabel("Welcome "+ username);
		luser.setBounds(40, 320, 200, 20);
		luser.setForeground(Color.red);
		luser.setFont(new Font("SERIF", Font.BOLD, 14));
		add(luser);
		t.start();
		
		setVisible(true);	
	}
	
	
	public static void main(String[] args) {
//		new Loadin(username);

	}
	@Override
	public void run() {
		try {
			for(int i = 1; i<= 101; i++) {
				int max = bar.getMaximum();
				int value = bar.getValue();
				
				if(value < max) {
					bar.setValue(bar.getValue() + 1);
				}else {
					setVisible(false);
					new Dashboard(username);
				}
				
				
				Thread.sleep(20);
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
