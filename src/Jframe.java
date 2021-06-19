
import javax.swing.*;
import java.awt.*;

public class Jframe {

	private static Component emptyLabel;

	public static void main(String[] args) {
		
		
		
		
		JFrame frame = new JFrame("FrameDemo");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

		frame.pack();

		frame.setVisible(true);

		
		frame.setTitle("IP Router Function");
		
		frame.setBounds(null);
		
        JButton button = new JButton();  

        button.setText("");  
		
		
		

	}

}
