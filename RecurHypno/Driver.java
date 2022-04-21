package RecurHypno;
import java.awt.Color;
import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		//Creates the panel and renders it to the screen
		MySimplePanel panel = new MySimplePanel(800, 800, Color.lightGray);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);  
		frame.pack();
		frame.setVisible(true); 
	}
}
