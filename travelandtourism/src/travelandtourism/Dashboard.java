package travelandtourism;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*;
@SuppressWarnings("serial")
public class Dashboard extends JFrame implements ActionListener{
	
	JButton addpd, viewd ,checkpk, bookpk, viewpk,viewht, desti, bookht, viewbookht, payment, notepad, calc, about,dltpd,uppd;
	String username;
	Dashboard(String username){
		this.username = username;
		setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 2000, 75);
		p1.setBackground(new Color(00, 100, 100));
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 60, Image.SCALE_DEFAULT);
		ImageIcon i3 = new  ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 10, 100, 60);
		p1.add(image);
		
		JLabel dashboard = new JLabel("Dashboard");
		dashboard.setBounds(130, 10, 400, 60);
		dashboard.setFont(new Font("Tahoma", Font.BOLD, 40));
		dashboard.setForeground(Color.white);
		p1.add(dashboard);
		
		JPanel p2 = new JPanel();
		p2.setBounds(0, 75, 400, 1000);
		p2.setBackground(new Color(00, 100, 100));
		p2.setLayout(null);
		
		add(p2);
		
		addpd = new JButton("Add personal Details");
		addpd.setBounds(0,0, 400, 60);
		addpd.setForeground(Color.WHITE);
		addpd.setBackground((new Color(00, 100, 100)));
//		addpd.setBorder(BorderFactory.createEmptyBorder());
		addpd.setFont(new Font("Yohoma", Font.BOLD, 30));
		addpd.addActionListener(this);
		p2.add(addpd);
		
		uppd = new JButton("Update Personal Details");
		uppd.setBounds(0,60, 400, 60);
		uppd.setForeground(Color.WHITE);
		uppd.setBackground((new Color(00, 100, 100)));
		uppd.setBorder(BorderFactory.createEmptyBorder());
		uppd.setFont(new Font("Yohoma", Font.BOLD, 30));
		uppd.addActionListener(this);
		p2.add(uppd);
		
		viewd = new JButton("View Details");
		viewd.setBounds(0,120, 400, 60);
		viewd.setForeground(Color.WHITE);
		viewd.setBackground((new Color(00, 100, 100)));
//		viewd.setBorder(BorderFactory.createEmptyBorder());
		viewd.addActionListener(this);
		viewd.setFont(new Font("Yohoma", Font.BOLD, 30));
		p2.add(viewd);
		
		dltpd = new JButton("Delete Personal Details");
		dltpd.setBounds(0,180, 400, 60);
		dltpd.setForeground(Color.WHITE);
		dltpd.setBackground((new Color(00, 100, 100)));
		dltpd.setFont(new Font("Yohoma", Font.BOLD, 30));
		dltpd.addActionListener(this);
		//		dltpd.setBorder(BorderFactory.createEmptyBorder());
		p2.add(dltpd);
		
		checkpk = new JButton("Check Package");
		checkpk.setBounds(0,240, 400, 60);
		checkpk.setForeground(Color.WHITE);
		checkpk.setBackground((new Color(00, 100, 100)));
//		checkpk.setBorder(BorderFactory.createEmptyBorder());
		checkpk.addActionListener(this);
		checkpk.setFont(new Font("Yohoma", Font.BOLD, 30));
		p2.add(checkpk);
		
		bookpk = new JButton("Book Package");
		bookpk.setBounds(0,300, 400, 60);
		bookpk.setForeground(Color.WHITE);
		bookpk.setBackground((new Color(00, 100, 100)));
//		bookpk.setBorder(BorderFactory.createEmptyBorder());
		bookpk.setFont(new Font("Yohoma", Font.BOLD, 30));
		bookpk.addActionListener(this);
		p2.add(bookpk);
		
		viewpk = new JButton("View Package");
		viewpk.setBounds(0,360, 400, 60);
		viewpk.setForeground(Color.WHITE);
		viewpk.setBackground((new Color(00, 100, 100)));
		viewpk.setFont(new Font("Yohoma", Font.BOLD, 30));
//		viewpk.setBorder(BorderFactory.createEmptyBorder());
		viewpk.addActionListener(this);
		p2.add(viewpk);
		
		viewht = new JButton("View Hotel");
		viewht.setBounds(0,420, 400, 60);
		viewht.setForeground(Color.WHITE);
		viewht.setBackground((new Color(00, 100, 100)));
		viewht.setFont(new Font("Yohoma", Font.BOLD, 30));
		viewht.addActionListener(this);
