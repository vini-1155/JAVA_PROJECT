package travelandtourism;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class ViewCustomer extends JFrame implements ActionListener{
	
	
	JButton back;
	String username;
	ViewCustomer(String username){
		this.username = username;
		setSize(850, 750);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JLabel luser = new JLabel("Username");
		luser.setBounds(50, 50, 100, 25);
		luser.setForeground(Color.black);
		luser.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(luser);
		
		tuser = new JTextField();
		tuser.setBounds(200, 50, 100, 25);
		tuser.setBorder(BorderFactory.createEmptyBorder());
		add(tuser);
		
		JLabel ldoc = new JLabel("Documents");
		ldoc.setBounds(50, 100, 100, 25);
		ldoc.setForeground(Color.black);
		ldoc.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(ldoc);
		
		tdoc = new JTextField();
		tdoc.setBounds(200, 100, 100, 25);
		tdoc.setBorder(BorderFactory.createEmptyBorder());
		add(tdoc);
		
		JLabel lnum = new JLabel("Number ");
		lnum.setBounds(50, 150, 100, 25);
		lnum.setForeground(Color.black);
		lnum.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(lnum);
		
		tnum = new JTextField();
		tnum.setBounds(200, 150, 100, 25);
		tnum.setBorder(BorderFactory.createEmptyBorder());
		add(tnum);
		
		JLabel lname = new JLabel("Name");
		lname.setBounds(50, 200, 100, 25);
		lname.setForeground(Color.black);
		lname.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(lname);
		
		tname = new JTextField();
		tname.setBounds(200, 200, 100, 25);
		tname.setBorder(BorderFactory.createEmptyBorder());
		add(tname);
		
		JLabel lgender = new JLabel("Gender ");
		lgender.setBounds(50, 250, 100, 25);
		lgender.setForeground(Color.black);
		lgender.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(lgender);
		
		tgender = new JTextField();
		tgender.setBounds(200, 250, 100, 25);
		tgender.setBorder(BorderFactory.createEmptyBorder());
		add(tgender);
		
		JLabel lcountry = new JLabel("Country");
		lcountry.setBounds(500, 50, 100, 25);
		lcountry.setForeground(Color.black);
		lcountry.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(lcountry);
		
		tcountry = new JTextField();
		tcountry.setBounds(700, 50, 100, 25);
		tcountry.setBorder(BorderFactory.createEmptyBorder());
		add(tcountry);
		
		JLabel laddress = new JLabel("Address");
		laddress.setBounds(500, 100, 100, 25);
		laddress.setForeground(Color.black);
		laddress.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(laddress);
		
		taddress = new JTextField();
		taddress.setBounds(700, 100, 100, 25);
		taddress.setBorder(BorderFactory.createEmptyBorder());
		add(taddress);
		
		JLabel lphone = new JLabel("Phone");
		lphone.setBounds(500, 150, 100, 25);
		lphone.setForeground(Color.black);
		lphone.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(lphone);
		
		tphone = new JTextField();
		tphone.setBounds(700, 150, 100, 25);
		tphone.setBorder(BorderFactory.createEmptyBorder());
		add(tphone);
		
		JLabel lemail = new JLabel("Email");
		lemail.setBounds(500, 200, 100, 25);
		lemail.setForeground(Color.black);
		lemail.setFont(new Font("SERIF", Font.ITALIC, 20));
		add(lemail);
		
		temail = new JTextField();
		temail.setBounds(700, 200, 100, 25);
		temail.setBorder(BorderFactory.createEmptyBorder());
		add(temail);
		
		back = new JButton("Back");
		back.setBounds(300, 330, 100, 25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 430, 870, 300);
		add(image);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.st.executeQuery("Select * from customer where username = '"+username+"'");
			while(rs.next()) {
				tuser.setText(rs.getString("username"));
				tdoc.setText(rs.getString("id"));
				tnum.setText(rs.getString("number"));
				tname.setText(rs.getString("name"));
				tgender.setText(rs.getString("gender"));
				tcountry.setText(rs.getString("country"));
				taddress.setText(rs.getString("address"));
				tphone.setText(rs.getString("phone"));
				temail.setText(rs.getString("email"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	JTextField tuser,tdoc,tnum, tname, tgender, tcountry, taddress, tphone, temail;
	public static void main(String[] args) {
		new ViewCustomer("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			setVisible(false);
			new Dashboard(username);
			
		}
		
	}

}
