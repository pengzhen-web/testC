import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;


public class Provider {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		ServerSocket ss = new ServerSocket(1234);
		while(true){
			Socket sc = ss.accept();
			ObjectInputStream input = new ObjectInputStream(sc.getInputStream());
			String interfaceName = input.readUTF();
			String methodName = input.readUTF();
			Class<?>[] parameterTypes = (Class<?>[])input.readObject();
			Object[] arguments = (Object[])input.readObject();
			
			Class serviceinterfaceclass = Class.forName(interfaceName);
			TestSocket t = new TestSocket();
			Object service = t.new SayHelloServiceImpl();
			
			Method method = serviceinterfaceclass.getMethod(methodName, parameterTypes);
			Object result = method.invoke(service, arguments);
			
			ObjectOutputStream os = new ObjectOutputStream(sc.getOutputStream());
			os.writeObject(result);
			System.out.println(result);
		}
		
	}
}
