
public class TestA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] a = int2ByteArray(2);
		System.out.println(256>>8 & 0xff);	
	}
	
	public static int bytes2Int(byte[] bytes){
		int num = bytes[3] & 0xff;
		num |= ((bytes[2]<<8)&0xff00);
		num |= ((bytes[1]<<16)&0xff0000);
		num |= ((bytes[0]<<24)&0xff000000);
		return num;
	}
	
	public static byte[] int2ByteArray(int i){
		byte[] bytes = new byte[4];
		bytes[0]=(byte)((i>>24)&0xff);
		bytes[1]=(byte)((i>>16)&0xff);
		bytes[2]=(byte)((i>>8)&0xff);
		bytes[3]=(byte)(i&0xff);
		return bytes;
	}
}
