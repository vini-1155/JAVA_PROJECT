package travelandtourism;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Signup extends JFrame implements ActionListener{

	JButton create, back;
	JTextField tuser, tname,tpass, tans;
	Choice   txtsec;
	Signup(){
		
		setSize(900, 340);
		setLocationRelativeTo(null);
//		setLocation(300, 400);
//		setBounds(350, 200, 900, 340);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 350);
		p1.setBackground(new Color(120, 190, 210));
		p1.setLayout(null);
		add(p1);
		
		JLabel luser = new JLabel("Username");
		luser.setBounds(50, 20, 100, 25);
		luser.setForeground(Color.black);
		luser.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(luser);
		
		 tuser = new JTextField();
		tuser.setBounds(300, 20, 200, 25);
		tuser.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tuser);
		
		JLabel lname = new JLabel("Name");
		lname.setBounds(50, 70, 100, 25);
		lname.setForeground(Color.black);
		lname.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lname);
		
		tname = new JTextField();
		tname.setBounds(300, 70, 200, 25);
		tname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tname);
		
		JLabel lpass = new JLabel("Password");
		lpass.setBounds(50, 110, 100, 25);
		lpass.setForeground(Color.black);
		lpass.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lpass);
		
		 tpass = new JTextField();
		tpass.setBounds(300, 110, 200, 25);
		tpass.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tpass);
		
		JLabel lsec = new JLabel("Security Question");
		lsec.setBounds(50, 150,200, 25);
		lsec.setForeground(Color.black);
		lsec.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lsec);
		
	     txtsec = new Choice();
		txtsec.setBounds(300, 150, 200, 25);
		txtsec.add("Fav Charater from The boys");
		txtsec.add("Fav Marvel Character");
		txtsec.add("Your lucky number");
		txtsec.add("Your Childhood superhero");
		
		p1.add(txtsec);
		
		JLabel lans = new JLabel("Answer");
		lans.setBounds(50, 200, 100, 25);
		lans.setForeground(Color.black);
		lans.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lans);
		
		 tans = new JTextField();
		tans.setBounds(300, 200, 200, 25);
		tans.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tans);
		
		 create = new JButton("Create");
		create.setBounds(80, 260, 100, 25);
		create.setBackground(Color.white);
		create.setForeground(new Color(133, 193, 213));
		create.setBorder(BorderFactory.createEmptyBorder());
		create.addActionListener(this);
		p1.add(create);
		
		back = new JButton("Back");
		back.setBounds(260, 260, 100, 25);
		back.setBackground(Color.white);
		back.setForeground(new Color(133, 193, 213));
		back.setBorder(BorderFactory.createEmptyBorder());
		back.addActionListener(this);
		p1.add(back);
		
		JPanel p2 = new JPanel();
		p2.setBounds(600, 0 , 300, 350);
		p2.setBackground(Color.white);
		p2.setLayout(null);
		add(p2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("signup.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 250, 250);
		p2.add(image);
		

		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Signup();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == create) {
			String username = tuser.getText();
			String name = tname.getText();
			String password = tpass.getText();
			String question = txtsec.getSelectedItem();
			String answer = tans.getText();
				
			String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
		
			try {
				Conn c = new Conn();
				 c.st.executeUpdate(query);// execute Mysql query
				 
				 JOptionPane.showMessageDialog(null, "Acccount created successfully");
				 setVisible(false);
				 new Login();
				
			}catch(Exception ea) {
				ea.printStackTrace();
			}
		
		}else if(e.getSource() == back) {
			setVisible(false);
			new Login();
		}
		
	}

}
