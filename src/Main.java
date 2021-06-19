/*
 * 
 * @author Aaron Hong and Lynden Hill
 * Group Project for ITCS-3166 at the University of North Carolina, Charlotte
 */
public class Main {
	//Variables
	String IPAddress = "";
	String subnetMask = "";
	String networkAddress = "";
	String[] IPAddressBinary = new String[4];
	String[] subnetMaskBinary = new String[4];
	String[] networkAddressBinary = new String[4];
	
	public String toBinary(int numDecimal) {//converts decimal -> binary
		String numBinary = Integer.toBinaryString(numDecimal);
		return numBinary;
	}
	
	public int toDecimal(String numBinary) {//converts binary -> decimal
		int numDecimal = Integer.parseInt(numBinary,2);
		return numDecimal;
	}
	
	public String[] convertToBinaryOctets(String address){//converts IP address to binary form with each octet stored in the index of a size 4 array
		String[] octetArray = address.split("\\.");
		String[] newAddress = new String[4];
		String temp;
		int j = 0;
		for (String string : octetArray){
		    int octet = Integer.parseInt(string);
		    String binaryOctet = Integer.toBinaryString(octet);
		    temp = binaryOctet;
		    if(temp.length() != 8) {//if binary octet does not have 8 chars, add leading 0's
		    	for(int i = 0; i < (8-binaryOctet.length()); i++) {
		    		temp = "0" + temp;
		    	}
		    }
		    newAddress[j] = temp;
		    j++;
		}
		return newAddress;
	}
	
	public void calcBinaryNetworkAddress(String[] addressBinary, String[] maskBinary){//compares IPAddressBinary to subnetMaskBinary and changes array's values based on subnetMask
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				if(maskBinary[i].charAt(j) == '1') {//if bit of subnetMaskBinary's octet is 1, skip over changing bit of IPAddressBinary's octet
					continue;
				}
				else {//store octet in char tempArray, changes bit value at position j to '0', stores char octet back into addressBinary array as combined string
					char[] tempArray = addressBinary[i].toCharArray();
					tempArray[j] = '0';
					addressBinary[i] = String.valueOf(tempArray);
				}
			}
		}
	}
	public String convertToDecimalAddress(String[] addressBinary) {//converts addressBinary array into decimal address string
		String decAddress = "";
		for(int i = 0; i < 4; i++) {
			if(i == 3) {
				decAddress = decAddress + String.valueOf(toDecimal(addressBinary[i]));
				break;
			}
			decAddress = decAddress + String.valueOf(toDecimal(addressBinary[i])) + ".";
		}
		return decAddress;
	}
	public void debugPrintBinaryOctets(String[] address) {//debug to print out binary octets stored in arrays
		for(int i = 0; i < 4; i++) {
			System.out.println(address[i]);
		}
	}
}
/*Reference example on getting Network Address:
address		10000111 00101110 00111111 00001010		135.46.63.10
mask		11111111 11111111 11111100 00000000		255.255.252.0
(AND)		-----------------------------------		-------------
network		10000111 00101110 00111100 00000000		135.46.60.0
 */
