package snake;
import javax.swing.*;

@SuppressWarnings("serial")
public class Snakegame extends JFrame{
	Snakegame(){
		super("Snake Game ");
		
		add(new Board());
		pack();
		
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Snakegame();

	}

}
