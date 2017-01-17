import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Md5Test {

	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] b = new byte[1];
		b[0] = -1;
		System.out.println(bytes2hex(b));
		
	}

	private static String bytes2hex(byte[] bytes){
		StringBuilder  hex = new StringBuilder();
		for(int i=0; i<bytes.length; i++){
			byte b = bytes[i];
			boolean negative = false;
			if(b<0) negative = true;
			int inte = Math.abs(b);
			if(negative){
				inte = inte | 0x80;
			}
			System.out.println(inte & 0xFF);
			String temp = Integer.toHexString(inte & 0xFF);
			if(temp.length() == 1){
				hex.append("0");
			}
			hex.append(temp.toLowerCase());
		}
		return hex.toString();
	}
	
	private static byte[] hex2bytes(String hex){
		byte[] bytes = new byte[hex.length()/2];
		for(int i=0; i<hex.length(); i=i+2){
			String subStr = hex.substring(i,i+2);
			boolean negative = false;
			int inte = Integer.parseInt(subStr,16);
			if(inte > 127) negative = true;
			if(inte ==128){
				inte = -128;
			}else if(negative){
				inte = 0 - (inte & 0x7F);
			}
			byte b = (byte)inte;
			bytes[i/2] = b;
		}
		return bytes;
	}
}