//		viewht.setBorder(BorderFactory.createEmptyBorder());
		p2.add(viewht);
		
		bookht = new JButton("Book Hotel");
		bookht.setBounds(0,480, 400, 60);
		bookht.setForeground(Color.WHITE);
		bookht.setBackground((new Color(00, 100, 100)));
//		bookht.setBorder(BorderFactory.createEmptyBorder());
		bookht.addActionListener(this);
		bookht.setFont(new Font("Yohoma", Font.BOLD, 30));
		p2.add(bookht);
		
		viewbookht = new JButton("View Booked Hotel");
		viewbookht.setBounds(0,540, 400, 60);
		viewbookht.setForeground(Color.WHITE);
		viewbookht.setBackground((new Color(00, 100, 100)));
//		viewbookht.setBorder(BorderFactory.createEmptyBorder());
		viewbookht.addActionListener(this);
		viewbookht.setFont(new Font("Yohoma", Font.BOLD, 30));
		p2.add(viewbookht);
		
		desti = new JButton("Destination");
		desti.setBounds(0,600, 400, 60);
		desti.setForeground(Color.WHITE);
		desti.setBackground((new Color(00, 100, 100)));
		desti.setFont(new Font("Yohoma", Font.BOLD, 30));
		desti.addActionListener(this);
		p2.add(desti);
		
		payment = new JButton("Payments");
		payment.setBounds(0,660, 400, 60);
		payment.setForeground(Color.WHITE);
		payment.setFont(new Font("Yohoma", Font.BOLD, 30));
		payment.setBackground((new Color(00, 100, 100)));
//		payment.setBorder(BorderFactory.createEmptyBorder());
		payment.addActionListener(this);
		p2.add(payment);
		
		calc = new JButton("Calculator");
		calc.setBounds(0,720, 400, 60);
		calc.setForeground(Color.WHITE);
		calc.setBackground((new Color(00, 100, 100)));
		calc.setFont(new Font("Yohoma", Font.BOLD, 30));
		calc.addActionListener(this);
//		calc.setBorder(BorderFactory.createEmptyBorder());
		p2.add(calc);
		
		notepad = new JButton("Notepad");
		notepad.setBounds(0,780, 400, 60);
		notepad.setForeground(Color.WHITE);
		notepad.setBackground((new Color(00, 100, 100)));
//		notepad.setBorder(BorderFactory.createEmptyBorder());
		notepad.setFont(new Font("Yohoma", Font.BOLD, 30));
		notepad.addActionListener(this);
		p2.add(notepad);
		
		 about = new JButton("About");
		about.setBounds(0,840, 400, 60);
		about.setForeground(Color.WHITE);
		about.setBackground((new Color(00, 100, 100)));
		about.setFont(new Font("Yohoma", Font.BOLD, 30));
		about.addActionListener(this);
//		about.setBorder(new LineBorder((new Color(00, 100, 100) )));
		p2.add(about);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new  ImageIcon(i5);
		JLabel imageh = new JLabel(i6);
		imageh.setBounds(400, 75, 1600, 1000);
		add(imageh);
		
		
		JLabel tnts = new JLabel("Travel and Tourism System");
		tnts.setSize(1000, 60);
		tnts.setLocation(350, 100);
		
		tnts.setFont(new Font("Tahoma", Font.BOLD, 60));
		tnts.setForeground(new Color(70, 70, 250));
		imageh.add(tnts);
		
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dashboard("vi");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addpd) {
			setVisible(false);
			new Addaccount(username);
		}else if(e.getSource() == viewd) {
			setVisible(false);
			System.out.println("This is dashbord to view customer "+username);
			new ViewCustomer(username);
		}else if(e.getSource() == checkpk) {
			new CheckPackage();
		}else if(e.getSource() == bookpk) {
			setVisible(false);
			new BookPackage(username);
		}else if(e.getSource() == viewpk) {
			setVisible(false);
			new ViewPackage(username);
		}else if(e.getSource() == viewht) {
			new CheckHotels();
		}else if(e.getSource() == desti) {
			new Destination();
		}else if(e.getSource() == bookht) {
			setVisible(false);
			new BookHotel(username);
		}else if(e.getSource() == viewbookht) {
			setVisible(false);
			new ViewBookedHotel(username);
		}else if(e.getSource() == payment) {
			new Payment();
		}else if(e.getSource() == calc) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception ae) {
				
			}
		}else if(e.getSource() == notepad) {
			try {
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception ae) {
				
			}
		}else if(e.getSource() == about) {
			new About();
		}
		else if(e.getSource() == dltpd) {
			setVisible(false);
			try {
				new DeleteDetails(username);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == uppd) {
			setVisible(false);
			new UpdateCustomer(username);
		}
		
		
		
		
	}
		
	}


