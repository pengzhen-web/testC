import java.lang.reflect.Method;

public class TestSocket {
	public interface SayHelloService{
		public String sayHello(String args);
	}
	public class SayHelloServiceImpl implements SayHelloService{
		@Override
		public String sayHello(String args) {
			if(args.equals("hello")){
				return "hello everybody";
			}else{
				return " bye ";
			}
		}
	}
	
}
