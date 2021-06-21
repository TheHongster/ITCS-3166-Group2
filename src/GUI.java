// import all necessary packages 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	String interface0 = "";
	String interface1 = "";
	String router1 = "";
	String router2 = "Default";
	public GUI(){
		//Declarations
		Main m = new Main();
		JFrame f1 = new JFrame("IP Router");
	    	f1.setSize(400,400);
	    	f1.setLayout(new BorderLayout()); 
	    	f1.setLocationRelativeTo(null); 
	    	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame f2 = new JFrame("Edit Routing Table Info");
			f2.setSize(400,300);  
			f2.setLayout(null);  
			f2.setLocationRelativeTo(null);
			f2.setVisible(false);
			f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Frame1 Elements
		JPanel p1 = new JPanel();
		JPanel consoleLog = new JPanel();
			consoleLog.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel tfPanel1 = new JPanel();
		JPanel btnPanel1 = new JPanel();
		JTextArea taConsole = new JTextArea(15,30);
			taConsole.setEditable(false);
			
		JScrollPane scroll = new JScrollPane(taConsole);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    JTextField tfIP = new JTextField(25);
	    JButton bSendData = new JButton("Send Data");
	    	bSendData.setBounds(100,100,20,20);
	    	bSendData.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			m.IPAddress = tfIP.getText();
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
	    			if(m.networkAddress.equals(interface0)) {
	    				taConsole.append("IP: " + m.IPAddress + " will route to " + "Interface 0: " + interface0 + "\n");
	    			}
	    			else if(m.networkAddress.equals(interface1)) {
	    				taConsole.append("IP: " + m.IPAddress + " will route to " + "Interface 1: " + interface1 + "\n");
	    			}
	    			else if(m.networkAddress.equals(router1)) {
	    				taConsole.append("IP: " + m.IPAddress + " will route to " + "Router 1: " + router1 + "\n");
	    			}
	    			else {
	    				taConsole.append("IP: " + m.IPAddress + " will route to " + "Router 2: " + router2 + "\n");
	    			}
	    			
	    		}
	    	});
	    	
	    JButton bEditData = new JButton("Edit Data");
	    	bEditData.setBounds(100,100,20,20);
	    	bEditData.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			f2.setVisible(true); 
	    		}
	    	});
	    //Frame2 Elements
	    JLabel lSubnetMask = new JLabel("Subnet Mask:");
	    	lSubnetMask.setBounds(50,25,100,20);
		JTextField tfSubnetMask = new JTextField(m.subnetMask);
	    	tfSubnetMask.setBounds(150,25,125,20);
	    	
	    JLabel lInterface0 = new JLabel("Interface 0:");
	    	lInterface0.setBounds(50,50,100,20);
	    JTextField tfInterface0 = new JTextField(interface0);
	    	tfInterface0.setBounds(150,50,125,20);
	    	
	    JLabel lInterface1 = new JLabel("Interface 1:");
	    	lInterface1.setBounds(50,75,100,20);
	    JTextField tfInterface1 = new JTextField(interface1);
	    	tfInterface1.setBounds(150,75,125,20);
	    	
	    JLabel lRouter1 = new JLabel("Router 1:");
	    	lRouter1.setBounds(50,100,100,20);
	    JTextField tfRouter1 = new JTextField(router1);
	    	tfRouter1.setBounds(150,100,125,20);
	    
	    JLabel lRouter2 = new JLabel("Router 2:");
	    	lRouter2.setBounds(50,125,100,20);
	    JTextField tfRouter2 = new JTextField(router2);
	    	tfRouter2.setBounds(150,125,125,20);
	    JButton bApplyChanges = new JButton("Apply Changes");
	    	bApplyChanges.setBounds(125,200,150,30);
	    	bApplyChanges.addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    			interface0 = tfInterface0.getText();
	    			interface1 = tfInterface1.getText();
	    			router1 = tfRouter1.getText();
	    			router2 = tfRouter2.getText();
	    			m.subnetMask = tfSubnetMask.getText();
	    			f2.dispose();
	    		}
	    	});
	    	//Frame1 formatting
	    	tfPanel1.add(tfIP);
	    	btnPanel1.add(bSendData);btnPanel1.add(bEditData);
	    	consoleLog.add(scroll);
	    	p1.add(tfPanel1, BorderLayout.PAGE_START);
	    	p1.add(btnPanel1, BorderLayout.CENTER);
	    	p1.add(scroll, BorderLayout.PAGE_END);
	    	f1.add(p1);
	    	f1.setVisible(true);
	    	//Frame2 formatting
	    	f2.add(lSubnetMask);f2.add(tfSubnetMask);
	    	f2.add(lInterface0);f2.add(tfInterface0);
	    	f2.add(lInterface1);f2.add(tfInterface1);
	    	f2.add(lRouter1);f2.add(tfRouter1);
	    	f2.add(lRouter2);f2.add(tfRouter2);
	    	f2.add(bApplyChanges);
	}
	public static void main(String[] args) {
		new GUI();
	}
}