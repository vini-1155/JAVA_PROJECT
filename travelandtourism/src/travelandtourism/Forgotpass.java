package travelandtourism;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
@SuppressWarnings("serial")
public class Forgotpass extends JFrame implements ActionListener{

		JLabel luser,lname, lsec, lans, lpass;
		JTextField tuser, tname, tsec, tans, tpass;
		JButton search, retrive, back;
		Forgotpass(){			
			setSize(900, 350);
			setLocationRelativeTo(null);
			setLayout(null);
			getContentPane().setBackground(Color.white);
			
			JPanel p1 = new JPanel();
			p1.setBounds(20, 20, 500, 260);
			p1.setLayout(null);
			add(p1);
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("forgotpassword.jpg"));
			Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT );
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(600, 50, 200, 200);
			add(image);
			
			luser = new JLabel("Username");
			luser.setBounds(40, 20, 100, 25);
			luser.setForeground(Color.black);
			p1.add(luser);
			
			tuser = new JTextField();
			tuser.setBounds(180, 20, 150, 25);
			tuser.setBorder(BorderFactory.createEmptyBorder());
			tuser.setBackground(Color.white);
			p1.add(tuser);
			
			search = new JButton("Search");
			search.setBounds(350, 20, 100, 25);
			search.setBorder(BorderFactory.createEmptyBorder());
			search.setBackground(Color.gray);
			search.setForeground(Color.white);
			search.addActionListener(this);
			p1.add(search);
			
			lname = new JLabel("Name");
			lname.setBounds(40, 60, 100, 25);
			lname.setForeground(Color.black);
			p1.add(lname);
			
			tname = new JTextField();
			tname.setBounds(180, 60, 150, 25);
			tname.setBorder(BorderFactory.createEmptyBorder());
			tname.setBackground(Color.white);
			p1.add(tname);
			
			lsec = new JLabel("Your Security Key");
			lsec.setBounds(40, 100, 100, 25);
			lsec.setForeground(Color.black);
			p1.add(lsec);
			
			tsec = new JTextField();
			tsec.setBounds(180, 100, 150, 25);
			tsec.setBorder(BorderFactory.createEmptyBorder());
			tsec.setBackground(Color.white);
			p1.add(tsec);
			
			lans = new JLabel("Answer");
			lans.setBounds(40, 140, 100, 25);
			lans.setForeground(Color.black);
			p1.add(lans);
			
			tans = new JTextField();
			tans.setBounds(180, 140, 150, 25);
			tans.setBorder(BorderFactory.createEmptyBorder());
			tans.setBackground(Color.white);
			p1.add(tans);
			
			retrive = new JButton("Retrive");
			retrive.setBounds(350, 140, 100, 25);
			retrive.setBorder(BorderFactory.createEmptyBorder());
			retrive.setBackground(Color.gray);
			retrive.setForeground(Color.white);
			retrive.addActionListener(this);
			p1.add(retrive);
			
			lpass = new JLabel("Password");
			lpass.setBounds(40, 180, 100, 25);
			lpass.setForeground(Color.black);
			p1.add(lpass);
			
			tpass = new JTextField();
			tpass.setBounds(180, 180, 150, 25);
			tpass.setBorder(BorderFactory.createEmptyBorder());
			tpass.setBackground(Color.white);
			p1.add(tpass);
			
			back = new JButton("Back");
			back.setBounds(130, 220, 100, 25);
			back.setBorder(BorderFactory.createEmptyBorder());
			back.setBackground(Color.gray);
			back.setForeground(Color.white);
			back.addActionListener(this);
			p1.add(back);
				
			setVisible(true);
			
		}
	public static void main(String[] args) {
		new Forgotpass();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == search) {
			try {
				String query  = "Select * from account where username = '"+tuser.getText()+"'";	
				Conn c = new Conn();
				ResultSet rs = c.st.executeQuery(query);
				
				while(rs.next()) {
					tname.setText(rs.getString("name"));
					tsec.setText(rs.getString("security"));			
				}
				
			}catch(Exception ee) {
				ee.printStackTrace();
			}
			
			
			
			
		}else if(e.getSource()== retrive) {
			try {
				String query  = "Select * from account where username = '"+tuser.getText()+"' and answer = '"+tans.getText()+"' ";	
				Conn c = new Conn();
				ResultSet rs = c.st.executeQuery(query);
				
				while(rs.next()) {
					tpass.setText(rs.getString("password"));		
				}
				
			}catch(Exception ee) {
				ee.printStackTrace();
			}
			
		}else if(e.getSource() == back) {
			setVisible(false);
			new Login();
		}
		
	}

}
