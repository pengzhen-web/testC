import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

public class Consumer {
		String interfaceName = TestSocket.SayHelloService.class.getName();
		Class<?> clazz = TestSocket.SayHelloService.class;
		public void fun() throws SecurityException, NoSuchMethodException, UnknownHostException, IOException, ClassNotFoundException{
			Method method = clazz.getMethod("sayHello", java.lang.String.class);
			Object[] arguments = {"hello"};
			Socket socket = new Socket("127.0.0.1",1234);
			ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
			os.writeUTF(interfaceName);
			os.writeUTF(method.getName());
			os.writeObject(method.getParameterTypes());
			os.writeObject(arguments);
			
			ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
			Object result = is.readObject();
			System.out.println(result);
		}
		public static void main(String[] args) throws SecurityException, UnknownHostException, NoSuchMethodException, IOException, ClassNotFoundException{
			Consumer c = new Consumer();
			c.fun();
		}
}
