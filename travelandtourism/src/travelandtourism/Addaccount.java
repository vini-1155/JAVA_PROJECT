package travelandtourism;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class Addaccount extends JFrame implements ActionListener{
	
	JComboBox<?> choice;
	JRadioButton male, female;
	JButton add, back;
	JTextField tuser, tname, tnum, taddr, temail, tpho, tcount;
	ButtonGroup gender;	
	String username;
	
	Addaccount(String username){
		this.username= username; 
		setSize(800, 600);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.white);
		
		JLabel lusername = new JLabel("Username");
		lusername.setBounds(40, 50, 100, 20);
		lusername.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(lusername);
		
		tuser = new JTextField();
		tuser.setBounds(200, 50, 100, 20);
		tuser.setBorder(BorderFactory.createEmptyBorder());
		add(tuser);
		
		JLabel ldoc = new JLabel("Documents");
		ldoc.setBounds(40, 100, 100, 20);
		ldoc.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(ldoc);
		
		choice = new JComboBox<Object>(new String[] {"Aadhar Card", "Pan card", "Passport", "Ration Card"});
		choice.setBounds(200, 100, 100, 20);
		choice.setBackground(Color.white);
		add(choice);
		
		JLabel lnum = new JLabel("Number");
		lnum.setBounds(40, 150, 100, 20);
		lnum.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(lnum);
		
		tnum = new JTextField();
		tnum.setBounds(200, 150, 100, 20);
		tnum.setBorder(new LineBorder((Color.black)));
		add(tnum);
		
		JLabel lname = new JLabel("Name");
		lname.setBounds(40, 200, 100, 20);
		lname.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(lname);
		
		tname = new JTextField();
		tname.setBounds(200, 200, 100, 20);
		tname.setBorder(new LineBorder(Color.black));
		add(tname);
		
		JLabel lgen = new JLabel("Gender");
		lgen.setBounds(40, 250, 100, 20);
		lgen.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(lgen);
		
		male = new JRadioButton("Male");
		male.setBounds(200, 250, 60, 20);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(300, 250, 100, 20);
		female.setBackground(Color.white);
		add(female);
		
		
		
		gender = new ButtonGroup();
		gender.add(female);
		gender.add(male);
		
		
		JLabel lcount = new JLabel("Country");
		lcount.setBounds(40, 300, 100, 20);
		lcount.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(lcount);
		
		tcount = new JTextField();
		tcount.setBounds(200, 300, 100, 20);
		tcount.setBorder(new LineBorder(Color.black));
		add(tcount);
		
		JLabel laddr = new JLabel("Address");
		laddr.setBounds(40, 350, 100, 20);
		laddr.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(laddr);
		
		taddr = new JTextField();
		taddr.setBounds(200, 350, 100, 20);
		taddr.setBorder(new LineBorder(Color.black));
		add(taddr);
		
		JLabel lpho = new JLabel("Phone Number");
		lpho.setBounds(40, 400, 100, 20);
		ldoc.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(lpho);
		
		tpho = new JTextField();
		tpho.setBounds(200, 400, 100, 20);
		tpho.setBorder(new LineBorder(Color.black));
		add(tpho);
		
		JLabel lemail = new JLabel("Email");
		lemail.setBounds(40, 450, 100, 20);
		lemail.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		add(lemail);
		
		temail = new JTextField();
		temail.setBounds(200, 450, 100, 20);
		temail.setBorder(new LineBorder(Color.black));
		add(temail);
		
		add = new JButton("Add");
		add.setBackground(Color.black);
		add.setBounds(60, 500, 100, 30);
		add.setForeground(Color.white);
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setBounds(220, 500, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("newcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 10, 400, 600);
		add(image);
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.st.executeQuery("Select * from account where username = '"+username+"'");
			
			while(rs.next()) {
				tuser.setText(rs.getString("username"));
				tname.setText(rs.getString("name"));
			}
		}catch(Exception ae) {
			
		}
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Addaccount(" ");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if( ae.getSource() == add) {
			 String username = tuser.getText();
			 String name = tname.getText();
			 String number = tnum.getText();
			 String address = taddr.getText();
			 String email = temail.getText();
			 String phone = tpho.getText();
			 String id = (String)choice.getSelectedItem();
			 String country = tcount.getText();
			 String gender = null;
			 
			 if(male.isSelected()) {
				 gender = "Male";
			 }else {
				 gender = "Female";
			 }
			 
			 try {
				 Conn c = new Conn();
				 String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"');";
				 c.st.executeUpdate(query);
				 
				 JOptionPane.showMessageDialog(null, "Cutomer Details Added Successfully");
				 setVisible(false);
				 new Dashboard(username);
			 }catch(Exception aae) {
				 aae.printStackTrace();
			 }
			 
		 }else if(ae.getSource() == back) {
			 setVisible(false);
			 new Dashboard(username);
		 }
		
	}
	
	

}
