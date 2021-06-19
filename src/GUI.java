// import all necessary packages 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//declare public abstract class to provide framework of GUI implementation 
public abstract class GUI implements ActionListener {
	//declare main method
	public static void main(String[] args) {
		
		//declare main m as a new main
		Main m = new Main();
		
		//Logic
		//utilize methods to convert binary octets as defined in the methodology for both the IPAdress and the subnetMask
		m.IPAddressBinary = m.convertToBinaryOctets(m.IPAddress);
		m.subnetMaskBinary = m.convertToBinaryOctets(m.subnetMask);
			for(int i = 0; i < 4; i++) {//Assigns IPAddressBinary's values to networkAddressBinary values
				m.networkAddressBinary[i] = m.IPAddressBinary[i];
			}
			//calculates the binary network address given the two parameters
		m.calcBinaryNetworkAddress(m.networkAddressBinary, m.subnetMaskBinary);
		//provides the conversion results given the designated parameter
		m.networkAddress = m.convertToDecimalAddress(m.networkAddressBinary);

		//declare a new JFrame f with text:  "ActionListener Example" as field
		JFrame f = new JFrame("ActionListener Example");  
		//declare textField tf as new object of TextField()
	    TextField tf = new TextField();  
	    //Defines the x and y values for size and positioning of the boundaries 
	    tf.setBounds(105,105,150,20);  
	    //Declare a new button object B with the text message that reads "Click Here"
	    Button b=new Button("Click Here");  
	    //Sets the values for the boundaries of the button
	    b.setBounds(50,100,60,30);
	    //Utilizes the addActionListener method using the ActionListener object as a parameter
	    b.addActionListener(new ActionListener() {
	    	//declare public void for action performed with the parameter of Action Event e
	    	public void actionPerformed(ActionEvent e) {
	    		//Display text welcoming the user 
	    		tf.setText("Welcome to Javatpoint."); 
	    	
	    	}
	    });
	    //format the overall frame through methods of naming it, setting its size, creating its layout/visibility, and adding the fields of b and tf
	    f.add(b);f.add(tf);  
	    f.setTitle("IP Router");
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
        
	}
}

