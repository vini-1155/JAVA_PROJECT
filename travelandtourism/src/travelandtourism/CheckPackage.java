package travelandtourism;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CheckPackage extends JFrame{

	CheckPackage(){
		
		setSize(830, 510);
		setLocationRelativeTo(null);
		
		String[] package1 = {"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assiteance", "Half day City Tour", "Daily Buffet", "Soft Drinks Free", "Full Day 3 island", " English Speaking Guide"," Book Package ","Summer Special", "RS 1200/-", "package1.jpg"};
		String[] package2 = {"SILVER PACKAGE", "5 Days and 6 Nights", "Assiteance", "Half day City", "Buffet", " Drinks Free", "Full Day 3 ",  " Speaking Guide", " Book Package ","Winter Special", "Rs 14000" ,"package2.jpg"};
		String[] package3 = {"BRONZE PACKAGE", "4 Days and 3 Nights", "Airport ", "Half day Tour", "Daily ", "Soft Drinks", " Day 3 island",  " English Speaking ", " Book Package ","Monsoon Special", "Rs 20000", "package3.jpg"};
		
		
		JTabbedPane tab = new JTabbedPane();
		
		JPanel p1 = createPackage(package1);	
		tab.addTab("Package 1", null, p1);
		
		JPanel p2 = createPackage(package2);	
		tab.addTab("Package 1", null, p2);
		
		JPanel p3 = createPackage(package3);	
		tab.addTab("Package 1", null, p3);
		
		add(tab);
		
		

		
		setVisible(true);
	}
	
	public JPanel createPackage(String[] pack){
		
//		PACKAGE 1
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(50, 0, 300, 40);
		l1.setForeground(new Color(24, 121, 190));
		l1.setFont(new Font("Tohona", Font.BOLD, 30));
		p1.add(l1);
		
		JLabel l2 = new JLabel(pack[1]);
		l2.setBounds(30, 50, 300, 30);
		l2.setForeground(new Color(24, 11, 190));
		l2.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l2);
		
		JLabel l3 = new JLabel(pack[2]);
		l3.setBounds(30, 100, 300, 30);
		l3.setForeground(new Color(124, 111, 159));
		l3.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l3);
		

		JLabel l4 = new JLabel(pack[3]);
		l4.setBounds(30, 150, 300, 30);
		l4.setForeground(new Color(24, 11, 190));
		l4.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l4);
		
		JLabel l5 = new JLabel(pack[4]);
		l5.setBounds(30, 200, 300, 30);
		l5.setForeground(new Color(124, 111, 159));
		l5.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l5);
		
		JLabel l6 = new JLabel(pack[5]);
		l6.setBounds(30, 250, 300, 30);
		l6.setForeground(new Color(24, 11, 190));
		l6.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l6);
		
		JLabel l7 = new JLabel(pack[6]);
		l7.setBounds(30, 300, 300, 30);
		l7.setForeground(new Color(124, 111, 159));
		l7.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l7);
		
		JLabel l8 = new JLabel(pack[7]);
		l8.setBounds(50, 350, 300, 30);
		l8.setForeground(Color.black);
		l8.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l8);
		
		JLabel l9 = new JLabel(pack[8]);
		l9.setBounds(100, 400, 300, 30);
		l9.setForeground(new Color(60, 60, 60));
		l9.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l9);
		
		JLabel l10 = new JLabel(pack[9]);
		l10.setBounds(300, 400, 300, 30);
		l10.setForeground(new Color(60, 60, 60));
		l10.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l10);
		
		JLabel l11 = new JLabel(pack[10]);
		l11.setBounds(500, 400, 300, 30);
		l11.setForeground(new Color(60, 60, 60));
		l11.setFont(new Font("Tohona", Font.BOLD, 20));
		p1.add(l11);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""+pack[11]));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 =  new ImageIcon(i2);
		JLabel i4 = new JLabel(i3);
		i4.setBounds(400, 20, 400, 300);
		p1.add(i4);
		
		return p1;
	}
	
	public static void main(String[] args) {
		new CheckPackage();

	}

}
