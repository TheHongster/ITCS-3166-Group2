// import all necessary packages 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
	public static void main(String[] args) {
		//Declarations
		Main m = new Main();
		JFrame f1 = new JFrame("IP Router");   
	    	f1.setSize(400,400);  
	    	f1.setLayout(null);  
	    	f1.setVisible(true);  
		JFrame f2 = new JFrame("Edit Routing Table Info");
			f2.setSize(200,200);  
			f2.setLayout(null);  
			f2.setVisible(false); 
	    TextField tfIP = new TextField();
	    	tfIP.setBounds(105,105,150,20);
	    TextField tfSubnetMask = new TextField();
	    	tfSubnetMask.setBounds(105,105,150,20);
	    	
	    Button bSendData = new Button("Send Data");    
	    	bSendData.setBounds(105,155,60,30);  
	    	bSendData.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			m.IPAddress = tfIP.getText();
	    		}
	    	});
	    	
	    Button bEditData = new Button("Edit Data");
	    	bEditData.setBounds(195,155,60,30);
	    	bEditData.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			f2.setVisible(true); 
	    		}
	    	});
	    //Frame formatting
		f1.add(bSendData);f1.add(bEditData);f1.add(tfIP); 

		//Logic
		/*
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
		*/
        
	}
}

