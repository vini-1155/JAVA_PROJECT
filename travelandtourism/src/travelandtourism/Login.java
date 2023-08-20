package travelandtourism;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	
	JButton fpass, signup, login;
	JTextField tusername, tpassword;
	public String username;
	Login(){
		super("Login page");
		setSize(750, 350);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(130, 190, 210));
		p1.setBounds(0, 0, 360, 350);
		p1.setLayout(null);
		p1.setBorder(new LineBorder(new Color(130, 190, 210)));
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		JLabel image = new JLabel(i3);
		image.setBounds(90, 100, 150, 100);
		p1.add(image);
		
		
		JPanel p2 = new JPanel();
		p2.setBounds(360, 0, 410, 350);
		p2.setBackground(Color.pink);
		p2.setLayout(null);
		p2.setBorder(new LineBorder(Color.pink));
		add(p2);
		
		JLabel username = new JLabel("Username");
		username.setBounds(50, 30, 200, 30);
		username.setFont(new Font("SAN SERIF", Font.PLAIN,20));
		p2.add(username);
		
		tusername = new JTextField();
		tusername.setBounds(50, 70, 220, 25);
		tusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tusername);
		
		JLabel lpassword = new JLabel("Password");
		lpassword.setBounds(50, 120, 200, 25);
		lpassword.setFont(new Font("San Serif", Font.PLAIN, 20));
		p2.add(lpassword);
		
		tpassword = new JTextField();
		tpassword.setBounds(50, 150, 220, 25);
		tpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tpassword);
		
		login = new JButton("Login");
		login.setBounds(60, 220, 80, 25);
		login.setBackground(new Color(130, 190, 210));
		login.setForeground(Color.white);
//		login.setBorder(BorderFactory.createEmptyBorder());
		login.setBorder(new LineBorder(new Color(130, 190, 210)));
		login.addActionListener(this);
		p2.add(login);
		
		signup = new JButton("SignUp");
		signup.setBounds(200, 220, 80, 25);
		signup.setBackground(new Color(130, 190, 210));
		signup.setForeground(Color.white);
		signup.setBorder(new LineBorder(new Color(130, 190, 210)));
		signup.addActionListener(this);
		p2.add(signup);
		
		fpass = new JButton("Forget Password");
		fpass.setBounds(120, 260, 100, 25);
		fpass.setBorder(new LineBorder(new Color(130, 190, 210)));
		fpass.setForeground(Color.white);
		fpass.setBackground(new Color(130, 190, 210));
		fpass.addActionListener(this);
		p2.add(fpass);
		
		JLabel tsin = new JLabel("Trouble in sign..");
		tsin.setBounds(250, 260, 100, 25 );
		tsin.setForeground(Color.red);
		p2.add(tsin);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fpass) {
			setVisible(false);
			new Forgotpass();
		}else if(e.getSource() == signup) {
			setVisible(false);
			new Signup();
		}else if(e.getSource() == login) {
			
			try {
				String query = "select * from account where username = '"+tusername.getText()+"' and password = '"+tpassword.getText()+"'"; 
				
				Conn c = new Conn();
				ResultSet rs = c.st.executeQuery(query);
				if(rs.next()) {
					username = tusername.getText();
					setVisible(false);
					new Loadin(username);
				}else {
					JOptionPane.showMessageDialog(null, "User id or password is incorrect!!");
				}
							
			}catch(Exception ae) {
				ae.printStackTrace();
				System.out.println(ae);
			}
		}
		
	}

}
